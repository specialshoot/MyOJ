package huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 字符串合并处理
 * 
 * @author han
 *
 */
public class MidMixString {

	static char[] mask = { '0', '8', '4', 'C', '2', 'A', '6', 'E', '1', '9', '5', 'D', '3', 'B', '7', 'F' };

	private static void mix(String str1, String str2) {
		String str = str1 + str2;
		int len = str.length();
		List<String> listodd = new ArrayList<>();
		List<String> listoven = new ArrayList<>();
		for (int i = 0; i < len; i++) {
			if (i % 2 == 0) {
				listodd.add(str.substring(i, i + 1));
			} else {
				listoven.add(str.substring(i, i + 1));
			}
		}
		Collections.sort(listodd);
		Collections.sort(listoven);
		int lenodd = listodd.size();
		int lenoven = listoven.size();
		StringBuilder builder = new StringBuilder();
		int ii = 0;
		while (lenodd != 0 && lenoven != 0) {
			builder.append(listodd.get(ii));
			builder.append(listoven.get(ii));
			ii++;
			lenodd--;
			lenoven--;
		}
		if (lenodd != 0) {
			builder.append(listodd.get(ii));
		}
		for (int i = 0; i < builder.length(); i++) {
			char temp = builder.charAt(i);
			if (Character.isDigit(temp) || (temp >= 'a' && temp <= 'f') || (temp >= 'A' && temp <= 'F')) {
				builder.replace(i, i + 1, String.valueOf(zhuanhuan(temp)));
			}
		}
		System.out.println(builder);
	}

	private static char zhuanhuan(char c) {
		if (c >= '0' && c <= '9') {
			return mask[c - '0'];
		}
		if (c >= 'a' && c <= 'f') {
			return mask[c - 'a' + 10];
		}
		if (c >= 'A' && c <= 'F') {
			return mask[c - 'A' + 10];
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String str1 = scanner.next();
			String str2 = scanner.next();
			mix(str1, str2);
		}
		scanner.close();
	}

}
