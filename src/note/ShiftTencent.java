package note;

/**
 * [编程题] 算法基础-字符移位
 * 小Q最近遇到了一个难题：把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变，且不能申请额外的空间。
 * 你能帮帮小Q吗？
 * 
 * 输入描述:
 * 输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.
 * 
 * 输出描述:
 * 对于每组数据，输出移位后的字符串。
 * 
 * 输入例子:
 * AkleBiCeilD
 * 
 * 输出例子:
 * kleieilABCD
 */
import java.util.Scanner;

public class ShiftTencent {

	private static Scanner scanner;

	public static String shift(String s) {
		String result = "";
		char[] ss = s.toCharArray();
		int length = ss.length;
		int n = length;
		for (int i = 0; i < length; ++i) {
			if (ss[i] >= 'A' && ss[i] <= 'Z') {
				// 如果是大写
				char temp = ss[i];
				for (int j = i; j < n - 1; ++j) {
					ss[j] = ss[j + 1];
				}
				ss[n - 1] = temp;
				--length;
				--i;
			}
		}
		result = new String(ss);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			System.out.println(shift(scanner.nextLine()));
		}
	}

}
