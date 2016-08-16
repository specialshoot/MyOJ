package offer;

/**
 * 字符串的排列
 * 
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 
 * @author han
 *
 */
public class Offer28 {

	/**
	 * 交换数组元素位置
	 * 
	 * @param arr
	 * @param idx1
	 * @param idx2
	 */
	public static void swap(char[] arr, int idx1, int idx2) {
		char temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

	/**
	 * 全排
	 * 
	 * @param arr
	 * @param index
	 * @param size
	 */
	public static void permutation(char[] arr, int index, int size) {
		if (index == size) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		} else {
			for (int i = index; i < size; i++) {
				if (i != index && arr[i] == arr[index]) {// 相同的情况下不交换
					continue;
				}
				swap(arr, i, index);// 交换i与index的位置
				permutation(arr, index + 1, size);// 全排index+1后的元素
				swap(arr, i, index);// 恢复i与index的位置
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcd";
		char[] chs = str.toCharArray();
		permutation(chs, 0, str.length());
	}

}
