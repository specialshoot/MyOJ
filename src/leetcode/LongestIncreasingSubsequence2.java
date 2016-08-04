package leetcode;

public class LongestIncreasingSubsequence2 {

	// https://leetcode.com/problems/longest-increasing-subsequence/
	// 最长上升序列

	/**
	 * 方法一,动态规划
	 * 
	 * @param nums
	 * @return
	 */
	public static int lengthOfLIS(int[] nums) {
		if (nums.length == 0 || nums == null) {
			return 0;
		}
		int len = nums.length;
		int maxPointIndex = 0;
		int[] bt = new int[len];
		int[] sub = new int[len];// 某一位最大上升个数计数
		for (int i = 0; i < len; i++) {

			bt[i] = -1;
		}
		for (int i = 0; i < len; i++) {
			sub[i] = 1;
		}
		int max = 0;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && sub[i] < sub[j] + 1) {// 策略:如果前面的数比后面的数小,并且局部总步数小于第j步的步数,则更新步数
					sub[i] = sub[j] + 1;
					if (max <= sub[i]) {
						max = sub[i];
						maxPointIndex = i;
						bt[i] = j;
					}
				}
			}
		}

		back(bt, nums, maxPointIndex);

		return max;
	}

	public static void back(int[] bt, int[] nums, int maxPointIndex) {
		if (bt[maxPointIndex] == -1) {
			System.out.println(nums[maxPointIndex]);
			return;
		} else {
			back(bt, nums, bt[maxPointIndex]);
			System.out.println(nums[maxPointIndex]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = new int[] { 1, 7, 3, 5, 9, 4, 8 };
		System.out.println(lengthOfLIS(test) + "");
	}
}
