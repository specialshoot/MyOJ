package huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class WordMaxMinCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String str = scanner.nextLine();
			str = str.replace(",", " ");
			str = str.replace(".", " ");
			String[] strs = str.split("\\s+");
			if (strs == null || strs.length == 0) {
				continue;
			}
			Map<String, Integer> map = new LinkedHashMap<String, Integer>();
			for (String s : strs) {
				String key = s.toLowerCase();
				if (map.containsKey(key)) {
					map.put(key, map.get(key) + 1);
				} else {
					map.put(key, 1);
				}
			}
			List<Map.Entry<String, Integer>> infos = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
			Collections.sort(infos, new Comparator<Map.Entry<String, Integer>>() {

				@Override
				public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
					// TODO Auto-generated method stub
					if (o1.getValue() < o2.getValue()) {
						return -1;
					} else if (o1.getValue() > o2.getValue()) {
						return 1;
					} else {
						return 0;
					}
				}
			});
			int min = Integer.MAX_VALUE;
			int max = 0;
			String minString = "";
			String maxString = "";
			for (Map.Entry<String, Integer> mapentry : infos) {
				if (min > mapentry.getValue()) {
					min = mapentry.getValue();
					minString = mapentry.getKey();
				}
				if (max < mapentry.getValue()) {
					max = mapentry.getValue();
					maxString = mapentry.getKey();
				}
			}
			System.out.println(maxString + "," + minString);
		}
		scanner.close();
	}

}
