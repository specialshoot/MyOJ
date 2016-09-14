package sort;

/**
 * 归并排序
 * 
 * @author han
 *
 */
public class MergeSort {

	public static int[] mergeSort(int[] a, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(a, low, mid);
			mergeSort(a, mid + 1, high);
			merge(a, low, mid, high);
		}
		return a;
	}

	public static void merge(int[] a, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int left = low;
		int right = mid + 1;
		int k = 0;
		while (left <= mid && right <= high) {
			if (a[left] <= a[right]) {
				temp[k++] = a[left++];
			} else {
				temp[k++] = a[right++];
			}
		}
		while (left <= mid) {
			temp[k++] = a[left++];
		}
		while (right <= high) {
			temp[k++] = a[right++];
		}
		for (int i = 0; i < temp.length; i++) {
			a[low + i] = temp[i];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35,
				25, 53, 51 };
		mergeSort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

}
