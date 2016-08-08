package leetcode;

public class PalindromeNumber {

	// https://leetcode.com/problems/palindrome-number/
	public static boolean isPalindrome(int x) {
		int length = 0;
		int number = x;
		if (number < 0) {
			return false;
		}
		int[] numGroup = new int[10];
		if (number >= 0 && number <= 9) {
			return true;
		}

		while (number / 10 != 0) {
			numGroup[length] = number % 10;
			number /= 10;
			length++;
		}
		numGroup[length] = number;

		for (int i = 0; i < length / 2 + 1; i++) {
			if (numGroup[i] != numGroup[length - i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(-2147447412));
	}

}
