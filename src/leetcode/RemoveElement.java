package leetcode;

public class RemoveElement {

	public static int removeElement(int[] nums, int val) {
		int pos = 0;
		for (int i = 0; i < nums.length; i++) {
			// 只拷贝非给定数字的元素
			if (nums[i] != val) {
				nums[pos] = nums[i];
				pos++;
			}
		}
		return pos;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 1, 2, 3, 4, 4, 5 };
		int length = removeElement(nums, 1);
		System.out.println("removeElement -> " + length);
		for (int i = 0; i < length; i++) {
			System.out.println(nums[i] + "");
		}
	}

}
