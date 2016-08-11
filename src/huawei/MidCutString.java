package huawei;

import java.util.Scanner;

/**
 * 按字节截取字符串
 * 
 * @author han
 *
 */
public class MidCutString {

	public static String cutString(String s, int length) {
		int sum = 0;
		int i = 0;
		StringBuilder builder = new StringBuilder();
		while (sum < length) {
			if (String.valueOf(s.charAt(i)).getBytes().length == 1) {
				sum++;
				builder.append(s.charAt(i));
			} else {
				sum += 2;
				if (sum > length) {
					break;
				}
				builder.append(s.charAt(i));
			}
			i++;
		}
		return builder.substring(0, i);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s = scanner.next();
			int length = scanner.nextInt();
			System.out.println(cutString(s, length));
		}
		scanner.close();
	}

}
