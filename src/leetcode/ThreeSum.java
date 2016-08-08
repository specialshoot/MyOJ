package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	// https://leetcode.com/problems/3sum/
	// http://blog.csdn.net/ljiabin/article/details/40620579

	static List<List<Integer>> ret = new ArrayList<List<Integer>>();

	public static List<List<Integer>> threeSum(int[] nums) {

		if (nums == null || nums.length < 3)
			return ret;
		Arrays.sort(nums); // 排序,自己写的话可以使用插入排序,这里我们用默认的

		int len = nums.length;
		for (int i = 0; i < len - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				// 如果相邻的数字相同,则说明有重复,只需提取一个进行find
				continue;
			}
			find(nums, i + 1, len - 1, nums[i]); // 寻找两个数与num[i]的和为0
		}
		return ret;
	}

	/**
	 * 寻找两个数与num[i]的和为0
	 * 
	 * @param num
	 *            num数组
	 * @param begin
	 *            开始搜索位置
	 * @param end
	 *            结束搜索位置
	 * @param target目标数字
	 */
	public static void find(int[] num, int begin, int end, int target) {
		int l = begin, r = end;
		while (l < r) {
			if (num[l] + num[r] + target == 0) {
				List<Integer> ans = new ArrayList<Integer>();
				ans.add(target);
				ans.add(num[l]);
				ans.add(num[r]);
				ret.add(ans); // 放入结果集中
				while (l < r && num[l] == num[l + 1])
					l++;
				while (l < r && num[r] == num[r - 1])
					r--;
				l++;
				r--;
			} else if (num[l] + num[r] + target < 0) {
				l++;
			} else {
				r--;
			}
		}
	}

	public static int[] InsertSort(int[] arr) {

		int i, j;
		int insertNote;// 要插入的数据
		int[] array = arr;

		// 从数组的第二个元素开始循环将数组中的元素插入
		for (i = 1; i < array.length; i++) {
			// 设置数组中的第2个元素为第一次循环要播讲的数据
			insertNote = array[i];
			j = i - 1;
			while (j >= 0 && insertNote < array[j]) {
				// 如果要插入的元素小于第j个元素,就将第j个元素向后移动
				array[j + 1] = array[j];
				j--;
			}
			// 直到要插入的元素不小于第j个元素,将insertNote插入到数组中
			array[j + 1] = insertNote;
		}
		return array;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = { -1, 2, -1, 2, -1, 2 };
		System.out.println(threeSum(numbers));
	}

}
