package leetcode;

import java.util.LinkedList;

public class LongestValidParentheses {
	// https://leetcode.com/problems/longest-valid-parentheses/

	public static int longestValidParentheses(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		LinkedList<Integer> stack = new LinkedList<Integer>();
		int start = 0;
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
				System.out.println("push -> " + i);
			} else {
				if (stack.isEmpty()) {
					// 如果栈为空,说明前面已经没有匹配,start重新赋值起始位置
					start = i + 1;
				} else {
					stack.pop();
					max = stack.isEmpty() ? Math.max(max, i - start + 1) : Math.max(max, i - stack.peek());
					if (!stack.isEmpty())
						System.out.println("i-stack.peek() -> " + (i - stack.peek()));
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestValidParentheses("()(()") + "");
	}

}
