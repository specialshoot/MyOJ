package offer;

/**
 * 不用加减乘除做加法 用位运算
 * 
 * 二进制的加法用位运算来替换。
 * 第一步不考虑进位对每一位相加。0+0，1+1的结果都是0，1+0的结果是1。0+1的结果是1，我们注意到这和异或的结果是一样的。
 * 对异或而言，0和0，1和1异或的结果是0，而0和1，1和0的异或结果是1.
 * 接着考虑第二步进位，对0+0，0+1，1+0而言，都不会产生进位，只有1+1时，会向前差生一个进位。
 * 此时我们可以想象成是两个数先做位运算，然后再向前左移动一位。 只有两个数都是1的时候。第三步相加的过程是重复前面的两步，直到不产生进位为止。
 * 
 * @author han
 *
 */
public class Offer47 {

	public static int getPlus(int num1, int num2) {
		int carry = 0;// 进位
		int sum = 0;
		do {
			sum = num1 ^ num2;
			carry = (num1 & num2) << 1;
			num1 = sum;
			num2 = carry;
		} while (num2 != 0);
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPlus(23, 45));
	}

}
