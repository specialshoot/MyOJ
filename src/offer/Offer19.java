package offer;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像
 * 
 * @author han
 *
 */
public class Offer19 {

	private static void rotate(BinaryTreeNode node) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			return;
		}

		// 交换左右子节点
		BinaryTreeNode temp = node.left;
		node.left = node.right;
		node.right = temp;

		if (node.left != null) {
			rotate(node.left);
		}
		if (node.right != null) {
			rotate(node.right);
		}
	}

	public static void print(BinaryTreeNode head) {
		if (head != null) {
			System.out.println(head.value);
		}
		if (head.left != null) {
			print(head.left);
		}
		if (head.right != null) {
			print(head.right);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode head = new BinaryTreeNode(8);
		BinaryTreeNode left1 = new BinaryTreeNode(6);
		BinaryTreeNode left2 = new BinaryTreeNode(5);
		BinaryTreeNode left3 = new BinaryTreeNode(7);
		BinaryTreeNode right1 = new BinaryTreeNode(10);
		BinaryTreeNode right2 = new BinaryTreeNode(9);
		BinaryTreeNode right3 = new BinaryTreeNode(11);
		head.left = left1;
		left1.left = left2;
		left1.right = left3;
		head.right = right1;
		right1.left = right2;
		right1.right = right3;
		rotate(head);
		print(head);
	}

}
