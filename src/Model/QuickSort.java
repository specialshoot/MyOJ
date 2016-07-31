package Model;

public class QuickSort {

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array={2,4,1,5,7,2};
		quickSort(array);
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}

}
