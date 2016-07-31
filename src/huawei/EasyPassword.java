package huawei;

import java.util.Scanner;

public class EasyPassword {

	private static String CryptoPrimitive(String s, boolean isCrypto) {
		char[] cs = s.toCharArray();
		int len = cs.length;
		for (int i = 0; i < len; i++) {
			if (cs[i] >= 48 && cs[i] <= 57) {
				// 数字
				cs[i] = isCrypto ? (cs[i] == 57 ? 48 : (char) (cs[i] + 1)) : (cs[i] == 48 ? 57 : (char) (cs[i] - 1));
				continue;
			}
			if (cs[i] >= 65 && cs[i] <= 90) {
				// 大写字母
				cs[i] = isCrypto ? (cs[i] == 90 ? 97 : (char) (cs[i] + 33)) : (cs[i] == 65 ? 122 : (char) (cs[i] + 31));
				continue;
			}
			if (cs[i] >= 97 && cs[i] <= 122) {
				// 小写字母
				cs[i] = isCrypto ? (cs[i] == 122 ? 65 : (char) (cs[i] - 31)) : (cs[i] == 97 ? 90 : (char) (cs[i] - 33));
				continue;
			}
		}
		return String.valueOf(cs);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String crypto = scanner.next();
			String decrypt = scanner.next();
			System.out.println(CryptoPrimitive(crypto, true));
			System.out.println(CryptoPrimitive(decrypt, false));
		}
		scanner.close();
	}

}
