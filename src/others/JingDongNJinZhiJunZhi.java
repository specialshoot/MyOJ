package others;

import java.util.Scanner;

/**
 * 进制均值 输入data 输出data从2进制到data-1进制每位和的平均数,如不是整数则输出约分结果
 * 
 * @author han
 *
 */
public class JingDongNJinZhiJunZhi {

	static int sum = 0;

	private static void toNBigit(int data, int a) {

		int n = (data % a);
		int m = (data / a);

		if (m == 0) {
			sum += n;
		} else {
			toNBigit(m, a);
			sum += n;
		}
	}

	// 递归法求最大公约数
	public static int maxCommonDivisor(int m, int n) {
		if (m < n) {// 保证m>n,若m<n,则进行数据交换
			int temp = m;
			m = n;
			n = temp;
		}
		if (m % n == 0) {// 若余数为0,返回最大公约数
			return n;
		} else { // 否则,进行递归,把n赋给m,把余数赋给n
			return maxCommonDivisor(n, m % n);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int data = scanner.nextInt();
			sum = 0;
			for (int i = 2; i < data; i++) {
				toNBigit(data, i);
			}
			if (sum % (data - 2) == 0) {
				System.out.println(sum + "/1");
			} else {
				int m = maxCommonDivisor(sum, (data - 2));
				if (m != 0) {
					System.out.println((sum / m) + "/" + (data - 2) / m);
				} else {
					System.out.println(sum + "/" + (data - 2));
				}
			}
		}
		scanner.close();
	}

}
