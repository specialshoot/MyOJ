package huawei;

import java.math.BigInteger;
import java.util.Scanner;

public class MidIP {

	private static int a = 0, b = 0, c = 0, d = 0, e = 0, err = 0, own = 0;

	private static void checkIP(String ip) {
		String[] ips = ip.split("~");
		String[] ipStr = ips[0].split("\\.");// 注意分隔.一定要用\\.
		String[] maskStr = ips[1].split("\\.");
		if (ipStr.length != 4 || maskStr.length != 4) {
			err++;
			return;
		}

		int[] ipInt = new int[4];
		int[] maskInt = new int[4];
		for (int i = 0; i < 4; i++) {
			try {
				ipInt[i] = Integer.parseInt(ipStr[i]);
				maskInt[i] = Integer.parseInt(maskStr[i]);
				if (ipInt[i] > 255 || maskInt[i] > 255) {
					err++;
					return;
				}
			} catch (Exception e) {
				err++;
				return;
			}
		}

		String maskBinary = "";
		for (int i = 0; i < 4; i++) {
			maskBinary += new BigInteger(maskStr[i]).toString(2);// 转化为2进制字符串
		}

		int index = maskBinary.indexOf("0");// 找到第一个为0的字符的位置
		String temp = maskBinary.substring(index + 1);
		if (temp.contains("1")) {// 后面的字符包含1，说明掩码错误
			err++;
			return;
		}

		int startIP = ipInt[0];
		int secondIP = ipInt[1];
		if (startIP >= 1 && startIP <= 126) {
			a++;
		}
		if (startIP >= 128 && startIP <= 191) {
			b++;
		}
		if (startIP >= 192 && startIP <= 223) {
			c++;
		}
		if (startIP >= 224 && startIP <= 239) {
			d++;
		}
		if (startIP >= 240 && startIP <= 255) {
			e++;
		}
		if (startIP == 10 || (startIP == 172 && secondIP >= 16 && secondIP <= 31)
				|| (startIP == 192 && secondIP == 168)) {
			own++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String ip = scanner.nextLine();
			checkIP(ip);
		}
		System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + err + " " + own);
		scanner.close();
	}
}
