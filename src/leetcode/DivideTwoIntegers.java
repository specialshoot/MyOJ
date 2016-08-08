package leetcode;

public class DivideTwoIntegers {

	// https://leetcode.com/problems/divide-two-integers/

	// 最简单的方法,递减,时间复杂度太大,迭代次数是结果的大小，即比如结果为n，算法复杂度是O(n)
	// Time Limited
	public static int divide1(int dividend, int divisor) {

		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}
		boolean isNeg = false;
		if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
			isNeg = true;
		}
		if (dividend < 0) {
			dividend = -dividend;
		}

		if (divisor < 0) {
			divisor = -divisor;
		}

		if (dividend < divisor) {
			return 0;
		}

		int result = 0;

		while (dividend >= divisor) {
			dividend = dividend - divisor;
			result++;
		}

		return isNeg ? -result : result;
	}

	// Accept,按位取
	/**
	 * 我们知道任何一个整数可以表示成以2的幂为底的一组基的线性组合 即num=a_0*2^0+a_1*2^1+a_2*2^2+...+a_n*2^n。
	 * 基于以上这个公式以及左移一位相当于乘以2，我们先让除数左移直到大于被除数之前得到一个最大的基。
	 * 然后接下来我们每次尝试减去这个基，如果可以则结果增加2^k,然后基继续右移迭代，直到基为0为止。
	 * 因为这个方法的迭代次数是按2的幂直到超过结果，所以时间复杂度为O(logn)。
	 */
	public static int divide2(int dividend, int divisor) {

		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}
		boolean isNeg = (dividend ^ divisor) >>> 31 == 1;
		int res = 0;
		if (dividend == Integer.MIN_VALUE) {
			dividend += Math.abs(divisor);
			if (divisor == -1) {
				return Integer.MAX_VALUE;
			}
			res++;
		}
		if (divisor == Integer.MIN_VALUE) {
			return res;
		}
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		int digit = 0;
		while (divisor <= (dividend >> 1)) {
			divisor <<= 1; // 除数左移得到最大基
			digit++;
		}
		while (digit >= 0) {
			if (dividend >= divisor) {
				res += 1 << digit;
				dividend -= divisor;
			}
			divisor >>= 1;
			digit--;
		}
		return isNeg ? -res : res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide2(-2, -1) + "");
	}

}
