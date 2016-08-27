package huawei;

import java.util.Scanner;

public class MidSushu {

	/**
	 * 动态规划求素数对最多的值
	 * 
	 * 从后向前看 利用动态规划解题，dp[i]表示(n-1)~i最多有的伴侣数； 当v[i]+v[j]为素数。dp[i]+dp[j+1] =
	 * dp[i+1]+dp[j+1]+1; 由于伴侣数成对出现，必然只能在i-1和j-1的基础上出现一对。
	 * 当v[i]+v[j]不为素数。dp[i]=dp[i+1]
	 *
	 * @param v
	 * @return
	 */
	private static int countPrimePairs(int[] v) {

		int[] dp = new int[v.length + 1];

		for (int i = v.length - 2; i >= 0; i--) {
			for (int j = v.length - 1; j > i; j--) {
				int cnt = checkSuShu(v[i] + v[j]) ? (dp[i + 1] - dp[j - 1] + dp[j + 1] + 1) : dp[i + 1];
				dp[i] = (cnt > dp[i]) ? cnt : dp[i];
			}
		}

		return dp[0];
	}

	/**
	 * 从2开始，迭代到n的平方根即可
	 * 因为如果n可以被一个数整除,那么其中一个数一定小于等于n开方,另一个大于等于n的开方,所以只需要算到这儿,到后面就是多余的了
	 * 
	 * @param n
	 * @return
	 */
	private static boolean checkSuShu(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
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
			System.out.println(countPrimePairs(nums));
		}
		scanner.close();
	}

}
