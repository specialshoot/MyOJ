package NetEase;

public class Finder {

	public static void quickSort(int[] array) {
		if (array != null) {
			quickSort(array, 0, array.length - 1);
		}
	}

	private static void quickSort(int[] array, int beg, int end) {
		if (beg >= end || array == null)
			return;
		int p = partition(array, beg, end);
		quickSort(array, beg, p - 1);
		quickSort(array, p + 1, end);
	}

	private static int partition(int[] array, int beg, int end) {
		int first = array[beg];
		int i = beg, j = end;
		while (i < j) {
			while (array[i] <= first && i < end) {
				i++;
			}
			while (array[j] > first && j >= beg) {
				j--;
			}
			if (i < j) {
				array[i] = array[i] ^ array[j];
				array[j] = array[i] ^ array[j];
				array[i] = array[i] ^ array[j];
			}
		}
		if (j != beg) {
			array[j] = array[beg] ^ array[j];
			array[beg] = array[beg] ^ array[j];
			array[j] = array[beg] ^ array[j];
		}
		return j;
	}

	public static int findKth(int[] a, int n, int K) {
		// write code
		quickSort(a);
		int len = a.length;
		if (K > len) {
			return 0;
		}
		return a[len - K];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 1, 3, 5, 2, 2 };
		int n = 5;
		int k = 3;
		System.out.println(findKth(a, n, k) + "");
	}
}
