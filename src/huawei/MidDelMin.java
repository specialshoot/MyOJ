package huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MidDelMin {

	private static String delMin(String str) {
		if (str.isEmpty()) {
			return "";
		}
		Map<Character, Integer> map = new HashMap<>();
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
		List<Map.Entry<Character, Integer>> maplist = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());

		Collections.sort(maplist, new Comparator<Map.Entry<Character, Integer>>() {
			public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
				// return (o2.getValue() - o1.getValue());
				return (o1.getValue() > o2.getValue() ? 1 : -1);
			}
		});

		int min = maplist.get(0).getValue();
		for (int i = 0; i < maplist.size(); i++) {
			if (maplist.get(i).getValue() > min) {
				break;
			}
			str = str.replaceAll(String.valueOf(maplist.get(i).getKey()), "");
		}
		return str;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String str = scanner.next();
			System.out.println(delMin(str));
		}
		scanner.close();
	}

}
