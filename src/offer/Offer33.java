package offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 把数组排成最小的数
 * 
 * 题目：输入一个正整数数组，把数组里面所有的数字拼接排成一个数，打印能拼接出的所有数字中的一个。
 * 例如输入数组｛3，32，321｝，则打印出这3个数字能排成的最小数字321323.
 * 
 * @author han
 *
 */
public class Offer33 {

	/**
	 * 方法一,快排(一般快排实现形式,和博主不同)
	 * 
	 * @param arr
	 */
	public static void printMin(int[] arr) {
		int[] clone = arr.clone();
		printMinNumber(clone, 0, clone.length - 1);
		for (int i : clone) {
			System.out.print(i);
		}
		System.out.println();
	}

	/**
	 * 核心快排
	 * 
	 * @param arr
	 * @param left
	 * @param right
	 */
	public static void printMinNumber(int[] arr, int left, int right) {
		if (left < right) {
			int main_number = arr[left];
			int small_cur = left;
			int big_cur = right;
			while (small_cur < big_cur) {
				while (small_cur < big_cur && isSmall(String.valueOf(main_number), String.valueOf(arr[big_cur]))) {
					big_cur--;
				}
				arr[small_cur] = arr[big_cur];
				while (small_cur < big_cur && isSmall(String.valueOf(arr[small_cur]), String.valueOf(main_number))) {
					small_cur++;
				}
				arr[big_cur] = arr[small_cur];
			}
			arr[small_cur] = main_number;
			printMinNumber(arr, 0, small_cur - 1);
			printMinNumber(arr, small_cur + 1, right);
		}
	}

	/**
	 * 判断字符串大小
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean isSmall(String str1, String str2) {
		String left = str1 + str2;
		String right = str2 + str1;
		for (int i = 0; i < left.length(); i++) {
			if (left.charAt(i) < right.charAt(i)) {
				return true;
			} else if (left.charAt(i) > right.charAt(i)) {
				return false;
			}
		}
		return false;
	}

	/******************************
	 * 方法2 Comparator
	 ********************************/
	public static void printMin2(int[] arr) {
		String[] clone = intToString(arr);
		Arrays.sort(clone, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return (o1 + o2).compareTo(o2 + o1);
			}
		});
		for (String str : clone) {
			System.out.print(str);
		}
		System.out.println();
	}

	public static String[] intToString(int[] arr) {
		int len = arr.length;
		String[] res = new String[len];
		for (int i = 0; i < len; i++) {
			res[i] = String.valueOf(arr[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] val = { { 32, 321 }, // 32132
				{ 532, 45, 78 }, // 4553278
				{ 2, 23, 231 }, // 223123
				{ 2, 3, 1 },// 123
		};
		for (int i = 0; i < val.length; i++) {
			printMin(val[i]);
		}
	}

}
