package others;

import java.util.Scanner;

public class Main {

	public static void getRes(String[] strs) {
		int x = 0, y = 0;
		int len = strs.length;
		if(len==0){
			System.out.println(x + "," + y);
			return;
		}
		for (int i = 0; i < len; i++) {
			int length = strs[i].length();
			if (length <= 1) {
				continue;
			}
			try {
				String s = strs[i].substring(0, 1);
				int num = Integer.parseInt(strs[i].substring(1));
				if (s.equals("A")) {
					x -= num;
				} else if (s.equals("D")) {
					x += num;
				} else if (s.equals("W")) {
					y += num;
				} else if (s.equals("S")) {
					y -= num;
				} else {
					continue;
				}
			} catch (Exception e) {
				continue;
			}
		}
		System.out.println(x + "," + y);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String str = scanner.nextLine();
			String[] strs = str.split(";");
			getRes(strs);
		}
		scanner.close();
	}

}
