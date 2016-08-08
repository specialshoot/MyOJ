package huawei;

import java.util.Arrays;
import java.util.Scanner;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * Author: 王俊超 Date: 2015-12-24 17:18 All Rights Reserved !!!
 */
public class Candelete {
	public static void main(String[] args) {

		int n = 10;
		boolean[][] m = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}
	}

	/**
	 * 大整数相加，ns、ms都不小于0
	 *
	 * @param ns
	 *            数字
	 * @param ms
	 *            数字
	 * @return 结果
	 */
	private static String addLongInteger(String ns, String ms) {
		int[] n = getNumber(ns);
		int[] m = getNumber(ms);
		// 进行计算
		int[] r = add(m, n);

		return toNumber(r);
	}

	/**
	 * 两个不小于零的整数相加
	 *
	 * @param m
	 *            整数
	 * @param n
	 *            整数
	 * @return 结果
	 */
	private static int[] add(int[] m, int[] n) {

		// System.out.println(Arrays.toString(n) +"\n"+ Arrays.toString(m));

		// 保证n不小于m
		if (m.length > n.length) {
			int[] t = m;
			m = n;
			n = t;
		}

		// 结果的最大长度
		int[] r = new int[n.length + 1];
		// 来自低位的进位
		int c = 0;

		for (int i = 0; i < m.length; i++) {
			r[i] = m[i] + n[i] + c;
			c = r[i] / 10;
			r[i] %= 10;
		}

		// 计算余下的部分
		for (int i = m.length; i < n.length; i++) {
			r[i] = n[i] + c;
			c = r[i] / 10;
			r[i] %= 10;
		}

		// System.out.println(Arrays.toString(n) +"\n"+ Arrays.toString(m) +
		// "\n" + Arrays.toString(r));

		// 最后还有进位
		if (c != 0) {
			r[r.length - 1] = c;
			return r;
		}
		// 没有进位
		else {
			int[] ret = new int[r.length - 1];
			System.arraycopy(r, 0, ret, 0, ret.length);
			return ret;
		}
	}

	/**
	 * 将整数字符串表示成整数数组【不包含符号位】
	 *
	 * @param n
	 *            整数字符串
	 * @return 整数数组 下标从小到大表示数位的从低到高
	 */
	private static int[] getNumber(String n) {
		int[] r = new int[n.length()];
		for (int i = 0; i < r.length; i++) {
			r[i] = n.charAt(n.length() - i - 1) - '0';
		}

		return r;
	}

	/**
	 * 将数组表示的整数转换成字符串
	 *
	 * @param r
	 *            整数
	 * @return 字符串表示的整数
	 */
	private static String toNumber(int[] r) {
		if (r == null) {
			return null;
		}

		StringBuilder b = new StringBuilder(r.length);

		for (int i = r.length - 1; i >= 0; i--) {
			b.append(r[i]);
		}

		return b.toString();
	}
}