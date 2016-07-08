package others;

public class Permutation {

	// 错排公式
	// http://baike.baidu.com/view/668994.htm
	/**
	 * 第一步，把第n个元素放在一个位置，比如位置k，一共有n-1种方法；
	 * 第二步，放编号为k的元素，这时有两种情况：⑴把它放到位置n，那么，对于剩下的n-1个元素，由于第k个元素放到了位置n，剩下n-2个元素就有D(n-
	 * 2)种方法；⑵第k个元素不把它放到位置n，这时，对于这n-1个元素，有D(n-1)种方法； 综上得到 D(n) = (n-1) [D(n-2) +
	 * D(n-1)] 特殊地，D(1) = 0, D(2) = 1.
	 */
	private static int permutation(int n) {
		if (n == 1) {
			return 0;
		}
		if (n == 2) {
			return 1;
		}
		return (n - 1) * (permutation(n - 2) + permutation(n - 1));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(permutation(5));
	}

}
