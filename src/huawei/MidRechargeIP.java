package huawei;

import java.util.Scanner;

/**
 * 整数与IP地址间的转换
 * 
 * @author han
 *
 */
public class MidRechargeIP {

	private static long ipToInt(String ip) {
		String[] strs = ip.split("\\.");
		if (strs.length != 4) {
			return 0;
		}
		long res = 0;
		for (int i = 0; i < 4; i++) {
			res = (res << 8) + Integer.parseInt(strs[i]);
		}
		return res;
	}

	private static String intToIp(String str) {
		String result = "";
		Long input = Long.parseLong(str);
		for (int i = 3; i >= 0; i--) {
			result = (input & 0x000000FF) + "." + result;
			input >>>= 8;
		}
		return result.substring(0, result.length() - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String ip = scanner.next();
			String str = scanner.next();
			System.out.println(ipToInt(ip));
			System.out.println(intToIp(str));
		}
		scanner.close();
	}

}
