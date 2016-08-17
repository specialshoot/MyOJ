package offer;

/**
 * 丑数 题目：丑数 我们把只包含因子2，3，5的数称为丑数（Ugly Number). 求按从小到大的顺序的第1500个丑数。
 * 例如6，8都是丑数，但14不是，因为它含有因子7.习惯上我们把1当作第一个丑数
 * 
 * @author han
 *
 */
public class Offer34 {

	// 方法1穷举
	public static int getUgly(int n) {
		if (n <= 0) {
			return 0;
		}
		int found = 0;
		int num = 0;
		while (found < n) {
			num++;
			if (isUgly(num)) {
				found++;
			}
		}
		return num;
	}

	public static boolean isUgly(int num) {
		while (num % 2 == 0) {
			num /= 2;
		}
		while (num % 3 == 0) {
			num /= 3;
		}
		while (num % 5 == 0) {
			num /= 5;
		}
		if (num == 1) {
			return true;
		}
		return false;
	}

	/********************* 华丽的分割线 **********************/
	/*
	 * 方法2高效率的方法,创建数组保存已经找到的丑数. 我们试着找到一种只要计算丑数的方法，而不在非丑数的整数上花费时间。
	 * 根据丑数的定义，丑数应该是另一个丑数乘以2，3，5的结果。
	 * 因此我们可以创建一个数组，里面的数字是排序好的丑数，每一个丑数都是前面的丑数乘以2，3，5得到的。
	 * 
	 * 这种思路的关键在于怎样确定数组里面的丑数是排序好的。
	 * 假设数组中已经有若干个丑数排好后存放在数组中，并且把已有的最大的丑数记作M，我们接下来分析如何生成下一个丑数。
	 * 该丑数肯定是前面某个丑数乘以2，3，5的结果。 所以我们首先考虑把已有的每个丑数乘以2.在乘以2的时候，能得到若干个小于或等于M的结果。
	 * 由于是按照顺序生成的，小于或者等于M肯定已经在数组中了，我们不需要再次考虑；
	 * 还会得到若干个大于M的结果，但我们只需要第一个大于M的结果，因为我们希望丑数是指按从小到大的顺序生成的，其他更大的结果以后再说。
	 * 我们把得到的第一个乘以2后大于M的结果即为M2.同样，我们把已有的每一个丑数乘以3，5，能得到第一个大于M的结果M3和M5.
	 * 那么下一个丑数应该是M2,M3,M5。这3个数的最小者。
	 */
	public static int getUgly2(int n) {
		if (n <= 0) {
			return 0;
		}
		int[] ugly = new int[n];
		ugly[0] = 1;
		int a2 = 0;
		int a3 = 0;
		int a5 = 0;
		for (int i = 1; i < n; i++) {
			int min = min(ugly[a2] * 2, ugly[a3] * 3, ugly[a5] * 5);
			ugly[i] = min;
			while (ugly[a2] * 2 == ugly[i]) {
				a2++;
			}
			while (ugly[a3] * 3 == ugly[i]) {
				a3++;
			}
			while (ugly[a5] * 5 == ugly[i]) {
				a5++;
			}
		}
		return ugly[n - 1];
	}

	public static int min(int a, int b, int c) {
		return (a < b ? (a < c ? a : c) : (b < c ? b : c));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getUgly2(7));
	}

}
