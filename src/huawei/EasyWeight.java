package huawei;

/**
 * 称砝码
 * 设dp[1000]数组为标记数组。当dp[i]=0时，表示质量为i的情况，目前没有称出；当dp[i]=1时，表示质量为i的情况已经称出。
 * 本题目中有多个砝码，我们顺序处理每一个砝码。
 * 当处理第j个砝码，质量为wj时，有下列推导公式：
 * d[i-wj]=1  ==>  d[i]=1(当且晋档质量i-wj已经称出才能称出质量i)
 */
import java.util.Scanner;

public class EasyWeight {

	public static int fama(int n, int[] weight, int[] nums) {
		int sum = 0;// 总质量
		for (int i = 0; i < n; i++) {
			sum += weight[i] * nums[i];
		}
		int[] dp = new int[sum + 1];
		dp[0] = 1;
		for (int i = 0; i < n; i++) {// n种砝码
			for (int j = 0; j < nums[i]; j++) {// 砝码个数
				for (int k = sum; k >= weight[i]; k--) {// 判断每种质量是否可以被称出
					if (dp[k - weight[i]] == 1) {
						dp[k] = 1;
					}
				}
			}
		}

		// 输出
		int count = 0;
		for (int i = 0; i <= sum; i++) {
			if (dp[i] == 1) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int[] weight = new int[n];
			int[] num = new int[n];
			for (int i = 0; i < n; i++) {
				weight[i] = scanner.nextInt();
			}
			for (int i = 0; i < n; i++) {
				num[i] = scanner.nextInt();
			}
			System.out.println(fama(n, weight, num) + "");
		}
	}

}
