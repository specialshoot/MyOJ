package huawei;

import java.util.Scanner;

public class MidDelNode {

	public static class ListNode {
		int m_nKey;
		ListNode m_pNext;
	}

	private static ListNode head = null;
	private static ListNode backup = null;

	private static void insert(int back, int front) {
		while (head.m_pNext != null) {
			if (head.m_nKey == front) {
				ListNode temp = head.m_pNext;
				ListNode newNode = new ListNode();
				newNode.m_nKey = back;
				newNode.m_pNext = temp;
				head.m_pNext = newNode;
				return;
			}
			head = head.m_pNext;
		}
		if (head.m_nKey == front) {// 判断最后一个
			ListNode temp = new ListNode();
			temp.m_pNext = null;
			temp.m_nKey = back;
			head.m_pNext = temp;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			head = new ListNode();
			backup = head;
			head.m_nKey = scanner.nextInt();
			for (int i = 1; i < n; i++) {
				head = backup;
				int back = scanner.nextInt();
				int front = scanner.nextInt();
				insert(back, front);
			}
			int del = scanner.nextInt();
			String res="";
			while (backup.m_pNext != null) {
				if (backup.m_nKey != del) {
					res+=backup.m_nKey+" ";
				}
				backup = backup.m_pNext;
			}
			if (backup.m_nKey != del) {
				res+=backup.m_nKey;
			}
			System.out.println(res.trim());
		}
		scanner.close();
	}

}
