package leetcode;

public class BitwiseAndOfNumbersRange {

	// https://leetcode.com/problems/bitwise-and-of-numbers-range/
	// http://www.cnblogs.com/csonezp/p/4587392.html
	public static int rangeBitwiseAnd(int m, int n) {
		int bit = 0;
		while (m != n) {
			m >>= 1;
			n >>= 1;
			bit++;
		}
		return m << bit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(rangeBitwiseAnd(10, 15) + "");
	}

}
