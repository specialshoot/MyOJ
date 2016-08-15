package offer;

import java.util.Stack;

/**
 * 两个栈实现队列
 * 
 * @author han
 *
 */
public class Offer7_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		test.push(1);
		test.push(2);
		System.out.println(test.pop());
	}

	public static class Solution {
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();

		public void push(int node) {
			stack1.push(node);
		}

		public int pop() {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			int result = stack2.pop();
			while (!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}
			return result;
		}
	}

}
