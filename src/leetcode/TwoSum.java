package leetcode;

import java.util.Hashtable;

public class TwoSum {
	//https://leetcode.com/problems/two-sum/
	//最简单的遍历方式O(N^2)
	/*
	public static int[] twoSum(int[] numbers, int target) {
		int[] ret = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] + numbers[j] == target) {
					ret[0] = i + 1;
					ret[1] = j + 1;
				}
			}
		}
		return ret;
	}
	*/
	
	//哈希表解决twosum问题O(N)
	public static int[] twoSum(int[] numbers, int target){

        Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();
        int[] result = {0,0};
        for(int i = 0; i < numbers.length; i++){
            ht.put(numbers[i], i);
        }
        for(int i = 0; i < numbers.length; i++){
            int gap = target - numbers[i];
            if(ht.get(gap)!=null && ht.get(gap)>i){
                result[0] = i + 1;
                result[1] = ht.get(gap) + 1;
            }
        }
       
        return result;
    }

	public static void main(String agrs[]){
	    int[] numbers = {0,4,3,0} ;
	    int target = 0;
	    int[] result = twoSum(numbers, target);
	    System.out.println("index1="+result[0]+", index2="+result[1]);
	}

}
