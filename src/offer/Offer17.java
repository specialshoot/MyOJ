package offer;

/**
 * 合并两个排序的链表
 * 
 * @author han
 *
 */
public class Offer17 {

	/**
	 * 非递归
	 * 
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static ListNode merge(ListNode n1, ListNode n2) {
		ListNode res = new ListNode(0);
		ListNode head = res;
		while (n1 != null && n2 != null) {
			if (n1.val < n2.val) {
				res.next = n1;
				n1 = n1.next;
			} else {
				res.next = n2;
				n2 = n2.next;
			}
			res = res.next;
		}
		if (n1 == null) {
			res.next = n2;
		}

		if (n2 == null) {
			res.next = n1;
		}
		return head.next;
	}

	/**
	 * 递归
	 * 
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static ListNode merge2(ListNode n1, ListNode n2) {
		if (n1 == null) {
			return n2;
		}
		if (n2 == null) {
			return n1;
		}
		ListNode res = null;
		if (n1.val < n2.val) {
			res = n1;
			res.next = merge(n1.next, n2);
		} else {
			res = n2;
			res.next = merge(n1, n2.next);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head1 = new ListNode(1);
		ListNode head2 = new ListNode(5);
		ListNode head3 = new ListNode(6);
		ListNode head4 = new ListNode(2);
		ListNode head5 = new ListNode(3);
		ListNode head6 = new ListNode(4);
		head1.next = head2;
		head2.next = head3;
		head3.next = null;
		head4.next = head5;
		head5.next = head6;
		head6.next = null;
		ListNode res = merge2(head1, head4);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

}
