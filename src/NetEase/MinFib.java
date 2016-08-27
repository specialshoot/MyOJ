package NetEase;

import java.util.Scanner;

/**
 * [编程题] Fibonacci数列 Fibonacci数列是这样定义的： F[0] = 0 F[1] = 1 for each i ≥ 2: F[i] =
 * F[i-1] + F[i-2] 因此，Fibonacci数列就形如：0, 1, 1, 2, 3, 5, 8, 13,
 * ...，在Fibonacci数列中的数我们称为Fibonacci数。给你一个N，你想让其变为一个Fibonacci数，每一步你可以把当前数字X变为X-
 * 1或者X+1，现在给你一个数N求最少需要多少步可以变为Fibonacci数。 输入描述: 输入为一个正整数N(1 ≤ N ≤ 1,000,000)
 * 
 * 输出描述: 输出一个最小的步数变为Fibonacci数"
 * 
 * 输入例子: 15
 * 
 * 输出例子: 2
 * 
 * @author han
 *
 */
public class MinFib {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int f0 = 0, f1 = 1, f = 0, l = Integer.MAX_VALUE, r = Integer.MAX_VALUE;
			while (true) {
				f = f0 + f1;
				f0 = f1;
				f1 = f;
				if (f < n) {
					l = n - f;
				} else {
					r = f - n;
					break;
				}
			}
			System.out.println(Math.min(l, r));
		}
		scanner.close();
	}

}
