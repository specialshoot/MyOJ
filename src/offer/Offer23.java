package offer;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

import others.TreeNode;

/**
 * 从上往下打印二叉树
 * 
 * 如果要按照树形结构打印,需要构造一个每行最后一个节点的记录.见others的TreePrinter
 * 
 * @author han
 *
 */
public class Offer23 {

	public static void printFromTopToBottom(TreeNode root) {
		if (root == null) {
			return;
		}
		Queue<TreeNode> queue = new LinkedBlockingDeque<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.print(node.val + ",");
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t1 = new TreeNode(8);
		TreeNode t2 = new TreeNode(6);
		TreeNode t3 = new TreeNode(10);
		TreeNode t4 = new TreeNode(5);
		TreeNode t5 = new TreeNode(7);
		TreeNode t6 = new TreeNode(9);
		TreeNode t7 = new TreeNode(11);
		TreeNode t8 = new TreeNode(12);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		t7.right=t8;
		printFromTopToBottom(t1);
	}

}
