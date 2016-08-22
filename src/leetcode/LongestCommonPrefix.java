package leetcode;

public class LongestCommonPrefix {
	// https://leetcode.com/problems/longest-common-prefix/
	// 字符串数组最长公共前缀
	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		String result = "";
		result = strs[0];// 默认将第一个认为是最长共同字符串
		int length = strs.length;

		int len = 0;
		for (int i = 0; i < length; i++) {
			if (result.length() == 0 || strs[i].length() == 0) {
				return "";
			}
			len = result.length() < strs[i].length() ? result.length() : strs[i].length();// 将当前最长共同字符串和当前数组中的对比,把小的那个作为长度
			int j = 0;
			for (j = 0; j < len; j++) {
				// 逐个字符比较,不等的时候退出
				if (strs[i].charAt(j) != result.charAt(j)) {
					break;
				}
			}
			// 退出的j即当前的最小,整个遍历结束后就是整个的最小了
			result = result.substring(0, j);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"abcdefg","abc","abcd"};
		System.out.println(longestCommonPrefix(strs));
	}
}
