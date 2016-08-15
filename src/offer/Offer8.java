package offer;

/**
 * 旋转数组的最小数字 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为旋转。 输入一个递增的排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组｛3，4，5，1，2｝为{1,2,3,4,5}的一个旋转，该数组的最小元素为1.
 * 
 * http://blog.csdn.net/jsqfengbao/article/details/47108069
 * 
 * @author han
 *
 */
public class Offer8 {

	public static int minInReversingList(int[] arr) {
		if (arr == null) {
			return -1;
		}
		int len = arr.length;
		int left = 0;
		int right = len - 1;
		int mid = 0;
		int min = arr[left];
		while (arr[left] >= arr[right]) {
			if (right - left == 1) {
				// 两个位置指针相邻,说明找到了
				min = arr[right];
				break;
			}
			mid = (left + right) / 2;
			if (arr[mid] == arr[left] && arr[mid] == arr[right]) {// 中位数与左右两边的数字相等,只能遍历了
				return minInorder(arr, left, right);
			}
			if (arr[left] <= arr[mid]) {// 若中间位置的数位于数组1，让p1走到mid的位置
				left = mid;
			} else if (arr[right] >= arr[mid]) {// 若中间位置的数位于数组2，让p2走到mid的位置
				right = mid;
			}
		}
		return min;
	}

	/**
	 * 从数组array中遍历查找最小的数字
	 * 
	 * @param array
	 * @param p1
	 * @param p2
	 * @return
	 */
	private static int minInorder(int[] array, int left, int right) {
		int min = array[left];
		for (int i = left + 1; i <= right; i++) {
			if (min > array[i]) {
				min = array[i];
			}
		}
		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 5, 6, 0, 1 };
		System.out.println(minInReversingList(arr));
	}

}
