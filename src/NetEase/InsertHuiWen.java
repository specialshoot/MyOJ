package NetEase;

import java.util.Scanner;

/**
 * “回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。花花非常喜欢这种拥有对称美的回文串，
 * 生日的时候她得到两个礼物分别是字符串A和字符串B。现在她非常好奇有没有办法将字符串B插入字符串A使产生的字符串是一个回文串。你接受花花的请求，
 * 帮助她寻找有多少种插入办法可以使新串是一个回文串。如果字符串B插入的位置不同就考虑为不一样的办法。 例如： A = “aba”，B =
 * “b”。这里有4种把B插入A的办法： 在A的第一个字母之前: "baba" 不是回文 在第一个字母‘a’之后: "abba" 是回文 在字母‘b’之后:
 * "abba" 是回文 在第二个字母'a'之后 "abab" 不是回文 所以满足条件的答案为2 输入描述: 每组输入数据共两行。 第一行为字符串A
 * 第二行为字符串B 字符串长度均小于100且只包含小写字母
 * 
 * 
 * 输出描述: 输出一个数字，表示把字符串B插入字符串A之后构成一个回文串的方法数
 * 
 * 输入例子:
 * 
 * aba
 * 
 * b
 * 
 * 输出例子: 2
 * 
 * @author han
 *
 */
public class InsertHuiWen {

	private static boolean isHuiWen(String str) {
		int len = str.length();
		for (int i = 0; i <= len / 2; i++) {
			if (str.charAt(i) != str.charAt(len - i - 1)) {
				return false;
			}
		}
		return true;
	}

	private static int getHuiWenCount(String str1, String str2) {
		int len1 = str1.length();
		int count = 0;
		if (isHuiWen(str2 + str1)) {
			++count;
		}
		if (isHuiWen(str1 + str2)) {
			++count;
		}
		for (int i = 1; i < len1; i++) {
			if (isHuiWen(str1.substring(0, i) + str2 + str1.substring(i))) {
				++count;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String str1 = scanner.next();
			String str2 = scanner.next();
			System.out.println(getHuiWenCount(str1, str2));
		}
		scanner.close();
	}

}
