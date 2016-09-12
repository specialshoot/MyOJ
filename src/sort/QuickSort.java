package sort;

public class QuickSort {

	static void quicksort(int[] a, int left, int right) {
		int dp;
		if (left < right) {
			dp = partition(a, left, right);
			quicksort(a, left, dp - 1);
			quicksort(a, dp + 1, right);
		}
	}

	static int partition(int[] a, int left, int right) {
		int pivot = a[left];
		while (left < right) {
			while (left < right && a[right] >= pivot)
				right--;
			if (left < right)
				a[left++] = a[right];
			while (left < right && a[left] <= pivot)
				left++;
			if (left < right)
				a[right--] = a[left];
		}
		a[left] = pivot;
		return left;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35,
//				25, 53, 51 };
		int[] a={3,4,2,1};
		quicksort(a,0,a.length-1);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

}
