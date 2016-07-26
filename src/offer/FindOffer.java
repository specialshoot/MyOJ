package offer;

public class FindOffer {

	private static boolean hasNum(int[][] array, int target) {// 最简单
		int row = 0;
		int col = array[0].length - 1;
		while (row < array.length  && col >= 0) {
	        if(array==null || array.length==0){
	            return false;
	        }
			if (target == array[row][col])
				return true;
			else if (target > array[row][col])
				row++;
			else
				col--;
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
