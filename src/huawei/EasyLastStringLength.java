package huawei;

import java.util.Scanner;

public class EasyLastStringLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String str = scanner.nextLine();
			System.out.println(str.trim().substring(str.lastIndexOf(" ") + 1, str.trim().length()).length());
		}
	}

}
