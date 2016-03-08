package leetcode;

import leetcode.SwapNodesInPairs.ListNode;

public class ReverseNodesInKGroup {

	// https://leetcode.com/problems/reverse-nodes-in-k-group/
	// 只遍历一次list

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	// Accept
	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode cur = head; // 将head提出
		int cnt = 0;
		// get next group
		while (cur != null && cnt != k) {
			cur = cur.next;
			cnt++;
		}
		if (cnt == k) { // 等于k个
			cur = reverseKGroup(cur, k); // 嵌套,继续向后遍历
			// 翻转
			while (0 <= --cnt) {
				ListNode tmp = head.next;
				head.next = cur;
				cur = head;
				head = tmp;
			}
			head = cur;
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(1);
		a.next = new ListNode(2);
		a.next.next = new ListNode(3);
		a.next.next.next = new ListNode(4);
		a.next.next.next.next = new ListNode(5);
		ListNode b = new ReverseNodesInKGroup().reverseKGroup(a, 2);
		while (b != null) {
			System.out.println(b.val);
			b = b.next;
		}
	}
}
