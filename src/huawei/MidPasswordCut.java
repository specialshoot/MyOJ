package huawei;

import java.util.Scanner;

/**
 * 字符串运用-密码截取
 * 
 * @author han
 *
 */
public class MidPasswordCut {

	private static String maxSubstring = "";// 最长字串

	private static void LCSLength(String input1, String input2, int[][] c, int[][] b) {

		// 将两个字符串转换成字符数组进行处理
		char[] inputChar1 = input1.toCharArray();
		char[] inputChar2 = input2.toCharArray();

		for (int i = 1; i <= inputChar1.length; i++) {
			for (int j = 1; j <= inputChar2.length; j++) {
				if (inputChar1[i - 1] == inputChar2[j - 1]) {// 当两个字符相同时，取写对角的c加上1，且置b为0
					c[i][j] = c[i - 1][j - 1] + 1;
					b[i][j] = 0;
				} else if (c[i - 1][j] >= c[i][j - 1]) {// 当两个字符不相同且正上方c大于左边c，则c等于正上方c加上1，且置b为1
					c[i][j] = c[i - 1][j];
					b[i][j] = 1;
				} else {// 当两个字符不相同且正上方c小于左边c，则c等于左边c加上1，且置b为-1
					c[i][j] = c[i][j - 1];
					b[i][j] = -1;
				}
			}
		}
	}

	/**
	 * 返回最长公共序列
	 * 
	 * @param m
	 * @param n
	 * @param b
	 * @param input1
	 * @return
	 */
	private static String getMaxSubString(int m, int n, int[][] b, char[] input1) {
		if (m == 0 || n == 0) {
			return "";
		}

		if (b[m][n] == 0) {
			getMaxSubString(m - 1, n - 1, b, input1);
			maxSubstring += input1[m - 1];
		} else if (b[m][n] == 1) {
			getMaxSubString(m - 1, n, b, input1);
		} else {
			getMaxSubString(m, n - 1, b, input1);
		}

		return maxSubstring;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			maxSubstring = "";
			String str1 = scanner.next();
			String str2 = new StringBuffer(str1).reverse().toString();
			int length = str1.length();
			int[][] c = new int[length + 1][length + 1];
			int[][] b = new int[length + 1][length + 1];
			LCSLength(str1, str2, c, b);
			int result = getMaxSubString(length, length, b, str1.toCharArray()).length();
			System.out.println(result);
		}
		scanner.close();
	}

}
