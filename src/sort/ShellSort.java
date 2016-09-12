package sort;

public class ShellSort {

	public static void shellSort(int[] a) {
		int len = a.length;
		int tmp = 0;
		int j = 0;
		for (int increment = len / 2; increment > 0; increment /= 2) {
			for (int i = increment; i < len; i++) {
				// 这里相当于插入排序
				tmp = a[i];
				for (j = i; j >= increment; j -= increment) {
					if (tmp < a[j - increment]) {// 如想从大到小排序,修改这里即可
						a[j] = a[j - increment];
					} else {
						break;
					}
				}
				a[j] = tmp;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35,
				25, 53, 51 };
		shellSort(a);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
	}

}
