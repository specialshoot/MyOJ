package huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 判断一个长字符串是否包含短字符串中的所有英文字符字符
 * @author han
 *
 */
public class EasyStringMatch {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String sub = scanner.next();
			String s = scanner.next();
			System.out.println(contains(s, sub));
		}

		scanner.close();
	}

	private static boolean contains(String s, String sub) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			set.add(s.charAt(i));
		}

		for (int i = 0; i < sub.length(); i++) {
			if (!set.contains(sub.charAt(i))) {
				return false;
			}
		}

		return true;
	}
}