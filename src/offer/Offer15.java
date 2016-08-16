package offer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 
 * @author han
 *
 */
public class Offer15 {

	public ListNode FindKthToTail(ListNode head, int k) {
		if (head == null || k <= 0) {
			return null;
		}
		ListNode pre = head, last = head;// 两个指针
		for (int i = 1; i < k; i++) {// 找到顺序第k个元素，注意i初始值为1!!!
			if (pre.next != null) {
				pre = pre.next;
			} else {
				return null;
			}
		}
		while (pre.next != null) {// 保持两个ListNode差k个元素，pre遍历到最后时last就是倒数第k个元素
			pre = pre.next;
			last = last.next;
		}
		return last;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
