package others;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreePrinter {

	public int[][] printTree(TreeNode root) {
		// write code here
		List<ArrayList<Integer>> layer = new ArrayList<>();
		TreeNode last = root;
		TreeNode nlast = last;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(last);
		ArrayList<Integer> arr = new ArrayList<>();
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			arr.add(node.val);
			if (node.left != null) {
				nlast = node.left;
				queue.add(node.left);
			}
			if (node.right != null) {
				nlast = node.right;
				queue.add(node.right);
			}
			if (last == node) {// 到一行的结尾,加入到
				last = nlast;
				layer.add(arr);
				arr = new ArrayList<>();
			}
		}
		int[][] num = new int[layer.size()][];
		for (int i = 0; i < layer.size(); i++) {
			num[i] = new int[layer.get(i).size()];
			for (int j = 0; j < layer.get(i).size(); j++) {
				num[i][j] = layer.get(i).get(j);
			}
		}
		return num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
