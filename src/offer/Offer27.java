package offer;

/**
 * 二叉搜索树与双向链表
 * 
 * 输入一颗二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建新的结点，只能调整树中结点指针的指向。
 * 
 * @author han
 *
 */
public class Offer27 {

	public static BinaryTreeNode convert(BinaryTreeNode root) {
		BinaryTreeNode lastNodeInList = null;
		lastNodeInList = convertNode(root, lastNodeInList);

		BinaryTreeNode headOfList = lastNodeInList;
		while (headOfList != null && headOfList.left != null) {
			headOfList = headOfList.left;
		}
		return headOfList;
	}

	public static BinaryTreeNode convertNode(BinaryTreeNode node, BinaryTreeNode lastNodeInList) {
		if (node == null) {
			return null;
		}
		BinaryTreeNode current = node;
		if (current.left != null) {
			lastNodeInList = convertNode(current.left, lastNodeInList);// 得到最左边的点
		}
		current.left = lastNodeInList;
		if (lastNodeInList != null) {
			lastNodeInList.right = current;
		}
		lastNodeInList = current;
		if (current.right != null) {// 遍历搜索右子树
			lastNodeInList = convertNode(current.right, lastNodeInList);
		}
		return lastNodeInList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
