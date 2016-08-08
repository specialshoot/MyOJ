package leetcode;

public class NumMatrix {

	int sums[][];

	public NumMatrix(int[][] matrix) {
		if (matrix == null) {
			return;
		}
		int n = matrix.length; // 行数
		System.out.println(n + "");
		if (n == 0) {
			return;
		}
		int m = matrix[0].length;// 列数
		sums = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				sums[i][j] = matrix[i - 1][j - 1] + sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1];
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		row2++;
		col2++;
		return sums[row2][col2] + sums[row1][col1] - sums[row1][col2] - sums[row2][col1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },
				{ 1, 0, 3, 0, 5 } };
		NumMatrix numMatrix = new NumMatrix(matrix);
		System.out.println(numMatrix.sumRegion(2, 1, 4, 3) + "");
	}
}
