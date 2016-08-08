package leetcode;

public class ReverseBits {

	// https://leetcode.com/problems/reverse-bits/
	// 主要思路是32位数分为前16位与后16位，低位从前向后遍历，高位从后向前遍历，不同的时候交换
	public static int reverseBits(int n) {

		int INT_SIZE = Integer.SIZE;

		for (int i = 0; i < INT_SIZE / 2; i++) {
			int j = INT_SIZE - 1 - i;

			int low = (n >> i) & 1;
			int high = (n >> j) & 1;

			int A = 1 << i;
			int B = 1 << j;

			// http://articles.leetcode.com/reverse-bits
			if ((high ^ low) == 1) {// XOR==1说明两位上的数字不同
				n = n ^ (A | B);
			}
		}
		return n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("answer -> " + reverseBits(1));
	}

}
