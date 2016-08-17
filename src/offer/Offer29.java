package offer;

/**
 * 数组中出现次数超过一半的数字 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组｛1，2，3，2，2，2，5，4，2｝。 由于数字2在数组中出现5次，超过数组长度的一半，因此输出2.
 * 
 * @author han
 *
 */
public class Offer29 {

	/**
	 * 方法1 我们的算法是受快速排序的算法的启发。 在随机快速排序的算法中，我们先在数组中随机的选择一个数字，
	 * 然后调数组中数字的顺序，使得比选中的数字小数字排在它的左边， 比选中的数字大的数字都排在它的右边。
	 * 比如这个选中的数字的下标刚好是n/2，那么这个数字就是数组中的中位数。
	 * 如果它的下标大于n/2，那么中位数应该位于它的左边，我们可以接着在它的左边部分的数组中查找。
	 * 如果它的下标小于n/2，那么中位数应该在它的右边，我们可以接着在它的右边部分中查找。这是一个典型的递归过程。
	 */

	/**
	 * 一次快排
	 * 
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	public static int partition(int[] arr, int left, int right) {
		if (left > right) {
			return -1;
		}
		int result = arr[left];
		while (left < right) {
			while (left < right && arr[right] >= result) {
				right--;
			}
			arr[left] = arr[right];
			while (left < right && arr[left] < result) {
				left++;
			}
			arr[right] = arr[left];
		}
		arr[left] = result;
		return left;
	}

	public static int moreThanHalfNum(int[] arr) {
		if (arr.length == 0) {
			return -1;
		}

		int length = arr.length;
		int mid = length >> 1;
		int start = 0;
		int end = length - 1;
		int index = partition(arr, start, end);
		while (index != mid) {
			if (index > mid) {
				end = index - 1;
				index = partition(arr, start, end);
			} else {
				start = index + 1;
				index = partition(arr, start, end);
			}
		}
		// 找到中位数
		int result = arr[mid];
		if (!checkMoreThanHalf(arr, result)) {
			return -1;
		}
		return result;
	}

	public static boolean checkMoreThanHalf(int[] arr, int number) {
		int times = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == number) {
				times++;
			}
		}
		boolean isMoreThanHalf = true;
		if (times * 2 <= arr.length) {
			isMoreThanHalf = false;
		}
		return isMoreThanHalf;
	}

	/**
	 * 方法2 数组中有一个数字出现的次数超过数组长度的一半，也就是说它出现的次数比其他所有数字出现的次数的和还要多。
	 * 因此我们可以遍历数组的时候保存两个值：一个是数组中的一个数字，一个是次数。
	 * 当我们遍历到下一个数字的时候，如果下一个数字和我们之前保存的数字相同，则次数加1； 如果下一个数字和我们之前保存的数字不同，则次数减1.
	 * 如果次数为0，我们需要保存下一个数字，并把次数设为1. 由于我们要找的数字出现的次数比其他所有数字出现的次数之和还要多，
	 * 那么要找的数字肯定是最后一次把次数设为1时对应的数字。
	 */
	public static int moreThanHalfNum2(int[] arr) {
		if (arr.length == 0) {
			return -1;
		}
		int times = 1;
		int result = arr[0];
		int len = arr.length;
		for (int i = 1; i < len; i++) {
			if (times == 0) {
				result = arr[i];
				times = 1;
			} else if (arr[i] == result) {
				times++;
			} else {
				times--;
			}
		}
		// 此时result是出现次数最多的数字
		if (!checkMoreThanHalf(arr, result)) {
			return -1;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 3, 2, 4, 5, 6, 7, 2, 3, 4, 5, 4, 4, 4, 4, 5, 4, 4, 4, 4 };
		System.out.println(moreThanHalfNum(arr));
	}

}
