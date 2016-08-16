package offer;

/**
 * 顺时针打印矩阵
 * http://blog.csdn.net/jsqfengbao/article/details/47210487
 * @author han
 *
 */
public class Offer20 {
	public void printMatrixInCircle(int[][] array) {
		if (array == null)
			return;
		int start = 0;
		while (array[0].length > start * 2 && array.length > start * 2) {
			printOneCircle(array, start);
			start++;
		}
	}

	/**
	 * 打印一个循环
	 * @param array
	 * @param start
	 */
	private void printOneCircle(int[][] array, int start) {
		int columns = array[0].length;//行
		int rows = array.length;//列
		int endX = columns - 1 - start;
		int endY = rows - 1 - start;
		// 从左到右打印一行
		for (int i = start; i <= endX; i++) {
			int number = array[start][i];
			System.out.print(number + ",");
		}
		// 从上到下打印一列
		if (start < endY) {
			for (int i = start + 1; i <= endY; i++) {
				int number = array[i][endX];
				System.out.print(number + ",");
			}
		}
		// 从右到左打印一行
		if (start < endX && start < endY) {
			for (int i = endX - 1; i >= start; i--) {
				int number = array[endY][i];
				System.out.print(number + ",");
			}
		}
		// 从下到上打印一列
		if (start < endY && start < endY - 1) {
			for (int i = endY - 1; i >= start + 1; i--) {
				int number = array[i][start];
				System.out.print(number + ",");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
