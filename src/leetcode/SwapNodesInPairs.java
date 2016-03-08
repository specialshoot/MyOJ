package leetcode;

public class SwapNodesInPairs {

	// https://leetcode.com/problems/swap-nodes-in-pairs/
	// 移动节点,首先判断是否ListNode为空或只有一个元素,如果是,则直接返回ListNode
	// 如果满足基本的交换条件,首先交换头两个元素节点,先改变next元素,再交换节点
	// 然后每次节点向后移动两个并记录前一个节点,然后进行while循环上面一步的操作
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	// Accept
	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode p = head.next, q, st;

		// 首先交换前两个元素
		// 交换next的节点
		head.next = p.next;
		p.next = head;
		// 交换元素
		head = p;
		q = head.next;

		while (q.next != null && q.next.next != null) { // 一次移两步，保证奇数链表最后一个元素不移动
														// 注意判断next
			st = q; // 保留前一个元素节点
			// 一次移动两步
			p = p.next.next;
			q = q.next.next;
			// 交换next节点
			p.next = q.next;
			q.next = p;
			// 交换元素
			st.next = q;
			q = p;
			p = st.next;
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

		ListNode b = new SwapNodesInPairs().swapPairs(a);
		while (b != null) {
			System.out.println(b.val);
			b = b.next;
		}
	}

}
