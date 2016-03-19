package leetcode;

public class LongestIncreasingSubsequence {

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
		int global = 0;
		int[] sub = new int[len];
		for (int i = 0; i < len; i++) {
			int local = 0;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i] && local < sub[j]) {// 策略:如果前面的数比后面的数小,并且局部总步数小于第j步的步数,则更新步数
					local = sub[j];
				}
			}
			sub[i] = local + 1;// 当前点则是该局部最大上升长度加1
			global = Math.max(global, sub[i]);// 更新全局最大上升长度
		}
		return global;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = new int[] { 2, 1, 0 };
		System.out.println(lengthOfLIS(test) + "");
	}
}
