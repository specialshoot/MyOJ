package offer;

import java.util.Stack;

/**
 * 二叉树中和为某一值的路径
 * 
 * @author han
 *
 */
public class Offer25 {

	public static void findPath(BinaryTreeNode root, int k) {
		if (root == null) {
			return;
		}
		Stack<Integer> nodes = new Stack<>();
		findPath(root, k, nodes);
	}

	/**
	 * 
	 * @param root
	 *            根
	 * @param k
	 *            要求查找路径k值
	 * @param nodes
	 *            记录过程节点stack
	 */
	public static void findPath(BinaryTreeNode root, int k, Stack<Integer> nodes) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			if (k == root.value) {
				for (int i : nodes) {
					System.out.print(i + " , ");
				}
				System.out.print(root.value);
				System.out.println();
			}
		} else {
			nodes.add(root.value);
			findPath(root.left, k - root.value, nodes);
			findPath(root.right, k - root.value, nodes);
			nodes.pop();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode root1 = new BinaryTreeNode();
		BinaryTreeNode node1 = new BinaryTreeNode();
		BinaryTreeNode node2 = new BinaryTreeNode();
		BinaryTreeNode node3 = new BinaryTreeNode();
		BinaryTreeNode node4 = new BinaryTreeNode();
		BinaryTreeNode node5 = new BinaryTreeNode();
		BinaryTreeNode node6 = new BinaryTreeNode();
		root1.left = node1;
		root1.right = node2;
		node1.left = node3;
		node1.right = node4;
		node4.left = node5;
		node4.right = node6;
		root1.value = 8;
		node1.value = 8;
		node2.value = 7;
		node3.value = 9;
		node4.value = 2;
		node5.value = 4;
		node6.value = 7;
		findPath(root1, 23);
	}

}
