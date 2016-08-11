package huawei;

import java.util.Scanner;

/**
 * 计算字符串的距离
 * 
 * @author han
 *
 */
public class MidDistanceString {

	public static int[][] memoizedDistance;// 记录子问题的解,0表示子问题未求解

	private static int calMinValue(int a, int b, int c) {
		return a < b ? (a < c ? a : c) : (b < c ? b : c);
	}

	public static int calStringDistance(String str1, String str2) {
		int distance = -1;
		if (str1 != null && str2 != null) {
			int len1 = str1.length();
			int len2 = str2.length();
			if (len1 == 0) {
				return len2;
			}
			if (len2 == 0) {
				return len1;
			}
			memoizedDistance = new int[len1 + 1][len2 + 1];
			// 初始话距离数组
			for (int i = 0; i <= len1; i++) {
				for (int j = 0; j <= len2; j++) {
					memoizedDistance[i][j] = -1;
				}
			}
			distance = calStringDistance(str1, 0, len1 - 1, str2, 0, len2 - 1);
		}
		return distance;
	}

	private static int calStringDistance(String strA, int pABegin, int pAEnd, String strB, int pBBegin, int pBEnd) {
		if (memoizedDistance[pABegin][pBBegin] >= 0) {
			return memoizedDistance[pABegin][pBBegin];
		}

		if (pABegin > pAEnd) {// 字符串A到了结尾
			if (pBBegin > pBEnd) {// 字符串B也到了结尾
				memoizedDistance[pABegin][pBBegin] = 0;
				return 0;
			} else {
				int temp = pBEnd - pBBegin + 1;
				memoizedDistance[pABegin][pBBegin] = temp;
				return temp;
			}
		}

		if (pBBegin > pBEnd) {// 字符串B到了结尾
			if (pABegin > pAEnd) {// 字符串A也到了结尾
				memoizedDistance[pABegin][pBBegin] = 0;
				return 0;
			} else {
				int temp = pAEnd - pABegin + 1;
				memoizedDistance[pABegin][pBBegin] = temp;
				return temp;
			}
		}

		if (strA.substring(pABegin, pABegin + 1).equals(strB.substring(pBBegin, pBBegin + 1))) {
			int temp = calStringDistance(strA, pABegin + 1, pAEnd, strB, pBBegin + 1, pBEnd);
			memoizedDistance[pABegin][pBBegin] = temp;
			return temp;
		} else {
			int t1 = calStringDistance(strA, pABegin + 1, pAEnd, strB, pBBegin + 1, pBEnd);
			int t2 = calStringDistance(strA, pABegin, pAEnd, strB, pBBegin + 1, pBEnd);
			int t3 = calStringDistance(strA, pABegin + 1, pAEnd, strB, pBBegin, pBEnd);

			int temp = calMinValue(t1, t2, t3) + 1;// 一定要加1
			memoizedDistance[pABegin][pBBegin] = temp;
			return temp;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String str1 = scanner.next();
			String str2 = scanner.next();
			System.out.println(calStringDistance(str1, str2));
		}
		scanner.close();
	}

}
