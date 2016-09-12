package data_structure;

public class RBTreeTest {

	private static final int a[] = { 10, 40, 30, 60, 90, 70, 20, 50, 80 };
	private static final boolean mDebugInsert = true;// 插入动作检测开关
	private static final boolean mDebugDelete = true;// 删除动作检测开关

	public static void main(String[] args) {
		int i, ilen = a.length;
		RBTree<Integer> tree = new RBTree<>();
		System.out.println("== 原始数据:");
		for (i = 0; i < ilen; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();

		for (i = 0; i < ilen; i++) {
			tree.insert(a[i]);
			if (mDebugInsert) {
				System.out.println("== 添加节点 " + a[i]);
				System.out.println("== 树的详细信息：");
				tree.print();
				System.out.println();
			}
		}

		System.out.println("前序遍历：");
		tree.preOrder();
		System.out.println("中序遍历：");
		tree.inOrder();
		System.out.println("后序遍历：");
		tree.postOrder();

		System.out.println("最小值：" + tree.minimum());
		System.out.println("最大值：" + tree.maximum());
		System.out.println("树的详细信息：");
		tree.print();
		System.out.println();

		if (mDebugDelete) {
			for (i = 0; i < ilen; i++) {
				tree.remove(a[i]);
				System.out.println("删除节点：" + a[i]);
				System.out.println("树的详细信息：");
				tree.print();
				System.out.println();
			}
		}

		tree.clear();// 销毁二叉树
	}
}
