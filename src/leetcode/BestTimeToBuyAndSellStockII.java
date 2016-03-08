package leetcode;

import java.lang.reflect.Array;

public class BestTimeToBuyAndSellStockII {

	// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int len = prices.length;
		int maxProfit = 0;
		for (int i = 1; i < len; i++) {
			int tempProfit = prices[i] - prices[i - 1];
			if (tempProfit > 0) {
				maxProfit += tempProfit;
			}
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = { 1 };
		System.out.println(maxProfit(prices) + "");
	}

}
