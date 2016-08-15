package offer;

/**
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下的数序排列。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 * 例如下面的二维数组就是每行、每列都递增排序。
 * 如果在这个数组中查找数字7，则返回true，如果要查找5，由于数组不含有该数字，则返回false
 *
 * 1 2 8 9
 * 
 * 2 4 9 12
 * 
 * 4 7 10 13
 * 
 * 6 8 11 15
 * 
 * @author han
 *
 */
public class Offer3 {

	private static boolean hasNum(int[][] array, int target) {// 最简单
		int row = 0;
		int col = array[0].length - 1;
		while (row < array.length && col >= 0) {
			if (array == null || array.length == 0) {
				return false;
			}
			if (target == array[row][col])
				return true;
			else if (target > array[row][col])
				++row;
			else
				--col;
		}
		return false;
	}

	private static boolean hasNum2(int[][] array, int target) {// 二分
		for (int i = 0; i < array.length; i++) {
			int low = 0;
			int high = array[i].length - 1;
			while (low <= high) {
				int mid = (low + high) / 2;
				if (target > array[i][mid])
					low = mid + 1;
				else if (target < array[i][mid])
					high = mid - 1;
				else
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arrays[][] = { { 1, 4, 7, 9 }, { 2, 7, 8, 11 }, { 4, 8, 12, 19 } };
		if (hasNum2(arrays, 12))
			System.out.println("数据含有这样的整数");
		else
			System.out.println("没有这样的整数");
	}

}
