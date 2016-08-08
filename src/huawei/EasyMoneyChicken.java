package huawei;

import java.util.Scanner;

public class EasyMoneyChicken {

	private static int GetResult() {
		int countMaxX = 100 / 7;
		int count = 0;
		for (int i = 0; i < countMaxX; i++) {
			int YUy = (100 - 7 * i) % 4;
			if (YUy == 0) {
				int x = i;
				int y = (100 - 7 * i) / 4;
				int z = 100 - x - y;
				count++;
				System.out.println(x + " " + y + " " + z);
			}
		}
		return count == 0 ? -1 : 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int a = scanner.nextInt();
			GetResult();
		}
		scanner.close();
	}

}
