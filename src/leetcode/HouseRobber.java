package leetcode;

public class HouseRobber {

	public static int rob(int[] nums) {
		// https://leetcode.com/problems/house-robber/
		/**
		 * 你是一名专业强盗，计划沿着一条街打家劫舍。 每间房屋都储存有一定数量的金钱，唯一能阻止你打劫的约束条件就是：由于房屋之间有安全系统相连
		 * 如果同一个晚上有两间相邻的房屋被闯入，它们就会自动联络警察，因此不可以打劫相邻的房屋。
		 */
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int len = nums.length;
		int[] max = new int[len];
		max[0] = nums[0];
		for (int i = 1; i < len; i++) {
			if (i <= 1) {
				max[i] = Math.max(nums[i], max[i - 1]);
			} else {
				max[i] = Math.max(max[i - 1], max[i - 2] + nums[i]);
			}
		}
		return max[len - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { 1, 3, 1 };
		System.out.println(rob(nums) + "");
	}

}
