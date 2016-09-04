package huawei;

import java.util.Scanner;

public class MidShopping {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int sum_money = 0;
			int num = 0;
			sum_money = sc.nextInt();
			num = sc.nextInt();
			int price[] = new int[num + 1];
			int val[] = new int[num + 1];
			int[] q = new int[num + 1];
			for (int i = 1; i <= num; i++) {
				price[i] = sc.nextInt();
				val[i] = sc.nextInt() * price[i];
				q[i] = sc.nextInt();
			}
			int[][] dp = new int[num + 1][sum_money + 1];
			/*
			 * 初始值java默认赋值为0,其中dp[0][0...sum_money]为0,从dp[1][0...sum_money]
			 * 计算第1行,代表第一件物品 dp[i][sum_money] ： 前i个物体放入容量为sum_money的背包的最大价值；
			 * dp[i-1][sum_money] ： 前i-1个物体放入容量为sum_money的背包的最大价值；
			 * dp[i-1][sum_money-price[i]] ：
			 * 前i-1个物体放入容量为sum_money-price[i]的背包的最大价值；
			 * dp[i][sum_money]=Math.max{dp[i-1][sum_money-price[i]]+val[i] ,
			 * dp[i-1][sum_money]}
			 */
			for (int i = 1; i <= num; i++) {
				for (int j = 1; j <= sum_money; j++) {
					if (q[i] == 0) {
						if (price[i] <= j)
							dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - price[i]] + val[i]);
					}
					if (q[i] > 0) {
						if (price[i] + price[q[i]] <= j)
							dp[i][j] = Math.max(dp[i - 1][j],
									dp[i - 1][j - price[i] - price[q[i]]] + val[i] + val[q[i]]);
					}
				}
			}
			System.out.println(dp[num][sum_money]);
		}
		sc.close();
	}

}
