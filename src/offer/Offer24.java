package offer;

/**
 * 二叉搜索树的后序遍历序列
 * 
 * 后序遍历特点:
 * 最后一个元素为根节点
 * 前面的元素前部分是小于根节点的
 * 后面部分是大于根节点的
 * 所以遍历,与最后一个元素比较
 * 遍历到大于根节点的元素说明从此元素开始后面的元素(除最后一个元素为根元素)都应该比跟元素大,否则返回false
 * @author han
 *
 */
public class Offer24 {

	public static boolean verifySequence(int[] array, int start, int end) {
		if (array == null || array.length < 2) {
			return true;
		}
		int root = array[end];
		int i = start;
		for (; i < end; i++) {
			if (array[i] > root) {
				break;
			}
		}
		int j = i;
		for (; j < end; j++) {
			if (array[j] < root) {
				return false;
			}
		}
		boolean left = true, right = true;
		if (i > start) {
			left = verifySequence(array, 0, i - 1);
		}
		if (i < end) {
			left = verifySequence(array, i, end - 1);
		}
		return left && right;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arr={5,7,6,9,11,10,8};
        System.out.println(verifySequence(arr,0,arr.length-1));
	}

}
