package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {

	//https://leetcode.com/problems/fraction-to-recurring-decimal/
	/**
	 * Time Limit Exceeded 无法处理1234/9999这种
	 * 
	 * @param numerator
	 * @param denominator
	 * @return
	 */
	public static String fractionToDecimal(int numerator, int denominator) {
		if (denominator == 0) {
			return null;
		}
		if (numerator == 0) {
			return 0 + "";
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		String result = "";
		if (numerator < 0 ^ denominator < 0)
			result += '-';
		numerator = Math.abs(numerator);
		denominator = Math.abs(denominator);
		int temp = 0;
		if ((temp = numerator / denominator) != 0) {
			result += temp + "";
			if ((temp = numerator % denominator) == 0) {
				return result;
			} else {
				result += ".";
			}
		} else {
			temp = numerator % denominator;
			result += "0.";
		}
		while ((temp * 10 % denominator) != 0) {
			int mod = temp * 10 % denominator;
			int divide = temp * 10 / denominator;
			if (map.containsKey(mod)) {
				result = result.substring(0, result.length() - 1);
				result += "(" + divide + ")";
				return result;
			}
			result += divide + "";
			map.clear();
			map.put(mod, mod);
			temp = mod;
		}
		result += (temp * 10 / denominator) + "";
		return result;
	}

	public static String fractionToDecimal2(int numerator, int denominator) {
		long n = numerator, d = denominator;
		if (n == 0)
			return "0";

		StringBuffer a = new StringBuffer();
		if ((n < 0) ^ (d < 0))
			a.append("-");

		n = Math.abs(n);
		d = Math.abs(d);

		long in = n / d;
		a.append(String.valueOf(in)); // StringBuffer里面没有String的 a = a +

		if (n % d == 0) {
			return a.toString();
		} else {
			a.append(".");
		}
		// 以上是小数点以前的

		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		// 用hashmap查找循环的地方比较方便
		// System.out.println(map.get(0)); //打印可看出 integer位置上未初始化时存的是null
		long i;
		for (i = n % d; i != 0; i = i % d) { // 注意step
			if (map.get(i) != null) {
				break;
			}
			map.put(i, a.length()); // 将i的值当做key a的位置当做value
			i *= 10;
			a.append(i / d);
		}
		if (i == 0)
			return a.toString();
		a.insert(map.get(i), "("); // 直接在循环的地方加入(
		a.append(")"); // 出现循环就立即跳出了循环，也就是说从i的位置到最后，都是循环体，所以只需在最后面加上）
		return a.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fractionToDecimal2(1234, 9999));
	}

}
