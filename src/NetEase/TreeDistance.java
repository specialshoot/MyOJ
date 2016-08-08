package NetEase;

/**
 * 有一棵二叉树，树上每个点标有权值，权值各不相同，请设计一个算法算出权值最大的叶节点到权值最小的叶节点的距离。
 * 二叉树每条边的距离为1，一个节点经过多少条边到达另一个节点为这两个节点之间的距离。 给定二叉树的根节点root，请返回所求距离。
 * 
 * @author han
 *
 */
public class TreeDistance {

	private int max = 0;
	private int min = 99999;
	private StringBuilder maxcodec;
	private StringBuilder mincodec;

	// 典型的二进制编码题，算出叶子节点二进制编码，再比编码，计算后缀长度和
	void PreOrder(TreeNode T, char code, StringBuilder codec) {
		if (T != null) {
			codec.append(code);
			if (T.left == null && T.right == null) {
				if (max < T.val) {
					max = T.val;
					maxcodec = codec;
				}

				if (min > T.val) {
					min = T.val;
					mincodec = codec;
				}
			}
			PreOrder(T.left, '0', new StringBuilder(codec));
			PreOrder(T.right, '1', new StringBuilder(codec));
		}
	}

	public int getDis(TreeNode root) {
		// write code here
		PreOrder(root, '0', new StringBuilder());
		int index = 0;
		for (index = 0; index < (maxcodec.length() > mincodec.length() ? maxcodec.length()
				: mincodec.length()); index++) {
			if (maxcodec.charAt(index) != mincodec.charAt(index)) {// 直到有不想等的字符，说明到了最大权值点到最小权值点的分叉口
				break;
			}
		}
		return (maxcodec.substring(index).length() + mincodec.substring(index).length());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
