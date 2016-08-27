package NetEase;

import java.util.Scanner;

/**
 * 有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照顺序选取 k 名学生，要求相邻两个学生的位置编号的差不超过 d，使得这 k
 * 个学生的能力值的乘积最大，你能返回最大的乘积吗？ 输入描述: 每个输入包含 1 个测试用例。每个测试数据的第一行包含一个整数 n (1 <= n <=
 * 50)，表示学生的个数，接下来的一行，包含 n 个整数，按顺序表示每个学生的能力值 ai（-50 <= ai <= 50）。接下来的一行包含两个整数，k
 * 和 d (1 <= k <= 10, 1 <= d <= 50)。
 * 
 * 
 * 输出描述: 输出一行表示最大的乘积。
 * 
 * 输入例子:
 * 
 * 3
 * 
 * 7 4 7
 * 
 * 2 50
 * 
 * 输出例子: 49
 * 
 * @author han
 *
 */
public class Chorus {

	public static void getRes(int[] nums, int N, int K, int D) {
		long ans = 0;
		long[][] fm = new long[K + 1][N + 1];// 选中了k个学生，并且以第i个学生为结尾，所产生的最大乘积
		long[][] fn = new long[K + 1][N + 1];// 选中了k个学生，并且以第i个学生为结尾，所产生的最小乘积.有负数的情况所以要设置一个最小数组
		for (int i = 1; i <= N; i++) {
			fm[1][i] = fn[1][i] = nums[i];
			for (int k = 2; k <= K; ++k) {
				for (int j = i - 1; j > 0 && i - j <= D; --j) {
					fm[k][i] = Math.max(fm[k][i], Math.max(fm[k - 1][j] * nums[i], fn[k - 1][j] * nums[i]));
					fn[k][i] = Math.min(fn[k][i], Math.min(fm[k - 1][j] * nums[i], fn[k - 1][j] * nums[i]));
				}
			}
			ans = Math.max(ans, fm[K][i]);
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int N = scanner.nextInt();
			int[] nums = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				nums[i] = scanner.nextInt();
			}
			int K = scanner.nextInt();
			int D = scanner.nextInt();
			getRes(nums, N, K, D);
		}
		scanner.close();
	}

}
