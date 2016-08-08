package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

	// https://leetcode.com/problems/merge-k-sorted-lists/
	// 此题的c++版本见han文件夹下interview

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	// 最简单的方法，遍历，超时
	public static ListNode mergeKLists1(ListNode[] lists) {

		if (lists == null || lists.length == 0) {
			return null;
		}
		ListNode head = lists[0];
		for (int i = 1; i < lists.length; i++) {
			head = mergeTwoLists(head, lists[i]);
		}
		return head;
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
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

	// bfs(accept)
	public static ListNode mergeKLists2(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}

		if (lists.length == 1) {
			return lists[0];
		}

		int length = lists.length;
		int mid = (length - 1) / 2;

		ListNode[] l1 = Arrays.copyOfRange(lists, 0, mid + 1);
		ListNode[] l2 = Arrays.copyOfRange(lists, mid + 1, length);
		ListNode listnode1 = mergeKLists2(l1);
		ListNode listnode2 = mergeKLists2(l2);

		return mergeTwoLists(listnode1, listnode2);
	}

	// 优先级队列(accept)
	/**
	 * 优先级队列，当数字插入优先级队列中时，优先级会按照规定的排序方式对元素进行排序
	 * 
	 * @param lists
	 * @return
	 */
	public static ListNode mergeKLists3(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;

		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if (o1.val < o2.val)
					return -1;
				else if (o1.val == o2.val)
					return 0;
				else
					return 1;
			}
		});

		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;

		for (ListNode node : lists) {
			// 先将list中的node按照头节点插入优先级队列(优先级队列对头节点进行排序)
			if (node != null)
				queue.add(node);
		}

		while (!queue.isEmpty()) {
			// 然后遍历每个节点并插入优先级队列tail中,这样将所有数据进行了排列
			tail.next = queue.poll();
			tail = tail.next;

			if (tail.next != null)
				queue.add(tail.next);
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(3);
		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(4);
		ListNode[] lists = { l1, l2 };
		ListNode node = mergeKLists3(lists);
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
