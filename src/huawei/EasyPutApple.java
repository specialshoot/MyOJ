package huawei;

/**
 * 放苹果
 */
import java.util.Scanner;

public class EasyPutApple {

	/**
	 * 
	 * @param m
	 *            苹果数目
	 * @param n
	 *            盘子数目
	 * @return 放置方法总数
	 */
	public static int count(int m, int n) {
		int[] result = { 0 };
		for (int i = 1; i <= n; i++) {
			findWays(m, m - i + 1, 1, i, result);// 第i个变量可以取的最大值为m-i+1
		}
		return result[0];
	}

	/**
	 * 有n个变量，其和为m，求有多少种解法，每个解的变量按从大到小取值，最小为1
	 *
	 * @param m
	 *            第i个变量实际可以取的最大值
	 * @param curMax
	 *            可以取的最大值
	 * @param i
	 *            第i个变量
	 * @param n
	 *            总计有n个变量
	 * @param result
	 *            结果统计
	 */
	private static void findWays(int m, int curMax, int i, int n, int[] result) {
		if (m > 0 && m <= curMax && i == n) {
			result[0]++;
			return;
		}

		if (m < 1 || curMax < 1 || i > n) {
			return;
		}

		for (int v = curMax; v > 0; v--) {
			findWays(m - v, v, i + 1, n, result);
		}
	}

	/**
	 * 对于m个苹果，n个盘子f(m,n)，如果苹果个数比盘子少，那么就跟n个盘子，n个苹果是一样的f(n,n)。
	 * 如果m比n大，那么有两种情况，一种有空盘子的情况，一种没有空盘子的情况，两种情况不重叠且加一起一定为情况总数。
	 * 第一种情况就即为n个盘子放在m-1个盘子里，因为至少有个空盘子。f(m，n-1).
	 * 第二种情况下，每个盘子都有一个苹果了，就相当于f(m-n,n)，m扣掉n个苹果再放到n个盘子里。得到递归式f(m,n)=f(m,n-1)+f(m-n,n)。
	 * @param m 苹果数量
	 * @param n 盘子数量
	 * @return
	 */
	public static int shareapple(int m, int n) {
		if (m == 1 || n == 1)
			return 1;
		if (m < n)
			return shareapple(m, m);
		else if (m > n)
			return shareapple(m, n - 1) + shareapple(m - n, n);
		else
			return 1 + shareapple(m, n - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int m = scanner.nextInt();
			int n = scanner.nextInt();
			System.out.println(shareapple(m, n));
		}
		scanner.close();
	}

}
