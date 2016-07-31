package huawei;

import java.util.Scanner;

/**
 * iNOC产品部-杨辉三角的变形
 * 
 * @author han
 *
 */
public class EasyFirstOwen {

	public static int run(int n) {
		int[][] triangle = new int[n][2 * n + 1];
		triangle[0][n] = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < 2 * n; j++) {
				triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j] + triangle[i - 1][j + 1];
			}
		}

		for (int j = 1; j < 2 * n; j++) {
			if (triangle[n - 1][j] % 2 == 0 && triangle[n - 1][j] != 0) {
				return j;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			System.out.println(run(n));
		}
	}

}
