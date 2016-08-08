package huawei;

import java.util.Scanner;

public class EasySuperAdd {

	public static String AddLongInteger(String addend, String augend) {
		int[] add = getNumber(addend);
		int[] aug = getNumber(augend);
		int[] res = add(add, aug);
		return toString(res);
	}

	/**
	 * 将字符串转化为整形数组
	 * 
	 * @param num
	 * @return
	 */
	private static int[] getNumber(String num) {
		int length = num.length();
		int[] res = new int[length];
		for (int i = 0; i < length; i++) {
			res[i] = num.charAt(i) - '0';
		}
		return res;
	}

	/**
	 * 进行加法运算
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	private static int[] add(int[] m, int[] n) {
		if (m.length > n.length) {// 保证n的个数多余m
			int[] temp = m;
			m = n;
			n = temp;
		}

		int nlength = n.length;
		int mlength = m.length;
		int[] res = new int[nlength + 1];
		int c = 0;// 进位
		// 计算m与n都有的位数
		for (int i = 0; i < mlength; i++) {
			res[nlength - i] = m[mlength - i - 1] + n[nlength - i - 1] + c;
			c = res[nlength - i] / 10;
			res[nlength - i] %= 10;
		}
		// 计算余下的位数
		for (int i = n.length - m.length; i > 0; i--) {
			res[i] = n[i - 1] + c;
			c = res[i] / 10;
			res[i] %= 10;
		}
		// 最后的进位
		if (c != 0) {
			res[0] = c;
			return res;
		} else {
			int[] resNo = new int[res.length - 1];
			System.arraycopy(res, 1, resNo, 0, resNo.length);
			return resNo;
		}
	}

	/**
	 * 将数组转化为字符串
	 * 
	 * @param num
	 * @return
	 */
	private static String toString(int[] num) {
		if (num == null) {
			return null;
		}
		StringBuilder builder = new StringBuilder(num.length);
		for (int i = 0; i < num.length; i++) {
			builder.append(num[i]);
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String addend = scanner.next();
			String augend = scanner.next();
			System.out.println(AddLongInteger(addend, augend));
			/*
			 * //方法二 BigInteger bi1 = new BigInteger(addend); BigInteger bi2 =
			 * new BigInteger(augend); System.out.println(bi1.add(bi2));
			 */
		}
		scanner.close();
	}
}
