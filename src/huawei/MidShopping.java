package huawei;

import java.util.ArrayList;
import java.util.Scanner;

import org.omg.CORBA.PRIVATE_MEMBER;

public class MidShopping {

	static class Good {
		public int v;// 价格
		public int p;// 重要度
		public int q;// 主附件
		public int num;// 产品标号

		public Good() {
		}

		public Good(int v, int p, int q, int num) {
			super();
			this.v = v;
			this.p = p;
			this.q = q;
			this.num = num;
		}
	}

	/**
	 * 
	 * @param goods
	 *            物品列表
	 * @param m
	 *            物品个数
	 * @param N
	 *            物品总价值
	 */
	public static int getMaxValue(ArrayList<Good> goods, int m, int N) {
		int[][] value = new int[m + 1][N + 1];
		boolean[] hasBuy = new boolean[m + 1];
		for (int i = 0; i <= m; i++) {
			hasBuy[i] = false;
		}
		for (int i = 0; i <= m; i++) {
			value[i][0] = 0;
		}
		for (int i = 0; i <= N; i++) {
			value[0][i] = 0;
		}

		for (int i = 1; i <= m; i++) {// i第i个物品
			for (int j = 1; j <= N; j++) {// j局部总价值
				if (goods.get(i).v > j) {
					// 商品i超过了总价值
					// value[i][j] = 0;// 舍弃这个物品,令value[i][j]=0
					value[i][j] = value[i - 1][j];
				} else {
					int master = goods.get(i).q;
					if (master == 0) {// 不是附属品
						/**
						 * 策略选择，两种方案 1.不选择当前物品，保持原有价值
						 * 2.选择当前物品，从原有价值中扣除掉此物品消耗的价格，同时加上物品创造的价值
						 */
						value[i][j] = Math.max(value[i - 1][j],
								value[i - 1][j - goods.get(i).v] + goods.get(i).p * goods.get(i).v);
						if (value[i - 1][j] < (value[i - 1][j - goods.get(i).v] + goods.get(i).p * goods.get(i).v)) {
							// 选择此主件
							hasBuy[goods.get(i).num] = true;
						}
					} else {// 是附属品
						if (hasBuy[goods.get(i).num]) {
							// 主件已经被购买
							value[i][j] = Math.max(value[i - 1][j],
									value[i - 1][j - goods.get(i).v] + goods.get(i).p * goods.get(i).v);
						} else {
							if (goods.get(i).v + goods.get(master).v > j) {// 物品与主件价值大于局部总价值，弃之
								value[i][j] = value[i - 1][j];
							} else {
								// 道理同master==0的情况，这次要减去两个物品的v同时加上两个物品的v*p
								value[i][j] = Math.max(value[i - 1][j],
										value[i - 1][j - goods.get(i).v - goods.get(master).v]
												+ goods.get(i).v * goods.get(i).p
												+ goods.get(master).v * goods.get(master).p);
							}
						}
					}
				}
			}
		}
		return value[m][N];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int N = scanner.nextInt();// 物品总价值
			int m = scanner.nextInt();// 物品个数
			ArrayList<Good> goods = new ArrayList<>();
			Good temp = new Good();
			goods.add(temp);
			ArrayList<Good> fujian = new ArrayList<>();// 附件
			for (int i = 0; i < m; i++) {
				int v = scanner.nextInt();
				int p = scanner.nextInt();
				int q = scanner.nextInt();
				int num = i + 1;
				if (q == 0) {// 主件放在前面
					goods.add(new Good(v, p, q, num));
				} else {
					fujian.add(new Good(v, p, q, num));
				}
			}
			if (fujian.size() != 0) {
				goods.addAll(fujian);
			}
			System.out.println(getMaxValue(goods, m, N));
		}
	}

}
