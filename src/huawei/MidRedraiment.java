package huawei;

import java.util.Scanner;

/**
 * Redraiment的走法
 * 
 * @author han
 *
 */
public class MidRedraiment {

	public static void dp(int[] red, int n) {
		int[] dp = new int[n];
		dp[0] = 1;// 一定要做这一步,初始化为dp[0]为1
		int temp = 0;
		for (int i = 1; i < n; i++) {
			temp = 0;
			for (int j = 0; j < i; j++) {
				if (red[i] > red[j] && dp[j] > temp) {
					temp = dp[j];
				}
			}
			dp[i] = temp + 1;
		}
		int max = 1;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int[] red = new int[n];
			for (int i = 0; i < n; i++) {
				red[i] = scanner.nextInt();
			}
			dp(red, n);
		}
		scanner.close();
	}

}
