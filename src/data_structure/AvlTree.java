package data_structure;

import java.util.Comparator;

public class AvlTree<T extends Comparable<? super T>> {

	private AvlNode<T> root;// 树根
	private Comparator<? super T> cmp;// 比较器

	private static class AvlNode<T> {// avl树节点
		T element;// 节点中的数据
		AvlNode<T> left;// 左儿子
		AvlNode<T> right;// 右儿子
		int height;// 节点的高度

		AvlNode(T element) {
			this(element, null, null);
		}

		AvlNode(T element, AvlNode<T> left, AvlNode<T> right) {
			this.element = element;
			this.left = left;
			this.right = right;
			this.height = 0;
		}
	}

	public AvlTree() {
		root = null;
	}

	public void makeEmpty() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void insert(T element) {
		root = insert(element, root);
	}

	public boolean contains(T element) {
		return contains(element, root);
	}

	public void remove(T element) {
		root = remove(element, root);
	}

	/**
	 * 比较器
	 * 
	 * @param lhs
	 * @param rhs
	 * @return
	 */
	private int myCompare(T lhs, T rhs) {
		if (cmp != null) {
			return cmp.compare(lhs, rhs);
		} else {
			return ((Comparable) lhs).compareTo(rhs);
		}
	}

	/**
	 * 树t中是否包含节点值为x的孩子
	 * 
	 * @param x
	 * @param t
	 * @return
	 */
	private boolean contains(T x, AvlNode<T> t) {
		if (t == null) {
			return false;
		}
		int compareResult = myCompare(x, t.element);
		if (compareResult < 0) {
			return contains(x, t.left);
		}
		if (compareResult > 0) {
			return contains(x, t.right);
		}
		return true;
	}

	/**
	 * 获取高度
	 * 
	 * @param t
	 * @return
	 */
	private int height(AvlNode<T> t) {
		return t == null ? -1 : t.height;
	}

	/**
	 * 寻找最小值(向左子树一直找下去)
	 * 
	 * @param t
	 * @return
	 */
	private AvlNode<T> findMin(AvlNode<T> t) {
		if (t == null) {
			return null;
		}
		if (t.left == null) {
			return t;
		}
		return findMin(t.left);
	}

	/**
	 * 查找最大值(一直向右子树查找)
	 * 
	 * @param t
	 * @return
	 */
	private AvlNode<T> findMax(AvlNode<T> t) {
		if (t == null) {
			return null;
		}
		if (t.right == null) {
			return t;
		}
		return findMax(t.right);
	}

	private AvlNode<T> insert(T element, AvlNode<T> t) {
		if (t == null) {
			// 空树
			return new AvlNode<T>(element, null, null);
		}
		int compareResult = myCompare(element, t.element);
		if (compareResult < 0) {
			t.left = insert(element, t.left);
			if (height(t.left) - height(t.right) == 2) {// 如果左子树高度比右子树高度高2
				if (myCompare(element, t.left.element) < 0) {// LL
					t = rotateWithLeftChild(t);
				} else {// LR
					t = doubleWithLeftChild(t);
				}
			}
		} else if (compareResult > 0) {
			t.right = insert(element, t.right);
			if (height(t.right) - height(t.left) == 2) {
				if (myCompare(element, t.right.element) < 0) {// RL
					t = doubleWithRightChild(t);
				} else {
					t = rotateWithRightChild(t);// RR
				}
			}
		}
		// 更新height值
		t.height = Math.max(height(t.left), height(t.right)) + 1;
		return t;
	}

