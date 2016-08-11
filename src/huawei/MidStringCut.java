package huawei;

import java.util.Scanner;

public class MidStringCut {

	private static final int LENGTH = 8;

	public static void output(String str) {
		int len = str.length();
		if (len <= LENGTH) {
			String res = str;
			for (int i = len; i < LENGTH; i++) {
				res += "0";
			}
			System.out.println(res);
			return;
		} else {
			System.out.println(str.substring(0, LENGTH));
			output(str.substring(LENGTH));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			for (int i = 0; i < n; i++) {
				output(scanner.next());
			}
		}
		scanner.close();
	}
}
