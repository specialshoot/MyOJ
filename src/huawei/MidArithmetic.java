package huawei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 寻找等差数列
 * 
 * @author han
 *
 */
public class MidArithmetic {

	static ArrayList<Integer> list = null;
	static final int MAX = 30;

	private static void getArithmetic(int m, int n) {
		list = new ArrayList<>();
		int count = 0;
		for (int i = m; i < n; i++) {
			//找到所有素数
			if (checkSuShu(i)) {
				list.add(i);
				count++;
			}
		}
		int maxCha = list.get(count - 1) - list.get(0);// 相差最大的差
		int[] res = new int[MAX];// 每组的局部result
		int max = 0;// 最大差元素数量
		int sum = 1;
		int[] out = new int[MAX];
		for (int k = 1; k <= maxCha; k++) {//遍历每个可能的差值
			
			for (int i = 0; i < count - 1; i++) {
				int val = i;
				res[0] = list.get(i);
				for (int j = i + 1; j < count; j++) {
					if ((list.get(j) - list.get(val)) == k) {
						val = j;
						res[sum] = list.get(j);
						sum++;
					}
				}
				if (max < sum) {// 全局
					max = sum;
					for (int ii = 0; ii < sum; ii++) {
						out[ii] = res[ii];
					}
				}
				sum = 1;
			}
		}

		for (int i = 0; i < max; i++) {
			System.out.print(out[i]);
			if (i != max - 1) {
				System.out.print(" ");
			}
		}
		System.out.println();
	}

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
			int m = scanner.nextInt();
			int n = scanner.nextInt();
			getArithmetic(m, n);
		}
		scanner.close();
	}

}
