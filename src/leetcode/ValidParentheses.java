package leetcode;

import java.lang.Thread.State;
import java.util.Stack;

public class ValidParentheses {

	// https://leetcode.com/problems/valid-parentheses/
	// 出入栈

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if (temp == '{' || temp == '[' || temp == '(') {
				stack.push(temp);
			}
			if (temp == '}') {
				if (!stack.isEmpty() && stack.pop() == '{') {
					continue;
				} else {
					return false;
				}
			}

			if (temp == ']') {
				if (!stack.isEmpty() && stack.pop() == '[') {
					continue;
				} else {
					return false;
				}
			}

			if (temp == ')') {
				if (!stack.isEmpty() && stack.pop() == '(') {
					continue;
				} else {
					return false;
				}
			}
		}
		if (!stack.isEmpty()) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "()";
		System.out.println("isValid -> " + isValid(s));
	}

}
