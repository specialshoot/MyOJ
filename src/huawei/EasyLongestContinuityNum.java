package huawei;

import java.util.Scanner;

/**
 * 在字符串中找出连续最长的数字串
 * 
 * @author han
 *
 */
public class EasyLongestContinuityNum {

	private static void getLongest(String str) {
		char[] ch = str.toCharArray();
		int len = ch.length;
		int max = 0;
		int tempCount = 0;
		int index = 0;
		for (int i = 0; i < len; i++) {
			if (Character.isDigit(ch[i])) {
				tempCount++;
				if (tempCount > max) {
					index = i;
					max = tempCount;
				}
			} else {
				tempCount = 0;
			}
		}
		if (max == 0) {
			System.out.println("0");
		} else {
			System.out.println(str.substring(index - max + 1, index + 1) + "," + max);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String str = scanner.next();
			getLongest(str);
		}
		scanner.close();
	}

}
