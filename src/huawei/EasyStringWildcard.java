package huawei;

import java.util.Scanner;

/**
 * 字符串通配符
 * 
 * @author han
 *
 */
public class EasyStringWildcard {

	private static boolean match(String reg, String str) {
		return match(reg, 0, str, 0);
	}

	private static boolean match(String reg, int i, String str, int j) {
		if (i >= reg.length()) {
			// reg到结尾了
			return j >= str.length();
		}
		if (j >= str.length()) {
			// str到结尾了
			return i >= str.length();
		}

		boolean result = false;
		switch (reg.charAt(i)) {
		case '*':
			// 匹配任意字符
			result = match(reg, i, str, j + 1);
			if (result) {
				return true;
			}
			// 不匹配字符
			result = match(reg, i + 1, str, j);

			if (result) {
				return true;
			}
			// 只匹配一个字符
			result = match(reg, i + 1, str, j + 1);
			break;
		case '?':
			result = match(reg, i + 1, str, j + 1);
			break;
		default:
			if (reg.charAt(i) == str.charAt(j)) {
				// 两字符串相同
				result = match(reg, i + 1, str, j + 1);
			}
			break;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String reg = scanner.next();
			String str = scanner.next();
			System.out.println(match(reg, str));
		}
		scanner.close();
	}

}
