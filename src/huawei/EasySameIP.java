package huawei;

// 判断两个IP是否属于同一子网
import java.math.BigInteger;
import java.util.Scanner;

public class EasySameIP {

	/**
	 * 功能: 判断两台计算机IP地址是同一子网络。
	 * 
	 * @param mask
	 *            子网掩码，格式：“255.255.255.0”；
	 * @param ip1
	 *            计算机1的IP地址，格式：“192.168.0.254”；
	 * @param ip2
	 *            计算机2的IP地址，格式：“192.168.0.1”；
	 * @return 0：IP1与IP2属于同一子网络； 1：IP地址或子网掩码格式非法； 2：IP1与IP2不属于同一子网络
	 */
	public static int checkNetSegment(String mask, String ip1, String ip2) {
		/* 在这里实现功能 */
		if (!validIP(mask) || !validIP(ip1) || !validIP(ip2)) {
			return 1;
		}
		String[] masks = mask.split("\\.");
		String maskBinary = "";
		for (int i = 0; i < 4; i++) {
			String temp = new BigInteger(masks[i]).toString(2);
			while (temp.length() != 8) {
				temp = '0' + temp;
			}
			maskBinary += temp;// 转化为2进制字符串
		}

		String[] ip1s = ip1.split("\\.");
		String ip1Binary = "";
		for (int i = 0; i < 4; i++) {
			String temp = new BigInteger(ip1s[i]).toString(2);
			while (temp.length() != 8) {
				temp = '0' + temp;
			}
			ip1Binary += temp;// 转化为2进制字符串
		}

		String[] ip2s = ip2.split("\\.");
		String ip2Binary = "";
		for (int i = 0; i < 4; i++) {
			String temp = new BigInteger(ip2s[i]).toString(2);
			while (temp.length() != 8) {
				temp = '0' + temp;
			}
			ip2Binary += temp;// 转化为2进制字符串
		}

		String and1 = computeBinary(maskBinary, ip1Binary);
		String and2 = computeBinary(maskBinary, ip2Binary);
		if (and1.equals(and2)) {
			return 0;// 同一网络
		}
		return 2;// 不同网络
	}

	private static boolean validIP(String ip) {
		String[] ips = ip.split("\\.");
		if (ips.length != 4) {
			return false;
		}
		for (int i = 0; i < ips.length; i++) {
			if (Integer.parseInt(ips[i]) < 0 || Integer.parseInt(ips[i]) > 255) {
				return false;
			}
		}
		return true;
	}

	private static String computeBinary(String maskBinary, String ipBinary) {
		int len = maskBinary.length();
		char[] ch = new char[len];
		for (int i = 0; i < len; i++) {
			ch[i] = (char) (maskBinary.charAt(i) & ipBinary.charAt(i));
		}
		return String.valueOf(ch);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String mask = scanner.next();
			String ip1 = scanner.next();
			String ip2 = scanner.next();
			System.out.println(checkNetSegment(mask, ip1, ip2) + "");
		}
		scanner.close();
	}

}
