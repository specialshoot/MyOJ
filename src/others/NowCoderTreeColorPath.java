package others;

/**
 * 树上最长单色路径
 * 对于一棵由黑白点组成的二叉树，我们需要找到其中最长的单色简单路径，其中简单路径的定义是从树上的某点开始沿树边走不重复的点到树上的另一点结束而形成的路径，
 * 而路径的长度就是经过的点的数量(包括起点和终点)。而这里我们所说的单色路径自然就是只经过一种颜色的点的路径。你需要找到这棵树上最长的单色路径。
 * 给定一棵二叉树的根节点(树的点数小于等于300，请做到O(n)的复杂度)，请返回最长单色路径的长度。这里的节点颜色由点上的权值表示，权值为1的是黑点，
 * 为0的是白点。
 * 
 * @author han
 *
 */
public class NowCoderTreeColorPath {

	public static int max = 0;

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public static int getPath(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int leftLen = 0, rightLen = 0;
		if (root.left != null) {
			int ret = getPath(root.left);
			if (root.left.val == root.val) {
				leftLen = ret;
			}
		}
		if (root.right != null) {
			int ret = getPath(root.right);
			if (root.right.val == root.val) {
				rightLen = ret;
			}
		}
		max = Math.max(max, (leftLen + rightLen + 1));// 全局同色最长路径
		return Math.max(leftLen, rightLen) + 1;// 局部同色最长路径
	}

	public static int findPath(TreeNode root) {
		// write code here
		if (root == null) {
			return 0;
		}
		getPath(root);
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
