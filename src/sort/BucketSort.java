package sort;

import java.util.ArrayList;

public class BucketSort {

	/**
	 * 桶排序
	 * 
	 * @param data
	 *            数据
	 * @param max
	 *            最大值
	 */
	public static ArrayList<Integer> radixSort(int[] data, int max) {
		int[] buckets = new int[max + 1];// 桶的个数
		int len = data.length;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < len; i++) {
			buckets[data[i]]++;
		}
		for (int i = 0; i <= max; i++) {
			while (buckets[i] > 0) {
				list.add(i);
				buckets[i]--;
			}
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35,
				25, 53, 51 };
		ArrayList<Integer> list = radixSort(a, 99);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
