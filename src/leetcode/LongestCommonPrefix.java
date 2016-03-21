package leetcode;

public class LongestCommonPrefix {
	// https://leetcode.com/problems/longest-common-prefix/
	// 字符串数组最长公共前缀
	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		String result = "";
		result = strs[0];
		int length = strs.length;

		int len = 0;
		for (int i = 0; i < length; i++) {
			if (result.length() == 0 || strs[i].length() == 0) {
				return "";
			}
			len = result.length() < strs[i].length() ? result.length() : strs[i].length();
			int j = 0;
			for (j = 0; j < len; j++) {
				if (strs[i].charAt(j) != result.charAt(j)) {
					break;
				}
			}
			result = result.substring(0, j);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {};
		System.out.println(longestCommonPrefix(strs));
	}
}
