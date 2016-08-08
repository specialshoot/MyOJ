package others;

class SegmentTree {

	private class Segment {
		int left;
		int right;
		int count;
		Segment leftChild;
		Segment rightChild;
	}

	private Segment root;

	public SegmentTree(int left, int right) {
		root = new Segment();
		build(root, left, right);
	}

	public void build(Segment root, int left, int right) {
		root.left = left;
		root.right = right;
		if (left != right) {
			int mid = left + (right - left) / 2;
			root.leftChild = new Segment();
			root.rightChild = new Segment();
			build(root.leftChild, left, mid);
			build(root.rightChild, mid + 1, right);
		}
	}

	public void insert(int left, int right) {
		insert(root, left, right);
	}

	public void insert(Segment root, int left, int right) {
		int rootLeft = root.left;
		int rootRight = root.right;
		int rootMid = rootLeft + (rootRight - rootLeft) / 2;
		if (left == rootLeft && right == rootRight) {
			root.count++;// 如果匹配,次数加1
			return;
		}

		if (right <= rootMid) {
			insert(root.leftChild, left, right);
		} else if (left > rootMid) {
			insert(root.rightChild, left, right);
		} else {
			insert(root.leftChild, left, rootMid);
			insert(root.rightChild, rootMid + 1, right);
		}
	}

	public int caculateExistingTimes(int target) {
		return caculateExistingTimes(root, target);
	}

	// 从根节点开始查找叶子结点[target, target]，对经过的节点的count求和
	private int caculateExistingTimes(Segment root, int target) {
		int result = 0;
		while (root.left != root.right) {
			int rootMid = root.left + (root.right - root.left) / 2;
			result += root.count;
			if (target <= rootMid) {
				root = root.leftChild;
			} else if (target > rootMid) {
				root = root.rightChild;
			}
		}
		return result;
	}
}
