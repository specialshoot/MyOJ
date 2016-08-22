package note;

import java.util.Scanner;

/**
 * http://blog.csdn.net/liu_005/article/details/51058486
 * 给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
 * 输出需要删除的字符个数。
 * 
 * 输入描述:
 * 输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.
 * 
 * 输出描述:
 * 对于每组数据，输出一个整数，代表最少需要删除的字符个数。
 * 
 * 输入例子:
 * abcda
 * google
 * 
 * 输出例子:
 * 2
 * 2
 * 
 * @author han
 *
 */

/**
 * 找出最长公共子序列
 * 
 * @author han
 *
 */
public class LCSRealiseTencent {
	private static final int MAXLENGTH = 1000;
	private static String maxSubstring = "";
	private static Scanner scanner;

	public static void main(String[] args) {
		// 运用动态规划方法求解LCS时，需要一个数组记录当前的最长公共子序列，这里用c[][]表示
		// 还需要一个数组记录搜索方向，这里用b[][]表示
		int[][] c = new int[MAXLENGTH][MAXLENGTH];
		int[][] b = new int[MAXLENGTH][MAXLENGTH];

		scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			maxSubstring = "";// 为了保证上一次处理结果不影响本次处理，需要将该字符串置空

			String input1 = scanner.nextLine();
			String input2 = new StringBuffer(input1).reverse().toString();// 将输入字符串反转

			int length1 = input1.length();
			int length2 = input2.length();

			LCSLength(input1, input2, c, b);

			maxSubstring = getMaxSubString(length1, length2, b, input1.toCharArray());
			System.out.println(maxSubstring);
		}
	}

	// 找出最长公共子序列
	public static void LCSLength(String input1, String input2, int[][] c, int[][] b) {
		// 初始化c[][]
		for (int m = 0; m < input1.length(); m++) {
			for (int n = 0; n < input2.length(); n++) {
				c[m][n] = 0;
			}
		}

		// 将两个字符串转换成字符数组进行处理
		char[] inputChar1 = input1.toCharArray();
		char[] inputChar2 = input2.toCharArray();

		for (int i = 1; i <= inputChar1.length; i++) {
			for (int j = 1; j <= inputChar2.length; j++) {
				if (inputChar1[i - 1] == inputChar2[j - 1])// 当两个字符相同时，取写对角的c加上1，且置b为0
				{
					c[i][j] = c[i - 1][j - 1] + 1;
					b[i][j] = 0;
				} else if (c[i - 1][j] >= c[i][j - 1])// 当两个字符不相同且正上方c大于左边c，则c等于正上方c加上1，且置b为1
				{
					c[i][j] = c[i - 1][j];
					b[i][j] = 1;
				} else// 当两个字符不相同且正上方c小于左边c，则c等于左边c加上1，且置b为-1
				{
					c[i][j] = c[i][j - 1];
					b[i][j] = -1;
				}
			}
		}
	}

	// 返回最长公共子序列
	public static String getMaxSubString(int m, int n, int[][] b, char[] input1) {
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
}
