package note;

import java.util.Arrays;
import java.util.Scanner;

/**
 * http://www.nowcoder.com/questionTerminal/af709ab9ca57430886632022e543d4c6?toCommentId=152658
 * 
 * [编程题] 有趣的数字 小Q今天在上厕所时想到了这个问题：有n个数，两两组成二元组，差的绝对值最小的有多少对呢？差的绝对值最大的呢？
 * 
 * 输入描述: 输入包含多组测试数据。
 * 
 * 对于每组测试数据： N - 本组测试数据有n个数 a1,a2...an - 需要计算的数据
 * 
 * 保证: 1<=N<=100000,0<=ai<=INT_MAX.
 * 
 * 输出描述: 对于每组数据，输出两个数，第一个数表示差的绝对值最小的对数，第二个数表示差的绝对值最大的对数。
 * 
 * 输入例子: 6 45 12 45 32 5 6
 * 
 * 输出例子: 1 2
 * 
 * @author han
 *
 */
public class MinMaxAbsTencent {
	private static Scanner scanner = new Scanner(System.in);
	 
    public static void main(String[] args) {
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int[] nums = new int[num];
            for (int i = 0; i < num; i++) {
                nums[i] = scanner.nextInt();
            }
            // getMinMaxAbsNums(nums, num);
            fun2(nums, num);
        }
    }
 
    public static void getMinMaxAbsNums(int[] nums, int len) {
        int minNum = 0, maxNum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len - 1; i++) {// 时间复杂度n^2
            for (int j = i + 1; j < len - 1; j++) {
                int abs = Math.abs(nums[i] - nums[j]);
                if (abs < min) {
                    minNum = 1;
                    min = abs;
                } else if (min == abs) {
                    minNum++;
                } else if (abs > max) {
                    max = abs;
                    maxNum = 1;
                } else if (max == abs) {
                    maxNum++;
                }
            }
        }
        System.out.println(minNum + " " + maxNum);
    }
 
    public static void fun2(int[] nums, int len) {
        Arrays.sort(nums);// 时间复杂度nlogn
        int maxCount = 0;
        int minNum = 1, maxNum = 1;// 数组中最小和最大元素的个数
        int i = 1;
        while (i < len && nums[i - 1] == nums[i]) {
            minNum++;
            i++;
        }
        i = len - 2;
        while (i >= 0 && nums[i] == nums[i + 1]) {
            maxNum++;
            i--;
        }
        if (nums[0] == nums[len - 1]) {
            maxCount = len * (len - 1) / 2;
        } else {
            maxCount = minNum * maxNum;
        }
        for (int j = 1; j < len; j++) {
            nums[j - 1] = Math.abs(nums[j] - nums[j - 1]);
        }
        int minValue = Integer.MAX_VALUE;
        int minCount = 0;
        for (int j = 0; j < nums.length; j++) {//初次统计minValue
            if (nums[j] < minValue) {
                minCount = 1;
                minValue=nums[j];
            } else if (nums[j] == minValue) {
                minCount++;
            }
        }
        if(minValue==0){//如果最小差值为0，统计0的区间个数
            minCount=0;
            int tempMinCount=0;
            for (int j = 0; j < len-1; j++) {
                if (nums[j]==0) {
                    tempMinCount++;
                }else {
                    minCount+=tempMinCount*(tempMinCount+1)/2;
                    tempMinCount=0;
                }
            }
            minCount+=tempMinCount*(tempMinCount+1)/2;
        }
        System.out.println(minCount + " " + maxCount);
    }
}
