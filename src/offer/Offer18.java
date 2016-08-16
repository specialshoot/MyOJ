package offer;

/**
 * 树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 递归，判断是否是子树isSubtree
 */
import others.TreeNode;

public class Offer18 {

	public static boolean isSubtree(TreeNode pRootA, TreeNode pRootB) {
		if (pRootB == null)
			return true;
		if (pRootA == null)
			return false;
		if (pRootB.val == pRootA.val) {
			return isSubtree(pRootA.left, pRootB.left) && isSubtree(pRootA.right, pRootB.right);
		} else {
			return false;
		}
	}

	public boolean hasSubtree(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null) {
			return false;
		}
		return isSubtree(root1, root2) || hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
