package find;

/**
 * 顺序查找
 * 
 * @author han
 *
 */
public class OrderSearch {

	private static int orderSearch(int[] array, int searchKey) {
		int length = array.length;
		for (int i = 0; i < length; i++) {
			if (array[i] == searchKey) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = new int[] { 1, 2, 29, 3, 95, 3, 5, 6, 7, 9, 12 };// 升序序列
		int index = orderSearch(test, 95);
		System.out.println("查找到的位置 :" + index);
	}

}
