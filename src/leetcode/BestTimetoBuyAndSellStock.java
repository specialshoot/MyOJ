package leetcode;

public class BestTimetoBuyAndSellStock {

	// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}
		int local = 0;
		int global = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			local = Math.max(local + prices[i + 1] - prices[i], 0);// 当前最大收益
			global = Math.max(local, global);// 全局最大收益
		}
		return global;
	}

	public static int maxProfit2(int[] prices) {
		int len = prices.length;
		if (prices == null || len <= 1) {
			return 0;
		}
		int minPrice = prices[0]; // 最小价格初始化
		int diff = prices[1] - prices[0];// 价格差
		for (int i = 2; i < len; i++) {
			minPrice = Math.min(prices[i - 1], minPrice);
			if (diff < prices[i] - minPrice) {
				diff = prices[i] - minPrice;
			}
		}
		if (diff < 0) {
			return 0;
		}
		return diff;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = { 1, 3, 5, 6, 1, 2, 9 };
		System.out.println(maxProfit2(prices) + "");
	}

}
