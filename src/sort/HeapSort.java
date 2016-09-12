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

	/**
	 * 打印数组
	 * 
	 * @param array
	 */
	public static void printArray(int[] array) {
		System.out.print("{");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i < array.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("}");
	}
}
