package huawei;

import java.util.Scanner;

/**
 * 最长公共字串(注意与最长公共子序列不同)
 * 
 * @author han
 *
 */
public class MidLongestSubString {

	public static String iQueryMaxCommString(String stringA, String stringB) {
		/* 在这里实现功能，将结果填入输入数组中 */
		if (stringA.length() > stringB.length()) {
			String s = stringA;
			stringA = stringB;
			stringB = s;
		}
		int lenA = stringA.length();
		int lenB = stringB.length();
		int[][] status = new int[lenA + 1][lenB + 1];
		for (int i = 0; i <= lenA; i++) {
			status[i][0] = 0;
		}
		for (int i = 0; i <= lenB; i++) {
			status[0][i] = 0;
		}
		int max = 0;
		int x = 0;// 最长字符串的节点

		for (int i = 1; i <= lenA; i++) {
			for (int j = 1; j <= lenB; j++) {
				if (stringA.charAt(i - 1) == stringB.charAt(j - 1)) {
					status[i][j] = status[i - 1][j - 1] + 1;
				} else {
					status[i][j] = 0;
				}
				if (status[i][j] > max) {
					max = status[i][j];// 记录最长的状态
					x = i;
				}
			}
		}
		return stringA.substring(x - max, x);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String a = scanner.nextLine();
			String b = scanner.nextLine();
			System.out.println(iQueryMaxCommString(a, b));
		}
		scanner.close();
	}

}
