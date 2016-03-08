package leetcode;

public class BestTimetoBuyAndSellStockIII {

	// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int len = prices.length;
		int sum = 0;
		int min = prices[0];
		int[] ArrayA = new int[len];
		for (int i = 1; i < prices.length; i++) {
			ArrayA[i] = prices[i] - min;
			ArrayA[i] = ArrayA[i] > ArrayA[i - 1] ? ArrayA[i] : ArrayA[i - 1];
			if (prices[i] < min) {
				min = prices[i];
			}
		}
		int max = prices[prices.length - 1];
		int[] ArrayB = new int[len];
		for (int i = len - 1; i > 0; i--) {
			ArrayB[i] = max - prices[i];
			ArrayB[i] = ArrayB[i] > ArrayB[i - 1] ? ArrayB[i] : ArrayB[i - 1];
			if (prices[i] > max) {
				max = prices[i];
			}
		}
		for (int i = 0; i < len; i++) {
			sum = Math.max(ArrayA[i] + ArrayB[i], sum);
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = { 1, 3, 5, 6, 1, 2, 9 };
		System.out.println(maxProfit(prices) + "");
	}

}
