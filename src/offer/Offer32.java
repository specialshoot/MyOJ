package offer;

/**
 * 从1到n整数中1出现的次数
 * 
 * @author han
 *
 */
public class Offer32 {

	/**
	 * 方法1,穷举法
	 */
	public static int numberOf1BetweenAndN(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += numberOf1(i);
		}
		return sum;
	}

	public static int numberOf1(int num) {
		int sum = 0;
		while (num != 0) {
			if (num % 10 == 1) {
				++sum;
			}
			num /= 10;
		}
		return sum;
	}

	/************************ 华丽的分割线 *************************/
	/**
	 * 方法2
	 * 编程之美
	 * http://blog.csdn.net/sjf0115/article/details/8600599
	 * @param n
	 * @return
	 */
	public static int numberOf1BetweenAndN2(int n) {
		int count = 0;// 1的个数
		int Factor = 1;// 当前位
		int LowerNum = 0;// 低位数字
		int CurrNum = 0;// 当前位数字
		int HigherNum = 0;// 高位数字
		if (n <= 0) {
			return 0;
		}
		while (n / Factor != 0) {
			LowerNum = n - (n / Factor) * Factor;// 低位数字
			CurrNum = (n / Factor) % 10;// 当前位数字
			HigherNum = n / (Factor * 10);// 高位数字
			if (CurrNum == 0) {// 如果为0,出现1的次数由高位决定
				count += HigherNum * Factor;
			} else if (CurrNum == 1) {
				// 如果为1,出现1的次数由高位和低位决定
				count += HigherNum * Factor + LowerNum + 1;
			} else {
				// 大于1,出现1的次数由高位决定
				count += (HigherNum + 1) * Factor;
			}
			// 前移一位
			Factor *= 10;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numberOf1BetweenAndN2(12));
	}

}
