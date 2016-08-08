package huawei;

/**
 * iNOC 完全数计算
 */
import java.util.Scanner;

public class EasyPerfectNumber {

	public static int count(int n) {
		int count = 0;
		for (int i = 2; i <= n; i++) {// 从2开始遍历
			int sum = 1;
			int half = i / 2;
			for (int j = 2; j <= half; j++) {
				if (i % j == 0) {
					sum += j;
				}
			}
			if (sum == i) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			System.out.println(count(n) + "");
		}
	}

}
