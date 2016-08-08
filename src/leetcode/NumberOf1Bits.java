package leetcode;

public class NumberOf1Bits {

	// https://leetcode.com/problems/number-of-1-bits
	// easy,相关题CountingBits
	public static int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			count += (n & 1);
			n = n >>> 1;// 无符号右移
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(hammingWeight(3) + "");
	}

}
