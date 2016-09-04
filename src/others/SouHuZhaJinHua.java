package others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SouHuZhaJinHua {

	/**
	 * 校验并排序
	 * 
	 * @param str
	 * @param list
	 * @return
	 */
	public static boolean check(String str, ArrayList<Integer> list) {
		int len = str.length();
		char[] ch = str.toCharArray();
		int i = 0;
		while (i < len) {
			if (ch[i] == 'J') {
				list.add(11);
			} else if (ch[i] == 'Q') {
				list.add(12);
			} else if (ch[i] == 'K') {
				list.add(13);
			} else if (ch[i] == 'A') {
				list.add(14);
			} else if (ch[i] >= '2' && ch[i] <= '9') {
				list.add((int) (ch[i] - '0'));
			} else if (ch[i] == '1') {
				if ((i + 1) < len) {
					++i;
					if (ch[i] == '0') {
						list.add(10);
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
			++i;
		}
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});
		if (list.size() != 3) {
			return false;
		}
		return true;
	}

	public static int getCompare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		int same1 = sameCount(list1);
		int same2 = sameCount(list2);
		if ((same1 == 3 && same2 == 3) || (same1 == 2 && same2 == 2)) {
			if (list1.get(0) > list2.get(0)) {
				return 1;
			}
			if (list1.get(0) == list2.get(0)) {
				return 0;
			}
			if (list1.get(0) < list2.get(0)) {
				return -1;
			}
		}

		if ((same1 == 3 && same2 < 3) || (same1 == 2 && same2 < 2)) {
			return 1;
		}

		if ((same2 == 3 && same1 < 3) || (same2 == 2 && same1 < 2)) {
			return -1;
		}

		for (int i = 0; i < 3; i++) {
			if (list1.get(i) > list2.get(i)) {
				return 1;
			}
			if (list1.get(i) < list2.get(i)) {
				return -1;
			}
		}
		return 0;
	}

	public static int sameCount(ArrayList<Integer> list) {
		if (list.get(0) == list.get(1) && list.get(1) == list.get(2)) {
			return 3;
		}
		if (list.get(0) == list.get(1) || list.get(1) == list.get(2) || list.get(0) == list.get(2)) {
			return 2;
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String str1 = scanner.next();
			String str2 = scanner.next();
			ArrayList<Integer> list1 = new ArrayList<>();
			ArrayList<Integer> list2 = new ArrayList<>();
			if (!check(str1, list1) || !check(str2, list2)) {
				System.out.println(-2);
				continue;
			}
			System.out.println(getCompare(list1, list2));
		}
		scanner.close();
	}

}
