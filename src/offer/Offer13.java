package offer;

/**
 * 在O(1)时间删除链表节点
 * 
 * http://blog.csdn.net/jsqfengbao/article/details/47175249
 * 
 * @author han
 *
 */
public class Offer13 {

	public static void deleteNode(ListNode head, ListNode deListNode) {
		if (head == null || deListNode == null) {
			return;
		}
		if (head == deListNode) {
			head = null;
		} else {
			if (deListNode.next == null) {// 结尾
				ListNode printListNode = head;
				while (printListNode.next.next != null) {
					printListNode = printListNode.next;
				}
				printListNode.next = null;
			} else {
				deListNode.val = deListNode.next.val;
				deListNode.next = deListNode.next.next;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head1 = new ListNode(1);
		ListNode head2 = new ListNode(2);
		ListNode head3 = new ListNode(3);
		ListNode head4 = new ListNode(4);
		ListNode head5 = new ListNode(5);
		head1.next = head2;
		head2.next = head3;
		head3.next = head4;
		head4.next = head5;
		deleteNode(head1, head5);
		while (head1 != null) {
			System.out.println(head1.val);
			head1 = head1.next;
		}
	}

}
