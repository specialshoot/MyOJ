package sort;

/**
 * 冒泡
 * @author han
 *
 */
public class BubbleSorter {

	public static void bubbleSort(int[] a) {
		int temp = 0;
		int len=a.length-1;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - i; j++) {
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35,
				25, 53, 51 };
		bubbleSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

}
