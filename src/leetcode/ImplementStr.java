package leetcode;

public class ImplementStr {

	// https://leetcode.com/problems/implement-strstr/
	// Accept
	public static int strStr(String haystack, String needle) {
		if (needle.length() == 0) {
			return 0;
		}

		if (haystack.length() == 0 || needle.length() > haystack.length()) {
			return -1;
		}

		for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
			int j = 0;
			for (; j < needle.length(); j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					break;
				}
			}
			System.out.println("j -> " + j + " ; needle.length() -> " + needle.length());
			if (j == needle.length()) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "a";
		String match = "a";
		System.out.println(strStr(test, match) + "");
	}

}
