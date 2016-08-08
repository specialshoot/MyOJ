package huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class EasyBeautifulName {

	static Comparator<Map.Entry<Character, Integer>> cmp = new Comparator<Map.Entry<Character, Integer>>() {// 根据value排序
		@Override
		public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
			// TODO Auto-generated method stub
			return o2.getValue().compareTo(o1.getValue());
		}
	};

	public static void getBeauty(String[] strs, int n) {
		for (int i = 0; i < n; i++) {
			char[] str = strs[i].toCharArray();
			int length = str.length;
			Map<Character, Integer> map = new HashMap<>();
			for (int j = 0; j < length; j++) {
				if (map.containsKey(str[j])) {
					map.put(str[j], map.get(str[j]) + 1);
				} else {
					map.put(str[j], 1);
				}
			}
			List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());
			Collections.sort(list, cmp);// 将字符串按照字典序排序
			int start = 26;
			int count = 0;
			for (int j = 0; j < list.size(); j++) {
				count += (list.get(j).getValue()) * start;
				--start;
			}
			System.out.println(count + "");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			String[] strs = new String[n];
			for (int i = 0; i < n; i++) {
				strs[i] = scanner.next().toLowerCase().trim();
			}
			getBeauty(strs, n);
		}
		scanner.close();
	}

}
