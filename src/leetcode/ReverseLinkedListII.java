package leetcode;

import java.awt.event.MouseWheelEvent;

public class ReverseLinkedListII {

	public ReverseLinkedListII() {
	}

	// https://leetcode.com/problems/reverse-linked-list-ii/
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {

		ListNode root = new ListNode(0);
		ListNode p = root;
		root.next = head;

		for (int i = 1; i < m && p != null; i++) {
			p = p.next;
		}
		//此时p指向第m个元素的前一个元素
		if (p != null) {
			ListNode q = p.next;
			ListNode r;

			int changeNumber = n - m + 1; // 交换节点的数目
			for (int i = 1; i < changeNumber && q.next != null; i++) {
				// 记下来，链表的反转
				r = q.next;

				q.next = r.next;
				r.next = p.next;
				p.next = r; // p的next永远是遍历到的最后一个
			}

			head = root.next;
		}

		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseLinkedListII rl=new ReverseLinkedListII();
		ListNode l=new ListNode(0);
		ListNode root=new ListNode(0);
		root.next=l;
		for(int i=1;i<6;i++){
			l.next=new ListNode(i);
			l=l.next;
		}
		ListNode res=rl.reverseBetween(root.next, 2, 4);
		if (res!=null) {
			while(res.next!=null){
				System.out.println(res.val);
				res=res.next;
			}
		}
	}

}
