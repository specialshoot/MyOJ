package huawei;

import java.util.Scanner;

public class MidWordSort {

	public static void getStr(String str) {
		int len = str.length();
		char[] ch = str.toCharArray();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < len; j++) {
				if (ch[j] == i + 'a' || ch[j] == i + 'A') {
					builder.append(ch[j]);
				}
			}
		}
		StringBuilder result = new StringBuilder();
		int j = 0;
		for (int i = 0; i < len; i++) {
			if (Character.isAlphabetic(ch[i])) {
				result.append(builder.charAt(j));
				j++;
			} else {
				result.append(ch[i]);
			}
		}
		System.out.println(result.toString());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String str = scanner.nextLine();
			getStr(str);
		}
		scanner.close();
	}

}
