package leetcode;

import leetcode.MergeKSortedLists.ListNode;

public class MergeTwoSortedLists {

	// https://leetcode.com/problems/merge-two-sorted-lists/
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode head = null, iCur = null;
		if (l1.val < l2.val) {
			iCur = l1;
			l1 = l1.next;
		} else {
			iCur = l2;
			l2 = l2.next;
		}
		head = iCur;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				iCur.next = l1;
				l1 = l1.next;
			} else {
				iCur.next = l2;
				l2 = l2.next;
			}
			iCur = iCur.next;
		}
		if (l1 == null)
			iCur.next = l2;
		if (l2 == null)
			iCur.next = l1;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(3);
		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(4);
		ListNode[] lists = { l1, l2 };
		ListNode node = mergeTwoLists(l1, l2);
		if (node != null) {
			while (node.next != null && node != null) {
				System.out.println(node.val + "");
				node = node.next;
			}
			System.out.println(node.val + "");
		} else {
			System.out.println("hehe");
		}
	}

}
