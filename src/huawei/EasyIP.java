package huawei;

import java.util.Scanner;

/**
 * 合法IP
 * 
 * @author han
 *
 */
public class EasyIP {

	private static boolean check(String str) {
		String[] strs = str.split("\\.");
		int len = strs.length;
		for (int i = 0; i < len; i++) {
			int temp = Integer.parseInt(strs[i]);
			if (!(temp >= 0 && temp <= 255)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String ip = scanner.nextLine();
			System.out.println(check(ip) ? "YES" : "NO");
		}
		scanner.close();
	}

}
