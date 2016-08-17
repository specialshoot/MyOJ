package offer;

/**
 * 重建二叉树，根据二叉树前序和中序遍历结果，重建二叉树并输出它的头结点
 */
import others.TreeNode;

public class Offer6 {

	/**
	 * 
	 * @param pre
	 *            先序遍历
	 * @param in
	 *            中序遍历
	 * @return
	 */
	public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		int mid = 0;
		if (pre.length != in.length || pre.length == 0 || in.length == 0)
			return null;
		TreeNode root = new TreeNode(pre[0]);// 先序遍历第一个元素为根节点
		while (in[mid] != root.val) {// 找到中序遍历的根节点
			mid++;
		}
		int[] preLeft = new int[mid];
		int[] inLeft = new int[mid];
		int[] preRight = new int[pre.length - mid - 1];
		int[] inRight = new int[in.length - mid - 1];
		for (int j = 0; j < in.length; j++) {
			if (j < mid) { // 左子树
				preLeft[j] = pre[j + 1];
				inLeft[j] = in[j];
			} else if (j > mid) {// 右子树
				preRight[j - mid - 1] = pre[j];
				inRight[j - mid - 1] = in[j];
			}
		}
		root.left = reConstructBinaryTree(preLeft, inLeft);
		root.right = reConstructBinaryTree(preRight, inRight);
		return root;
	}

	/**
	 * 为了验证算法是否正确打印前序比对
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

		int[] preOrder = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] inOrder = { 4, 7, 2, 1, 5, 3, 8, 6 };
		TreeNode root = reConstructBinaryTree(preOrder, inOrder);
		printPreOrder(root);// 验证
	}

}
