package leetcode;

public class NextPermutation {

	public static void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 0)
			return;
		int i = nums.length - 2;
		// 从后向前遍历直到发现前一个数小于后一个数便记录位置停止循环
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}
		if (i >= 0) {
			int j = i + 1;
			while (j < nums.length && nums[j] > nums[i]) {// 找到i位置后面小于i位置的数的index
				j++;
			}
			j--;
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
		reverse(nums, i + 1, nums.length - 1);
	}

	/**
	 * 反转数组
	 * 
	 * @param nums
	 *            要反转数组
	 * @param start
	 *            数组开始位置
	 * @param last
	 *            数组结束位置
	 */
	private static void reverse(int[] nums, int start, int last) {
		int l = start;
		int r = last;
		while (l < r) {
			int temp = nums[l];
			nums[l] = nums[r];
			nums[r] = temp;
			l++;
			r--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = { 1, 1, 5 };
		System.out.println("before -> ");
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i] + " ");
		}
		System.out.println("");
		nextPermutation(test);
		System.out.println("after -> ");
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i] + " ");
		}
		System.out.println("");
	}
}
