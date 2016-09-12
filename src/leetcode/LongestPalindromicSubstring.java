package leetcode;

public class LongestPalindromicSubstring {

	// 最长回文字符串
	// https://leetcode.com/problems/longest-palindromic-substring/

	// 方法一,最简单的方法,两侧比较法O(N^3)
	public static String longestPalindrome(String s) {
		// TODO Auto-generated constructor stub
		int maxPalinLength = 0;
		String longestPalindrome = null;
		int length = s.length();

		// check all possible sub strings
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) { // 遍历
				int len = j - i;
				String curr = s.substring(i, j + 1);
				if (isPalindrome(curr)) {
					if (len > maxPalinLength) {
						longestPalindrome = curr;
						maxPalinLength = len;
					}
				}
			}
		}

		return longestPalindrome;
	}

	/**
	 * 判断是否是回文
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isPalindrome(String s) {

		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}

		return true;
	}

	/************************** 华丽的分割线 ********************************/
	// 方法二,动态规划法O(N^2)
	/*
	 * 假设dp[ i ][ j ]的值为true，表示字符串s中下标从 i 到 j 的字符组成的子串是回文串。那么可以推出： dp[ i ][ j ]
	 * = dp[ i + 1][ j - 1] && s[ i ] == s[ j ]。 这是一般的情况，由于需要依靠i+1, j -1，所以有可能 i
	 * + 1 = j -1, i +1 = (j - 1) -1，因此需要求出基准情况才能套用以上的公式： a. i + 1 = j
	 * -1，即回文长度为1时，dp[ i ][ i ] = true; b. i +1 = (j - 1) -1，即回文长度为2时，dp[ i ][ i
	 * + 1] = （s[ i ] == s[ i + 1]）。 有了以上分析就可以写出代码了。需要注意的是动态规划需要额外的O(n2)的空间
	 */
	public static String longestPalindrome2(String s) {
		if (s == null)
			return null;

		if (s.length() <= 1)
			return s;

		int maxLen = 0;
		String longestStr = null;

		int length = s.length();

		int[][] table = new int[length][length];

		// every single letter is palindrome
		for (int i = 0; i < length; i++) {
			table[i][i] = 1;
		}
		printTable(table);

		// e.g. bcba
		// two consecutive same letters are palindrome
		for (int i = 0; i <= length - 2; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				table[i][i + 1] = 1;
				longestStr = s.substring(i, i + 2);
			}
		}
		//printTable(table);
		// condition for calculate whole table
		for (int l = 3; l <= length; l++) {
			for (int i = 0; i <= length - l; i++) {
				int j = i + l - 1;
				if (s.charAt(i) == s.charAt(j)) {
					table[i][j] = table[i + 1][j - 1];
					if (table[i][j] == 1 && l > maxLen)
						longestStr = s.substring(i, j + 1);
				} else {
					table[i][j] = 0;
				}
				printTable(table);
			}
		}

		return longestStr;
	}

	public static void printTable(int[][] x) {
		for (int[] y : x) {
			for (int z : y) {
				System.out.print(z + " ");
			}
			System.out.println();
		}
		System.out.println("------");
	}

	/************************** 华丽的分割线 ********************************/
	// PASS!!!
	// http://blog.csdn.net/soszou/article/details/37312317
	// 中心扩展法Time O(n^2) Space O(1)
	public static String longestPalindrome3(String s) {
		if (s.isEmpty()) {
			return null;
		}

		if (s.length() == 1) {
			return s;
		}

		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length(); i++) {
			// test [i]
			String tmp = helper(s, i, i);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}

			// test s[i,i+1]
			tmp = helper(s, i, i + 1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}
		return longest;
	}

	// [begin, end]
	public static String helper(String s, int begin, int end) {
		while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		return s.substring(begin + 1, end);
	}

	public static void main(String agrs[]) {
		String str = "BCCBP";
		System.out.println(longestPalindrome2(str));
	}

}
