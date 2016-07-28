package others;

/**
 * 今天的计算机课上，老师给同学们出了一道题：
 * 输入n个数，请将其中的偶数的二进制反转。
 * eg：输入1 6 5
 * 其中6是偶数，二进制表示为110，反转后为011，代表3，所以最终输出1 3 5.
 * 小贱君最近脑子不怎么好使，想了半天也没想出来如何做，最后他向你寻求帮助了，帮帮可怜的小贱君吧！
 * 
 * 输入描述:
 * 输入包含多组测试数据。
 * 对于每组测试数据：
 * N --- 输入的数字个数
 * N个数：a0,a1,...,an-1
 * 保证：
 * 1<=N<=3000,0<=ai<=INT_MAX.
 * 输出描述:
 * 对于每组数据，输出N个整数。
 * 
 * 输入例子:
 * 5
 * 1 3 10 6 7
 * 6
 * 26 52 31 45 82 34
 * 
 * 输出例子:
 * 1 3 5 3 7
 * 11 11 31 45 37 17
 */
import java.util.Scanner;

public class ReverseOvenLeShi {

	private static Scanner scanner;

	private static int reverse(int num) {
		if ((num & 1) == 1) {
			return num;// 奇数
		}
		int result = 0;
		while (num != 0) {
			result = (num & 1) | result;
			result = result << 1;
			num = num >> 1;
		}
		return result >> 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			for (int i = 0; i < n; i++) {
				System.out.print(reverse(scanner.nextInt()) + "");
				if (i != n - 1) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
