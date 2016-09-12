package sort;

public class SelectSort {

	/**
	 * 选择排序
	 * 
	 * @param a
	 */
	public static void selectSort(int[] a) {
		int len = a.length;
		int tmp = 0;
		for (int i = 0; i < len; i++) {
			int k = i;
			// 找出最小值
			for (int j = len - 1; j > i; j--) {
				if (a[j] < a[k]) {
					k = j;
				}
			}
			tmp = a[i];
			a[i] = a[k];
			a[k] = tmp;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35,
				25, 53, 51 };
		selectSort(a);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
	}

}
