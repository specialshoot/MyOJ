package leetcode;

public class RemoveNthNodeFromEndOfList {

	// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
	// 要求只遍历一次
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (n == 0) {
			return head;
		}
		ListNode p1 = head;
		ListNode p2 = head;
		ListNode removeNode = head;
		int i = 0;
		while (p1 != null) {
			p1 = p1.next;
			i++;
			if (i > n) {
				p2 = removeNode;
				removeNode = removeNode.next;
			}
		}

		if (removeNode == head) {
			head = head.next;
		} else {
			p2.next = removeNode.next;
		}
		return head;
	}

	public static ListNode removeNthFromEnd2(ListNode head, int n) {
		if (n == 0 || head == null) {
			return head;
		}
		if (n == 1 && head.next == null) {
			return null;
		}

		ListNode p = head, q = head;
		// 让p先行q n个位置
		for (int i = 0; i < n; i++) {
			if (p != null) {
				p = p.next;
			} else {
				// n的个数大于head元素个数
				return head;
			}
		}

		// 如果这个时候p已经是null，则说明删除的必定为head
		if (p == null) {
			head = head.next;
			return head;
		}

		// p和q一起前进
		while (p.next != null) {
			q = q.next;
			p = p.next;
		}
		// 删除元素
		q.next = q.next.next;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode test = new ListNode(1);

		ListNode listNode = removeNthFromEnd(test, 0);
		if (listNode != null) {
			while (listNode.next != null) {
				System.out.println(listNode.val);
				listNode = listNode.next;
			}
			System.out.println(listNode.val);
		} else {
			System.out.println("null");
		}
	}

}
