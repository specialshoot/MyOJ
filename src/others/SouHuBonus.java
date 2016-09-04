package others;

import java.util.Scanner;

public class SouHuBonus {

	/**
	 * 方法一
	 * 
	 * @param nums
	 * @param N
	 * @return
	 */
	public static int getBonus(int[] nums, int N) {
		int[] bonus = new int[N];// 正向遍历数组
		int[] cobonus = new int[N];// 反向遍历数组
		bonus[0] = 1;
		cobonus[N - 1] = 1;
		for (int i = 1; i < N; i++) {
			if (nums[i] > nums[i - 1]) {
				bonus[i] = bonus[i - 1] + 1;
			} else {
				bonus[i] = 1;
			}
		}

		for (int i = N - 1; i > 0; i--) {
			if (nums[i - 1] > nums[i]) {
				cobonus[i - 1] = cobonus[i] + 1;
			} else {
				cobonus[i - 1] = 1;
			}
		}

		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += Math.max(bonus[i], cobonus[i]);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int N = scanner.nextInt();
			int[] nums = new int[N];
			for (int i = 0; i < N; i++) {
				nums[i] = scanner.nextInt();
			}
			System.out.println(getBonus(nums, N));
		}
		scanner.close();
	}

}
