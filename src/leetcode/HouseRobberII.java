package leetcode;

public class HouseRobberII {

	public static int rob(int[] nums) {
		// https://leetcode.com/problems/house-robber-ii/
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int len = nums.length;
		if (len == 1) {
			return nums[0];
		}
		if (len == 2) {
			return Math.max(nums[0], nums[1]);
		}
		int first = robi(nums, 0, len - 2);
		int last = robi(nums, 1, len - 1);
		return Math.max(first, last);
	}

	// HouseRobber1改写
	private static int robi(int[] nums, int start, int end) {
		int len = end - start + 1;
		int[] res = new int[len];
		res[0] = nums[start];

		for (int i = 1; i < len; i++) {
			if (i <= 1) {
				res[i] = Math.max(nums[start + i], res[i - 1]);
			} else {
				res[i] = Math.max(res[i - 2] + nums[start + i], res[i - 1]);
			}
		}
		return res[len - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { 1, 2, 1, 1 };
		System.out.println(rob(nums) + "");
	}

}
