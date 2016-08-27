package offer;

import others.TreeNode;

/**
 * 根据中序后序还原树(输出前序)
 * 
 * @author han
 *
 */
public class Offer6_2 {

	public static TreeNode reConstructBinaryTree(int[] in, int[] back) {
		int mid = 0;
		if (back.length != in.length || back.length == 0 || in.length == 0)
			return null;
		TreeNode root = new TreeNode(back[back.length - 1]);// 后序遍历最后一个元素为根节点
		while (in[mid] != root.val) {// 找到中序遍历的根节点
			mid++;
		}
		int[] backLeft = new int[mid];
		int[] inLeft = new int[mid];
		int[] backRight = new int[back.length - mid - 1];
		int[] inRight = new int[in.length - mid - 1];
		for (int j = 0; j < in.length; j++) {
			if (j < mid) { // 左子树
				backLeft[j] = back[j];
				inLeft[j] = in[j];
			} else if (j > mid) {// 右子树
				backRight[j - mid - 1] = back[j - 1];
				inRight[j - mid - 1] = in[j];
			}
		}
		root.left = reConstructBinaryTree(inLeft, backLeft);
		root.right = reConstructBinaryTree(inRight, backRight);
		return root;
	}

	/**
	 * 打印前序
	 * 
	 * @param root
	 */
	public static void printPreOrder(TreeNode root) {
		if (root == null) {
			return;
		} else {
			System.out.print(root.val + " ");
		}

		if (root.left != null) {
			printPreOrder(root.left);
		}

		if (root.right != null) {
			printPreOrder(root.right);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inOrder = { 4, 7, 2, 1, 5, 3, 8, 6 };
		int[] backOrder = { 7, 4, 2, 5, 8, 6, 3, 1 };
		TreeNode root = reConstructBinaryTree(inOrder, backOrder);
		printPreOrder(root);// 验证
	}

}
