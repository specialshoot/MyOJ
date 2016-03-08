package leetcode;

public class BestTimetoBuyAndSellStockIV {

	// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
	public static int maxProwt(int k, int[] prices) {

		int days = prices.length;
		int tradeCount = 0;// 交易次数
		int profitCount = 0;// 收益
		int rangeProfitCount = 0;
		for (int i = 1; i < days; i++) {
			if (prices[i - 1] < prices[i]) {
				// 两天之间收益为正值
				rangeProfitCount += prices[i] - prices[i - 1];
				if (i == days - 1) {// 最后一天
					profitCount += rangeProfitCount;
					tradeCount += 1; // 交易次数加一
				}
			} else if (rangeProfitCount > 0) {
				profitCount += rangeProfitCount; // 收益加上
				tradeCount += 1; // 交易次数加一
				rangeProfitCount = 0;
			}
		}
		if (k >= tradeCount) {// 如果k交易次数大于等译交易总次数,直接返回最大收益
			return profitCount;
		}
		int[][] global = new int[k + 1][days];
		int[][] local = new int[k + 1][days];
		// 动态规划
		for (int i = 1; i <= k; i++) {
			for (int j = 1; j < days; j++) {
				int diff = prices[j] - prices[j - 1];
				local[i][j] = Math.max(global[i - 1][j - 1], local[i][j - 1] + diff);
				global[i][j] = Math.max(global[i][j - 1], local[i][j]);
			}
		}
		return global[global.length - 1][global[0].length - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = { 1, 3, 5, 6, 1, 2, 9 };
		System.out.println(maxProwt(3, prices) + "");
	}

}
