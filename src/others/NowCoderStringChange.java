package others;

import java.util.LinkedList;

/**
 * 字符串变形 对于一个给定的字符串，我们需要在线性(也就是O(n))的时间里对它做一些变形。首先这个字符串中包含着一些空格，就像"Hello World"
 * 一样，然后我们要做的是把着个字符串中由空格隔开的单词反序，同时反转每个字符的大小写。比如"Hello World"变形后就变成了"wORLD hELLO"
 * 。
 * 
 * 输入描述: 给定一个字符串s以及它的长度n(1≤n≤500)
 * 
 * 
 * 输出描述: 请返回变形后的字符串。题目保证给定的字符串均由大小写字母和空格构成。
 * 
 * 输入例子: "This is a sample",16
 * 
 * 输出例子: "SAMPLE A IS tHIS"
 * 
 * 注意中间空格要保留！！！！！！！！！
 * 
 * @author han
 *
 */
public class NowCoderStringChange {

	public static char reverse(char ch) {
		if (ch >= 'a' && ch <= 'z') {
			return (char) (ch - 'a' + 'A');
		}
		if (ch >= 'A' && ch <= 'Z') {
			return (char) (ch - 'A' + 'a');
		}
		return 0;
	}

	public static String trans(String s, int n) {
		// write code here
		StringBuilder builder = new StringBuilder();
		LinkedList<Character> temp = new LinkedList<>();
		char[] ch = s.toCharArray();
		for (int i = n - 1; i >= 0; i--) {
			if (ch[i] != ' ') {
				temp.addLast(ch[i]);
			} else {
				if (!temp.isEmpty()) {
					while (!temp.isEmpty()) {
						builder.append(reverse(temp.removeLast()));
					}
				}
				builder.append(" ");
			}
		}
		if (!temp.isEmpty()) {
			while (!temp.isEmpty()) {
				builder.append(reverse(temp.removeLast()));
			}
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trans("Now Co der", 10));
	}

}
