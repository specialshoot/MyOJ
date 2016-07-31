package huawei;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FindChar {

	private static String findChar(String str) {
		Map<Character, Integer> map = new LinkedHashMap<>();
		char[] ch = str.toCharArray();
		int len = ch.length;
		for (int i = 0; i < len; i++) {
			char key = ch[i];
			if (map.containsKey(key)) {
				map.put(key, map.get(key) + 1);
			} else {
				map.put(key, 1);
			}
		}
		Iterator it = map.keySet().iterator();
		while (it.hasNext()) {
			char key = (char) it.next();
			if (map.get(key) == 1) {
				return String.valueOf(key);
			}
		}
		return ".";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String str = scanner.nextLine();
			System.out.println(findChar(str));
		}
		scanner.close();
	}

}
