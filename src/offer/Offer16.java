package offer;

/**
 * 反转链表并输出 画图自己看
 * 
 * @author han
 *
 */
public class Offer16 {

	public static ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode next = null;
		while (head != null) {
			next = head.next;// 保存下一个节点
			head.next = pre;// 当前节点指向前一个节点
			pre = head;// 前任节点到现任节点
			head = next;// 现任节点到下一节点
		}
		return pre;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
