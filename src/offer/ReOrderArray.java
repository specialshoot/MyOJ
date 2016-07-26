package offer;

import java.util.ArrayList;

/**
 * 调整数组顺序使奇数位于偶数前面 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分， 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 
 * @author han
 *
 */
public class ReOrderArray {

	public static void reOrderArray(int[] array) {
		if (array == null || array.length == 0) {
			return;
		}
		int length = array.length;
		ArrayList<Integer> odd = new ArrayList<>();
		ArrayList<Integer> oven = new ArrayList<>();
		int i = 0;
		for (i = 0; i < length; i++) {
			if (array[i] % 2 == 0) {
				oven.add(array[i]);
			} else {
				odd.add(array[i]);
			}
		}
		for (i = 0; i < odd.size(); i++) {
			array[i] = odd.get(i);
		}
		for (int j = 0; j < oven.size(); j++) {
			array[i + j] = oven.get(j);
		}
	}

	/**
	 * 插入
	 * @param array
	 */
	public static void reOrderArray2(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int tmp = array[i];
			if (tmp % 2 == 1) {//奇数
				for (int j = i; j > 0; j--) {//向前查找偶数
					if (array[j - 1] % 2 == 0) {//偶数
						int t = array[j];
						array[j] = array[j - 1];
						array[j - 1] = t;
					}
				}
			}
		}
		
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1,2, 3, 9,11,4, 5, 6, 7, 8 };
		reOrderArray2(array);
	}

}
