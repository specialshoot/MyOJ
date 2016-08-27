package NetEase;

import java.util.Scanner;

/**
 * 分苹果 n 只奶牛坐在一排，每个奶牛拥有 ai
 * 个苹果，现在你要在它们之间转移苹果，使得最后所有奶牛拥有的苹果数都相同，每一次，你只能从一只奶牛身上拿走恰好两个苹果到另一个奶牛上，
 * 问最少需要移动多少次可以平分苹果，如果方案不存在输出 -1。 输入描述: 每个输入包含一个测试用例。每个测试用例的第一行包含一个整数 n（1 <= n
 * <= 100），接下来的一行包含 n 个整数 ai（1 <= ai <= 100）。
 * 
 * 
 * 输出描述: 输出一行表示最少需要移动多少次可以平分苹果，如果方案不存在则输出 -1。
 * 
 * 输入例子:
 * 
 * 4
 * 
 * 7 15 9 5
 * 
 * 输出例子: 3
 * 
 * @author han
 *
 */
public class Apple {

	public static void getStep(int n, int[] nums) {
		if (nums == null || nums.length == 0) {
			System.out.println("-1");
			return;
		}
		int average = 0;
		int flag = nums[0] % 2;
		for (int i = 0; i < n; i++) {
			if (nums[i] % 2 != flag) {
				System.out.println("-1");
				return;
			}
			average += nums[i];
		}
		if (average % n != 0) {
			System.out.println("-1");
			return;
		}
		average = average / n;
		int res = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] > average) {
				res = res + (nums[i] - average) / 2;
			}
		}
		System.out.println(res);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = scanner.nextInt();
			}
			getStep(n, nums);
		}
		scanner.close();
	}

}
