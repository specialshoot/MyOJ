package huawei;

import java.util.Scanner;

/**
 * 尼科彻斯定理
 * @author han
 *
 */
public class EasyNico {

	public static void output(int n) {
		int first = n * n - n + 1;
		String temp = "";
		for (int i = 0; i < n; i++) {
			temp += (first + i * 2) + "+";
		}
		System.out.println(temp.substring(0, temp.length() - 1));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			output(n);
		}
		scanner.close();
	}

}