	private AvlNode<T> remove(T element, AvlNode<T> t) {
		if (t == null) {
			return null;
		}
		int compareResult = myCompare(element, t.element);
		if (compareResult < 0) {
			t.left = remove(element, t.left);
			// 完了之后验证该子树是否平衡
			if (t.right != null) { // 若右子树为空，则一定是平衡的，此时左子树相当对父节点深度最多为1,
									// 所以只考虑右子树非空情况
				if (t.left == null) { // 若左子树删除后为空，则需要判断右子树
					if (height(t.right) - t.height == 2) {
						AvlNode<T> k = t.right;
						if (k.right != null) { // 右子树存在，按正常情况单旋转
							t = rotateWithRightChild(t);
						} else { // 否则是右左情况，双旋转
							t = doubleWithRightChild(t);
						}
					}
				} else { // 否则判断左右子树的高度差
					// 左子树自身也可能不平衡，故先平衡左子树，再考虑整体
					AvlNode<T> k = t.left;
					// 删除操作默认用右子树上最小节点补删除的节点
					// k的左子树高度不低于k的右子树
					if (k.right != null) {
						if (height(k.left) - height(k.right) == 2) {
							AvlNode<T> m = k.left;
							if (m.left != null) { // 左子树存在，按正常情况单旋转
								k = rotateWithLeftChild(k);
							} else { // 否则是左右情况，双旋转
								k = doubleWithLeftChild(k);
							}
						}
					} else {
						if (height(k.left) - k.height == 2) {
							AvlNode<T> m = k.left;
							if (m.left != null) { // 左子树存在，按正常情况单旋转
								k = rotateWithLeftChild(k);
							} else { // 否则是左右情况，双旋转
								k = doubleWithLeftChild(k);
							}
						}
					}
					if (height(t.right) - height(t.left) == 2) {
						// 右子树自身一定是平衡的，左右失衡的话单旋转可以解决问题
						t = rotateWithRightChild(t);
					}
				}
			}
			// 完了之后更新height值
			t.height = Math.max(height(t.left), height(t.right)) + 1;
		} else if (compareResult > 0) {
			t.right = remove(element, t.right);
			// 下面验证子树是否平衡
			if (t.left != null) { // 若左子树为空，则一定是平衡的，此时右子树相当对父节点深度最多为1
				if (t.right == null) { // 若右子树删除后为空，则只需判断左子树
					if (height(t.left) - t.height == 2) {
						AvlNode<T> k = t.left;
						if (k.left != null) {
							t = rotateWithLeftChild(t);
						} else {
							t = doubleWithLeftChild(t);
						}
					}
				} else { // 若右子树删除后非空，则判断左右子树的高度差
					// 右子树自身也可能不平衡，故先平衡右子树，再考虑整体
					AvlNode<T> k = t.right;
					// 删除操作默认用右子树上最小节点（靠左）补删除的节点
					// k的右子树高度不低于k的左子树
					if (k.left != null) {
						if (height(k.right) - height(k.left) == 2) {
							AvlNode<T> m = k.right;
							if (m.right != null) { // 右子树存在，按正常情况单旋转
								k = rotateWithRightChild(k);
							} else { // 否则是右左情况，双旋转
								k = doubleWithRightChild(k);
							}
						}
					} else {
						if (height(k.right) - k.height == 2) {
							AvlNode<T> m = k.right;
							if (m.right != null) { // 右子树存在，按正常情况单旋转
								k = rotateWithRightChild(k);
							} else { // 否则是右左情况，双旋转
								k = doubleWithRightChild(k);
							}
						}
					}
					if (height(t.left) - height(t.right) == 2) {
						// 左子树自身一定是平衡的，左右失衡的话单旋转可以解决问题
						t = rotateWithLeftChild(t);
					}
				}
			}
			// 完了之后更新height值
			t.height = Math.max(height(t.left), height(t.right)) + 1;
		} else if (t.left != null && t.right != null) {
			// 默认用其右子树的最小数据代替该节点的数据并递归的删除那个节点
			t.element = findMin(t.right).element;
			t.right = remove(t.element, t.right);
			if (t.right == null) { // 若右子树删除后为空，则只需判断左子树与根的高度差
				if (height(t.left) - t.height == 2) {
					AvlNode<T> k = t.left;
					if (k.left != null) {
						t = rotateWithLeftChild(t);
					} else {
						t = doubleWithLeftChild(t);
					}
				}
			} else { // 若右子树删除后非空，则判断左右子树的高度差
				// 右子树自身也可能不平衡，故先平衡右子树，再考虑整体
				AvlNode<T> k = t.right;
				// 删除操作默认用右子树上最小节点（靠左）补删除的节点

				if (k.left != null) {
					if (height(k.right) - height(k.left) == 2) {
						AvlNode<T> m = k.right;
						if (m.right != null) { // 右子树存在，按正常情况单旋转
							k = rotateWithRightChild(k);
						} else { // 否则是右左情况，双旋转
							k = doubleWithRightChild(k);
						}
					}
				} else {
					if (height(k.right) - k.height == 2) {
						AvlNode<T> m = k.right;
						if (m.right != null) { // 右子树存在，按正常情况单旋转
							k = rotateWithRightChild(k);
						} else { // 否则是右左情况，双旋转
							k = doubleWithRightChild(k);
						}
					}
				}
				// 左子树自身一定是平衡的，左右失衡的话单旋转可以解决问题
				if (height(t.left) - height(t.right) == 2) {
					t = rotateWithLeftChild(t);
				}
			}
			// 完了之后更新height值
			t.height = Math.max(height(t.left), height(t.right)) + 1;
		} else {
			t = (t.left != null) ? t.left : t.right;
		}
		return t;
	}

	/**
	 * LL 右旋
	 * 
	 * @param k2
	 * @return
	 */
	private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2) {
		AvlNode<T> k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
		k1.height = Math.max(height(k1.left), k2.height) + 1;
		return k1;
	}

	/**
	 * RR 左旋
	 * 
	 * @param k2
	 * @return
	 */
	private AvlNode<T> rotateWithRightChild(AvlNode<T> k2) {
		AvlNode<T> k1 = k2.right;
		k2.right = k1.left;
		k1.left = k2;
		k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
		k1.height = Math.max(height(k1.right), k2.height) + 1;
		return k1;
	}

	/**
	 * LR
	 * 
	 * @param k3
	 * @return
	 */
	private AvlNode<T> doubleWithLeftChild(AvlNode<T> k3) {
		try {
			k3.left = rotateWithRightChild(k3.left);// RR型左旋
		} catch (NullPointerException e) {
			System.out.println("k.left.right为" + k3.left.right);
			throw e;
		}
		return rotateWithLeftChild(k3);// LL型右旋
	}

	/**
	 * RL
	 * 
	 * @param k3
	 * @return
	 */
	private AvlNode<T> doubleWithRightChild(AvlNode<T> k3) {
		try {
			k3.right = rotateWithLeftChild(k3.right);// LL型右旋
		} catch (NullPointerException e) {
			System.out.println("k.right.left为" + k3.right.left);
			throw e;
		}
		return rotateWithRightChild(k3);// 左旋
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AvlTree<Integer> avlTree = new AvlTree<>();
		avlTree.insert(100);
		avlTree.insert(120);
		avlTree.insert(300);
		avlTree.insert(500);
		avlTree.insert(111);
		avlTree.insert(92);
		avlTree.insert(77);
		avlTree.insert(125);
		System.out.println(avlTree.contains(120));
		avlTree.remove(120);
		avlTree.remove(125); // 需要单旋转
		System.out.println(avlTree.contains(120));
		avlTree.insert(78); // 需要双旋转
		System.out.println("Insert Success !");
	}

}
