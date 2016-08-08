package huawei;

import java.util.Scanner;

public class EasySnake {

	public static void getSnake(int n) {
		if (n == 0) {
			return;
		}
		for (int i = 1; i <= n; i++) {
			int first = 1 + i * (i - 1) / 2;
			String res = "";
			for (int j = 0; j <= n - i; j++) {
				int second = (j) * (i + 1) + (j - 1) * j / 2;
				res = res + (first + second) + " ";
			}
			System.out.println(res.trim());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			getSnake(n);
		}
		scanner.close();
	}

}
