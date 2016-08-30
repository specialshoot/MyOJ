package others;

import java.util.Scanner;

/**
 * 回文解码 现在有一个字符串，你要对这个字符串进行 n 次操作，每次操作给出两个数字：(p, l) 表示当前字符串中从下标为 p 的字符开始的长度为 l
 * 的一个子串。你要将这个子串左右翻转后插在这个子串原来位置的正后方，求最后得到的字符串是什么。字符串的下标是从 0 开始的，你可以从样例中得到更多信息。
 * 
 * 输入描述: 每组测试用例仅包含一组数据，每组数据第一行为原字符串，长度不超过 10 ，仅包含大小写字符与数字。接下来会有一个数字 n 表示有 n
 * 个操作，再接下来有 n 行，每行两个整数，表示每次操作的(p , l)。
 * 
 * 
 * 保证输入的操作一定合法，最后得到的字符串长度不超过 1000。
 * 
 * 
 * 输出描述: 输出一个字符串代表最后得到的字符串。
 * 
 * 输入例子:
 * 
 * ab
 * 
 * 2
 * 
 * 0 2
 * 
 * 1 3
 * 
 * 输出例子:
 * 
 * abbaabb
 * 
 * @author han
 *
 */
public class TodayHuiWen {

	public static String reverse(String s) {
		StringBuilder builder = new StringBuilder(s);
		return builder.reverse().toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String str = scanner.next();
			int n = scanner.nextInt();
			int start = 0;
			int length = 0;
			for (int i = 0; i < n; i++) {
				start = scanner.nextInt();
				length = scanner.nextInt();
				str = str.substring(0, start + length) + reverse(str.substring(start, start + length))
						+ str.substring(start + length);
			}
			System.out.println(str);
		}
		scanner.close();
	}

}
