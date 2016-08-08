package huawei;

import java.util.Scanner;

public class MidPasswordQualified {

	private static void test(String str) {
		if (str.length() <= 8) {
			System.out.println("NG");
			return;
		}
		char[] strs = str.toCharArray();
		int len = strs.length;
		int xiaoxie = 0, daxie = 0, shuzi = 0, qita = 0;
		for (int i = 0; i < len; i++) {
			if (strs[i] >= 'a' && strs[i] <= 'z') {
				xiaoxie = 1;
			} else if (strs[i] >= 'A' && strs[i] <= 'Z') {
				daxie = 1;
			} else if (strs[i] >= '0' && strs[i] <= '9') {
				shuzi = 1;
			} else {
				qita = 1;
			}
		}
		if (xiaoxie + daxie + shuzi + qita < 3) {
			System.out.println("NG");
			return;
		}
		for (int i = 0; i < len - 3; i++) {
			String str1 = str.substring(i, i + 3);
			String str2 = str.substring(i + 3);
			if (str2.contains(str1)) {
				System.out.println("NG");
				return;
			}
		}
		System.out.println("OK");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String str = scanner.next();
			test(str);
		}
		scanner.close();
	}

}
