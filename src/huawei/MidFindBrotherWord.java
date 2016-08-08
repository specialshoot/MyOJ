package huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MidFindBrotherWord {

	private static void getBrother(int n, String[] strs, String host, int index) {
		int len = host.length();
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			boolean isOK = false;
			for (int j = 0; j < len; j++) {
				if (strs[i].length() != len || strs[i].equals(host)) {
					isOK = false;
					break;
				}
				if (!strs[i].contains(host.substring(j, j + 1))) {
					isOK = false;
					break;
				}
				isOK = true;
			}
			if (isOK) {
				list.add(strs[i]);
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		System.out.println(list.get(index - 1));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			String[] strs = new String[n];
			for (int i = 0; i < n; i++) {
				strs[i] = scanner.next();
			}
			String host = scanner.next();
			int index = scanner.nextInt();
			getBrother(n, strs, host, index);
		}
		scanner.close();
	}

}
