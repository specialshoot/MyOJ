package sort;import java.lang.reflect.Array;

public class InsertSort {
	
	/**
	 * 直接插入排序
	 * @param a
	 */
	public static void insertSort(int[] a){
		int len=a.length;
		int j;
		int tmp;
		for(int i=1;i<len;i++){
			tmp=a[i];
			for(j=i-1;j>=0&&a[j]>tmp;j--){
				a[j+1]=a[j];
			}
			a[j+1]=tmp;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35,
				25, 53, 51 };
		insertSort(a);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
	}

}
