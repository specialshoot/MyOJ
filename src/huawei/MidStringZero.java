package huawei;

import java.util.Scanner;

/**
 * 字符串分隔 连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组； 长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 
 * @author han
 *
 */
public class MidStringZero {

	public static void getString(String str) {
		int len = str.length();
		if (len <= 8) {
			String res = str;
			for (int i = 0; i < 8 - len; i++) {
				res += "0";
			}
			System.out.println(res);
		} else {
			System.out.println(str.substring(0, 8));
			getString(str.substring(8));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String str = scanner.next();
			getString(str);
		}
		scanner.close();
	}

}
