package huawei;

import java.util.Scanner;

public class EasyRotateString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String str = scanner.nextLine();
			int len = str.length();
			for (int i = len - 1; i >= 0; i--) {
				System.out.print(str.substring(i, i + 1));
			}
			System.out.println();
		}
		scanner.close();
	}

}
