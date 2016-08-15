package offer;

import java.util.Stack;

/**
 * 题目：输入一个链表的头结点，从尾到头反过来打印出每个节点的值。
 * 
 * 栈先进后出
 * 
 * @author han
 *
 */
public class Offer5 {

	/**
	 * 采用栈的方式
	 * 
	 * @param node
	 */
	private static void printTailToStartStack(ListNode node) {
		if (node == null) {
			return;
		}
		Stack<ListNode> stack = new Stack<>();
		while (node != null) {
			stack.push(node);
			node = node.next;
		}
		while (!stack.isEmpty()) {
			System.out.println(stack.pop().val);
		}
	}

	/**
	 * 采用递归调用的方法
	 * 
	 * @param start
	 */
	private static void printTailToStartRec(ListNode start) {
		if (start != null) {
			if (start.next != null) {
				printTailToStartRec(start.next);
			}
			System.out.println(start.val);
		} else {
			System.out.println("list is null!");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode start = new ListNode(1);
		ListNode two = new ListNode(2);
		start.next = two;

		// Node two = new Node(2);
		// start.nextNode = two;
		printTailToStartRec(start);
		printTailToStartStack(start);
	}

}
