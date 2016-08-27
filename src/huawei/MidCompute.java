package huawei;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 四则运算
 * 
 * @author han
 *
 */
public class MidCompute {

	/**
	 * 格式化运算字符串
	 * 
	 * @param str
	 * @return
	 */
	public static String format(String str) {
		String t = str.replace("(\\s)+", "");// 去掉空格
		int idx = 0;
		while ((idx = t.indexOf('-', idx)) >= 0) {
			// 第一个字符是负号，要规格形式要加上0
			if (idx == 0) {
				t = '0' + t;
			}
			// 如果不是第一个字符
			else {
				char c = t.charAt(idx - 1);
				// 负号前面有括号，需要在前面加0
				if (c == '(' || c == '[' || c == '{') {
					t = t.substring(0, idx) + '0' + t.substring(idx);
				}
			}
			idx++;
		}
		return t;
	}

	/**
	 * 进行计算
	 * 
	 * @param str
	 * @return
	 */
	public static int calculate(String str) {
		// 操作符栈
		Deque<Character> opts = new LinkedList<>();
		// 操作数栈
		Deque<Integer> opds = new LinkedList<>();

		int idx = 0;
		int len = str.length();
		while (idx < len) {
			char c = str.charAt(idx);
			if (Character.isDigit(c)) {// 处理数字
				// 计算数字的值
				int opd = 0;
				while (idx < len && Character.isDigit(str.charAt(idx))) {
					opd = opd * 10 + (str.charAt(idx) - '0');
					idx++;
				}
				opds.addLast(opd);
			} else {// 处理运算符
				if (c == '(' || c == '[' || c == '{') {
					opts.addLast(c);
				} else if (c == ')' || c == ']' || c == '}') {
					while (!opts.isEmpty() && (opts.getLast() != '(')
							&& (opts.getLast() != '[' && opts.getLast() != '{')) {
						calculate(opts, opds);
					}
					opts.removeLast();
				} else if (c == '*' || c == '/') {
					while (!opts.isEmpty() && (opts.getLast() == '*' || opts.getLast() == '/')) {
						calculate(opts, opds);
					}
					opts.addLast(c);// 操作符入栈
				} else if (c == '+' || c == '-') {
					while (!opts.isEmpty() && (opts.getLast() == '*' || opts.getLast() == '/' || opts.getLast() == '+'
							|| opts.getLast() == '-')) {
						calculate(opts, opds);
					}
					opts.addLast(c);// 操作符入栈
				}
				// 处理下一个字符
				idx++;
			}
		}

		while (!opts.isEmpty()) {
			calculate(opts, opds);
		}
		return opds.removeLast();
	}

	/**
	 * 
	 * @param opts
	 *            操作符栈
	 * @param opds操作数栈
	 */
	private static void calculate(Deque<Character> opts, Deque<Integer> opds) {
		char opt = opts.removeLast();// 取操作符栈最后一个操作符
		// 取操作数
		int v2 = opds.removeLast();
		int v1 = opds.removeLast();
		// 计算
		opds.addLast(calculate(v1, v2, opt));
	}

	/**
	 * 四则运算
	 * 
	 * @param v1
	 * @param v2
	 * @param operator
	 * @return
	 */
	private static int calculate(int v1, int v2, char operator) {
		switch (operator) {
		case '+':
			return v1 + v2;
		case '-':
			return v1 - v2;
		case '*':
			return v1 * v2;
		case '/':
			return v1 / v2;
		default:
			break;
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			System.out.println(calculate(format(scanner.nextLine())));
		}
		scanner.close();
	}

}
