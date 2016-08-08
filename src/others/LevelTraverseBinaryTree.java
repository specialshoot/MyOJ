package others;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 分层遍历二叉树 http://bylijinnan.iteye.com/blog/1629457
 * 
 * LinkedList双向列表
 */
public class LevelTraverseBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] src = { 1, 2, 3, 4, 5, 0, 6, 0, 0, 7, 8 };
		LevelTraverseBinaryTree tree = new LevelTraverseBinaryTree();
		Node root = tree.createTree(src);
		tree.traverseByLevelFromTop(root);
		System.out.println();
		tree.traverseByLevelFromBottom(root);
	}

	/**
	 * 自顶向下输出
	 * 用inCount记录某层有多少个元素，outCount记录当前输出了多少个元素；当inCount==outCount时，就说明某层元素已经完全输出
	 * ，此时应该换行(outCount清零)
	 * 
	 * @param node
	 */
	public void traverseByLevelFromTop(Node node) {
		if (node == null) {
			return;
		}
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(node);
		int inCount = 1;
		int outCount = 0;
		while (!queue.isEmpty()) {
			Node curNode = queue.pollFirst();// 检索并移除此列表的第一个元素，或者如果此列表为空，则返回null
			System.out.print(curNode.getData() + " ");
			outCount++;
			if (curNode.getLeft() != null) {
				queue.addLast(curNode.getLeft());
			}
			if (curNode.getRight() != null) {
				queue.addLast(curNode.getRight());
			}
			if (outCount == inCount) {
				System.out.println();
				inCount = queue.size();
				outCount = 0;
			}
		}
	}

	/**
	 * 从下向上输出 从下向上输出可以用Arraylist,开始从上向下遍历,遍历完一行可以加一个node(-1)节点表示此行到了结尾
	 * 注意最后Arraylist要从后向前输出,所以正向遍历时要先getRight再getLeft
	 * 
	 * @param node
	 */
	public void traverseByLevelFromBottom(Node node) {
		if (node == null) {
			return;
		}
		List<Node> nodeList = new ArrayList<>();
		nodeList.add(node);
		nodeList.add(new Node(-1));
		int i = 0;
		int size = nodeList.size();
		while (i < size) {
			Node curNode = nodeList.get(i);
			if (curNode.getRight() != null) {
				nodeList.add(curNode.getRight());
			}
			if (curNode.getLeft() != null) {
				nodeList.add(curNode.getLeft());
			}
			i++;
			if (i == size) {// 一行最后一个元素,到了结尾
				if (curNode.getData() != -1 && curNode.getLeft() == null && curNode.getRight() == null) {
					// System.out.println("hehe -> "+curNode.getData()+" ; size
					// -> "+size);
					break;// 均没有子节点
				}
				// System.out.println("hehe -> "+curNode.getData()+" ; size ->
				// "+size);
				// for(int tmp=0;tmp<nodeList.size();tmp++){
				// System.out.println(nodeList.get(tmp).getData());
				// }
				size = nodeList.size();
				nodeList.add(new Node(-1));// 增加-1节点,到最后一个元素后,由于size=nodeList.size()没有变化,所以直接i==size,跳出循环
			}
		}
		// 从后往前遍历，相当于“栈”
		for (size = nodeList.size(), i = size - 1; i >= 0; i--) {
			int val = nodeList.get(i).getData();
			if (val == -1) {
				System.out.println();
			} else {
				System.out.print(val + " ");
			}
		}
	}

	/**
	 * 根据树形结构建立Node
	 * 
	 * @param data
	 * @return
	 */
	public Node createTree(int[] data) {
		List<Node> nodeList = new ArrayList();
		for (int each : data) {
			Node n = new Node(each);
			nodeList.add(n);
		}
		int lastRootIndex = data.length / 2 - 1;
		for (int i = 0; i <= lastRootIndex; i++) {
			Node root = nodeList.get(i);
			Node left = nodeList.get(i * 2 + 1);
			if (left.getData() != 0) {
				root.setLeft(left);
			} else {
				root.setLeft(null);
			}
			if (i * 2 + 2 < data.length) {
				Node right = nodeList.get(i * 2 + 2);
				if (right.getData() != 0) {
					root.setRight(right);
				} else {
					root.setRight(null);
				}
			}
		}
		Node root = nodeList.get(0);
		return root;
	}
}
