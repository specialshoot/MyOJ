package huawei;

import java.util.Scanner;

public class MidMove {

	public static void getLastPosition(String[] strings) {
		int x=0,y=0;
		int length = strings.length;
		for (int i = 0; i < length; i++) {
			int len = strings[i].trim().length();
			if (len == 0) {
				continue;
			}
			String start = strings[i].trim().substring(0, 1);
			String end = strings[i].trim().substring(1);
			int num = 0;
			try {
				num = Integer.parseInt(end);
			} catch (Exception e) {
				// TODO: handle exception
				continue;
			}
			switch (start) {
			case "A":
				x-=num;
				break;
			case "D":
				x += num;
				break;
			case "W":
				y += num;
				break;
			case "S":
				y -= num;
				break;
			default:
				break;
			}
		}
		System.out.println(x+","+y);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String[] strings = scanner.nextLine().split(";");
			getLastPosition(strings);
		}
	}

}
