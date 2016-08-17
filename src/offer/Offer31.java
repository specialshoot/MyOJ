package offer;

/**
 * 连续子数组的最大和
 * 
 * @author han
 *
 */
public class Offer31 {

	public static Integer findGreatestSum(int[] arr) {
		if (arr.length == 0) {
			return null;
		}
		int len = arr.length;
		int greatest = 0x80000000;// int类型最小值
		int curSum = 0;
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
		int[] arr = { 1, -2, 3, 10, -4, 7, 2, -5 };
		System.out.println(findGreatestSum(arr));
	}

}
