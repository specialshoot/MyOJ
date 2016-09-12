package offer;

import java.util.Scanner;

/**
 * 连续子数组的最大和
 * 
 * @author han
 *
 */
public class Offer31 {

	public static long findGreatestSum(long[] arr) {
		if (arr.length == 0) {
			return 0;
		}
		int len = arr.length;
		long greatest = Long.MIN_VALUE;
		long curSum = 0;
		for (int i = 1; i < len; i++) {
			if (curSum <= 0) {
				curSum = arr[i];// curSum<0说明前面累加后为负数,不管怎样都比arr[i]+curSum小,所以直接舍弃前面的累加,直接赋值arr[i]
			} else {// 前面累加和>0,当前值加上前面的累加和赋值给当前和
				curSum += arr[i];
			}
			if (curSum > greatest) {
				greatest = curSum;// 求最大值
			}
		}
		return greatest;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNext()){
			int n=scanner.nextInt();
			long[] arr=new long[n];
			for(int i=0;i<n;i++){
				arr[i]=scanner.nextLong();
			}
			System.out.println(findGreatestSum(arr));
		}
		scanner.close();
	}

}
