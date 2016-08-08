package huawei;

import java.util.Scanner;

public class MidPasswordCrack {

	/**
	 * @param str
	 * @return
	 */
	private static String zhuan(String str) {
		char[] ch = str.toCharArray();
		int len = ch.length;
		String temp = "";
		for (int i = 0; i < len; i++) {
			if (ch[i] >= 'A' && ch[i] < 'Z') {
				temp += String.valueOf((char) (ch[i] - 'A' + 'a' + 1));
				continue;
			}
			if (ch[i] == 'Z') {
				temp += "a";
				continue;
			}
			if (ch[i] >= 'a' && ch[i] < 'z') {
				temp += (int) ((ch[i] - 'a') / 3 + 2) + "";
				continue;
			}
			if (ch[i] == 'z') {
				temp += (int) ((ch[i] - 'a') / 3 + 1) + "";
				continue;
			}
			temp += String.valueOf(ch[i]);
		}
		return temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String str = scanner.next();
			System.out.println(zhuan(str));
		}
		scanner.close();
	}
}
