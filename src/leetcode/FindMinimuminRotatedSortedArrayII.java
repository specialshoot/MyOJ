package leetcode;

public class FindMinimuminRotatedSortedArrayII {

	// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
	// 元素有重复排序
	// 与FindMinimuminRotatedSortedArray不同在于有重复,这是只要多写一个判断条件即可,让左边自加1
	
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
			} else if (nums[l] > nums[m]) {
				min = Math.min(nums[m], min);
				r = m - 1;
			} else {
				l++;
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
