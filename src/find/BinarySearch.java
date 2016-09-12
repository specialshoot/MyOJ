package find;

/**
 * 折半查找（二分查找）
 * 
 * @author han
 *
 */
public class BinarySearch {

	/**
	 * 非递归
	 * 
	 * @param array
	 *            有序数组
	 * @param searchKey
	 * @return
	 */
	private static int binarySearch(int[] array, int searchKey) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (searchKey < array[mid]) {
				high = mid - 1;
			} else if (searchKey > array[mid]) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	/**
	 * 递归
	 * 
	 * @param dataset
	 *            数据集
	 * @param data
	 * @param beginIndex
	 * @param endIndex
	 * @return
	 */
	public static int binarySearch(int[] array, int searchKey, int low, int high) {
		int mid = (low + high) / 2;
		if (searchKey < array[low] || searchKey > array[high] || low > high) {
			return -1;
		}
		if (searchKey < array[mid]) {
			return binarySearch(array, searchKey, low, mid - 1);
		} else if (searchKey > array[mid]) {
			return binarySearch(array, searchKey, mid + 1, high);
		} else {
			return mid;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] src = new int[] { 1, 3, 5, 7, 8, 9 };
		System.out.println(binarySearch(src, 3));
		System.out.println(binarySearch(src, 3, 0, src.length - 1));
	}

}
