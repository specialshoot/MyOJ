package leetcode;

public class FindMinimuminRotatedSortedArray {

	// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
	// 元素无重复排序

	// 二分法
	public static int findMin(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int l = 0;
		int r = nums.length - 1;
		int min = nums[0];
		while (l < r - 1) {
			int m = (l + r) / 2;
			if (nums[l] < nums[m]) {
				min = Math.min(nums[l], min);
				l = m + 1;
			} else {
				min = Math.min(nums[m], min);
				r = m - 1;
			}
		}
		min = Math.min(nums[r], min);
		min = Math.min(nums[l], min);
		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 5, 6, 7, 8, 9, 10, 3 };
		System.out.println(findMin(nums) + "");
	}

}
