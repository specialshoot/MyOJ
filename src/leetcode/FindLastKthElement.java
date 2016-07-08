package leetcode;

import java.awt.List;

public class FindLastKthElement {

	public static class Node {
		public int value;
		public Node node;

		Node(int value, Node node) {
			this.value = value;
			this.node = node;
		}
	}

	private static Node findLastKthElement(Node head, int k) {
		if (head == null || head.node == null) {
			return null;
		}
		Node cur = head;
		Node knode = head;// 倒数第k个元素
		Node nextnode = null;
		int count = 0;
		while (cur != null && cur.node != null) {
			count += 1;
			if (count >= k) {// 如果计数已经超过了k,则用一个新的Node记录即可
				nextnode = knode.node;
				knode = nextnode;
			}
			nextnode = cur.node;// 如果当前计数没有大于k,节点向后移动
			cur = nextnode;
		}
		if (count < k - 1) {// 如果计数值<k-1说明超出范围
			return null;
		}
		return knode;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1 2 6 3 10 30
		Node node = new Node(1, new Node(2, new Node(6, new Node(3, new Node(10, new Node(30, null))))));
		Node result = findLastKthElement(node, 1);
		System.out.println(result == null ? "找不到" : result.value);
	}
}
