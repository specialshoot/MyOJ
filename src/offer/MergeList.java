package offer;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 
 * @author han
 *
 */
public class MergeList {

	public static ListNode Merge(ListNode list1, ListNode list2) {
		if (list1 == null && list2 == null) {
			return null;
		}
		ListNode result = new ListNode(0);
		ListNode head = result;
		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				head.next = new ListNode(list1.val);
				list1 = list1.next;
			} else {
				head.next = new ListNode(list2.val);
				list2 = list2.next;
			}
			head = head.next;
		}
		if (list1 == null) {
			head.next = list2;
		}
		if (list2 == null) {
			head.next = list1;
		}
		return result.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
