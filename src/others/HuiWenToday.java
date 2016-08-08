package others;

/**
 * http://www.nowcoder.com/test/question/17517002460f453eb97a73439fc10ec8?pid=1649301&tid=3783298
 * 今日头条笔试
 * AC
 * @author han
 *
 */
import java.util.Scanner;

public class HuiWenToday {

	private static Scanner scanner;

	public static String getHuiWen(String s, int l, int r) {
		String s1 = s.substring(l, l + r);
		String s2 = new StringBuffer(s1).reverse().toString();
		return new StringBuffer(s.substring(0, l + r)).append(s2).append(s.substring(l + r)).toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scanner = new Scanner(System.in);
		String test = scanner.nextLine();
		int count = scanner.nextInt();
		while (count != 0) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			test = getHuiWen(test, a, b);
			count--;
		}
		System.out.println(test);
	}
}
