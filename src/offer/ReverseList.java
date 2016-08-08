package offer;

/**
 * 反转链表并输出 画图自己看
 * 
 * @author han
 *
 */
public class ReverseList {

	public static ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode pre = null, next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}

	public static ListNode reverseList2(ListNode head) {
		ListNode pre = null;
		ListNode next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
