package huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * 
 * 成绩排序
 * @author han
 *
 */
public class MidOrderScore {

	static boolean sheng = true;

	private static Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {

		@Override
		public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
			// TODO Auto-generated method stub
			int v1 = o1.getValue();
			int v2 = o2.getValue();
			if (v1 < v2) {
				return sheng ? -1 : 1;
			}
			if (v1 > v2) {
				return sheng ? 1 : -1;
			} else {
				return 0;
			}
		}
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			sheng = scanner.nextInt() == 1 ? true : false;
			Map<String, Integer> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				map.put(scanner.next(), scanner.nextInt());
			}

			List<Map.Entry<String, Integer>> maplist = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
			Collections.sort(maplist, comparator);
			for (int i = 0; i < maplist.size(); i++) {
				System.out.println(maplist.get(i).getKey() + " " + maplist.get(i).getValue());
			}
		}
		scanner.close();
	}
}
