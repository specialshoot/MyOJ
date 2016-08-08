package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSum {
	// https://leetcode.com/problems/4sum/

	public static List<List<Integer>> fourSum(int[] nums, int target) {

		HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
		List<List<Integer>> ret = new ArrayList<List<Integer>>();

		if (nums == null || nums.length < 4)
			return ret;
		Arrays.sort(nums); // 排序

		int len = nums.length;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				int l = j + 1, r = len - 1;
				while (l < r) {
					int sum = nums[i] + nums[j] + nums[l] + nums[r];
					if (sum > target) {
						r--;
					} else if (sum < target) {
						l++;
					} else {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(nums[i]);
						temp.add(nums[j]);
						temp.add(nums[l]);
						temp.add(nums[r]);
						if (!hashSet.contains(temp)) {
							hashSet.add(temp);
							ret.add(temp);
						}
						l++;
						r--;
					}
				}
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 0, -1, 0, -2, 2 };
		System.out.println(fourSum(nums, 0).toString());
	}
}
