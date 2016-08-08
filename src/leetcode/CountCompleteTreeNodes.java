package leetcode;

public class CountCompleteTreeNodes {

	// https://leetcode.com/problems/count-complete-tree-nodes/
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * 最简单的循环遍历，超时
	 * 
	 * @param root
	 * @return
	 */
	public int countNodes1(TreeNode root) {

		if (root == null) {
			return 0;
		}
		return 1 + countNodes1(root.left) + countNodes1(root.right);
	}

	/**
	 * 可以先判断左右子树是否高度一致
	 * 
	 * @param root
	 * @return
	 */
	public int countNodes2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int l = getLeft(root) + 1;
		int r = getRight(root) + 1;
		if (l == r) {
			return (2 << (l - 1)) - 1;
		} else {
			return countNodes2(root.left) + countNodes2(root.right) + 1;
		}
	}

	public int getLeft(TreeNode node) {
		int count = 0;
		while (node.left != null) {
			node = node.left;
			++count;
		}
		return count;
	}

	public int getRight(TreeNode node) {
		int count = 0;
		while (node.right != null) {
			node = node.right;
			++count;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
