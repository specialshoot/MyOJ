package huawei;

import java.util.Scanner;

public class FindKthToTail {

	public static class ListNode {
		int m_nKey;
		ListNode m_pNext;
	}

	private static int findKthToTail(ListNode head, int k) {
		int count = 0;
		ListNode temp = head;
		while (head.m_pNext != null && count < k) {
			count++;
			head = head.m_pNext;
		}
		if (count < k) {
			return -1;
		}
		while (head.m_pNext != null) {
			head = head.m_pNext;
			temp = temp.m_pNext;
		}
		return temp.m_nKey;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		ListNode listNode = new ListNode();
		ListNode head = listNode;
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			listNode.m_nKey = scanner.nextInt();
			for (int i = 1; i < n; i++) {
				ListNode temp = new ListNode();
				temp.m_nKey = scanner.nextInt();
				listNode.m_pNext = temp;
				listNode = listNode.m_pNext;
			}
			listNode.m_pNext = null;
			int k = scanner.nextInt();
			System.out.println(findKthToTail(head, k) + "");
		}
		scanner.close();
	}

}
