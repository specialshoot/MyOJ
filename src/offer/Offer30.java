package offer;

import java.util.Arrays;

public class Offer30 {

	/**
	 * 一轮快排
	 * 
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	public static int patition(int[] arr, int left, int right) {
		if (left > right) {
			return -1;
		}
		int temp = arr[left];
		while (left < right) {
			while (left < right && arr[right] >= temp) {
				right--;
			}
			arr[left] = arr[right];
			while (left < right && arr[left] < temp) {
				left++;
			}
			arr[right] = arr[left];
		}
		arr[left] = temp;
		return left;
	}

	/**
	 * 执行快排(O(n))
	 * 
	 * @param arr
	 * @param k
	 * @return
	 */
	public static int[] getLeastNumbers(int[] arr, int k) {
		if (arr.length == 0 || k <= 0) {
			return null;
		}
		int output[] = new int[k];
		int start = 0;
		int end = arr.length - 1;
		int index = patition(arr, start, end);
		patition(arr, 0, index - 1);
		patition(arr, index + 1, end);
		for (int i = 0; i < k; i++) {
			output[i] = arr[i];
		}
		return output;
	}

	/*************************** 华丽的分割线 ******************************/

	/**
	 * O(nlogk)效率 堆排序 http://blog.csdn.net/jsqfengbao/article/details/47361471
	 * 
	 * @param arr
	 * @param k
	 * @return
	 */
	public static void getLeastNumbers2(int[] arr, int k) {
		if (arr == null || k < 0 || k > arr.length)
			return;
		// 根据输入数组前k个数简历最大堆
		// 从k+1个数开始与根节点比较
		// 大于根节点，舍去
		// 小于，取代根节点，重建最大堆
		int[] kArray = Arrays.copyOfRange(arr, 0, k);
		heapSort(kArray);
		for (int i = k; i < arr.length; i++) {
			if (arr[i] < kArray[k - 1]) {
				kArray[k - 1] = arr[i];
				heapSort(kArray);
			}
		}
		for (int i : kArray) {
			System.out.print(i);
		}
	}

	/**
	 * 新建大顶堆
	 * 
	 * @param arr
	 * @param lastIndex
	 */
	public static void buildMaxHeap(int[] arr, int lastIndex) {
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			int k = i;
			while (2 * k + 1 <= lastIndex) {
				int biggerIndex = 2 * k + 1;
				if (biggerIndex < lastIndex) {
					if (arr[biggerIndex] < arr[biggerIndex + 1]) {
						biggerIndex++;
					}
				}
				if (arr[k] < arr[biggerIndex]) {
					swap(arr, k, biggerIndex);
					k = biggerIndex;
				} else {
					break;
				}
			}
		}
	}

	public static void heapSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			buildMaxHeap(arr, arr.length - i - 1);
			swap(arr, 0, arr.length - i - 1);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 4, 5, 1, 6, 2, 7, 3, 8 };
		// arr = getLeastNumbers(arr, 4);
		// for (int i = 0; i < arr.length; i++) {
		// System.out.println(arr[i]);
		// }
		getLeastNumbers2(arr, 4);
	}

}
