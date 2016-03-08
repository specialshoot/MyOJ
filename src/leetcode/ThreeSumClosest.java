package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {

	static List<List<Integer>> ret = new ArrayList<List<Integer>>();

	public static int threeSumClosest(int[] nums, int target) {

		if (nums == null || nums.length < 3) {
			return 0;
		}
		
		int ret=0;
		int Closed=Integer.MAX_VALUE;

		Arrays.sort(nums);
		int length = nums.length;
		for (int i = 0; i < length-2; i++) {
				if(i>0 && nums[i]==nums[i-1]){
					continue;
				}
				
				int l=i+1;
				int r=length-1;
				while(l<r){
					int sum=nums[i]+nums[l]+nums[r];
					if(sum<target){
						if(target-sum<Closed){
							Closed=target-sum;
							ret=sum;
						}
						l++;
					}else if(sum>target){
						if(sum-target<Closed){
							Closed=sum-target;
							ret=sum;
						}
						r--;
					}else{
						return sum;
					}
				}
		}
		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num={1,1,1,1};
		int target=1;
		System.out.println(threeSumClosest(num, target)+"");
	}

}
