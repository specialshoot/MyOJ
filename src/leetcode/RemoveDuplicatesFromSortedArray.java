package leetcode;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

	//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
	
	//仅仅是计算个数
	public static int removeDuplicates(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				count++;
			}
		}
		return (nums.length - count);
	}
	
	//改变原始数组并计算个数
	public static int removeDuplicatesNaive(int[] nums) {
		if (nums.length < 2)
			return nums.length;
	 
		int j = 0;
		int i = 1;
	 
		while (i < nums.length) {
			if (nums[i] == nums[j]) {
				i++;
			} else {
				j++;
				nums[j] = nums[i];
				i++;
			}
		}
		for(int ii=0;ii<j+1;ii++){
			System.out.println(nums[ii]+"");
		}
		return j + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={1,1,1,2,3,4,4,5};
		System.out.println("removeDuplicates -> "+removeDuplicates(a));
		System.out.println("removeDuplicatesNaive -> "+removeDuplicatesNaive(a));
	}

}
