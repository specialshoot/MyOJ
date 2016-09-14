package sort;

/**
 * 堆排序
 * 
 * 1.构建最大堆.
 * 
 * 2.选择顶,并与第0位置元素交换.
 * 
 * 3.由于步骤2的交换可能破坏了最大堆的性质,第0不再是最大元素,需要调用
 * 
 * @author han
 *
 */
public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3 };
		heapSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	public static void heapSort(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}

		buildMaxHeap(array);// 建立最大堆

		for (int i = array.length - 1; i >= 1; i--) {
			exchangeElements(array, 0, i);
			maxHeap(array, i, 0);
		}
	}

	/**
	 * 建立最大堆
	 * 
	 * @param array
	 */
	private static void buildMaxHeap(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}

		int half = array.length / 2;
		for (int i = half; i >= 0; i--) {
			maxHeap(array, array.length, i);
		}
	}

	/**
	 * 调整堆,沉降法
	 * 
	 * @param array
	 * @param heapSize
	 * @param index
	 */
	private static void maxHeap(int[] array, int heapSize, int index) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;

		// 选择最大的数的标号
		int largest = index;
		if (left < heapSize && array[left] > array[index]) {
			largest = left;
		}

		if (right < heapSize && array[right] > array[largest]) {
			largest = right;
		}

		if (index != largest) {
			// 交换元素,重新构建大堆顶
			exchangeElements(array, index, largest);
			maxHeap(array, heapSize, largest);
		}
	}

	/**
	 * 交换数组某两个元素
	 * 
	 * @param array
	 * @param index1
	 * @param index2
	 */
	public static void exchangeElements(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}
