package offer;

import java.util.ArrayList;

/**
 * 从后向前打印树节点
 * 
 * @author han
 *
 */
public class PrintArray {

	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ListNode head = listNode;
		ArrayList<Integer> result = new ArrayList<>();
		if (listNode == null) {
			return result;
		}
		result.add(head.val);
		while (head.next != null) {
			head = head.next;
			result.add(head.val);
		}
		int length = result.size();
		int mid = result.size() / 2;
		for (int i = 0; i < mid; i++) {
			int temp = result.get(i);
			result.set(i, result.get(length - i - 1));
			result.set(length - i - 1, temp);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
