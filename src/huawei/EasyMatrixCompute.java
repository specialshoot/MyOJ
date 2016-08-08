package huawei;

import java.util.Scanner;
/**
 * 矩阵乘法
 * @author han
 *
 */
public class EasyMatrixCompute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			int z = scanner.nextInt();
			int[][] m1 = new int[x][y];
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					m1[i][j] = scanner.nextInt();
				}
			}

			int[][] m2 = new int[y][z];
			for (int i = 0; i < y; i++) {
				for (int j = 0; j < z; j++) {
					m2[i][j] = scanner.nextInt();
				}
			}

			for (int i = 0; i < x; i++) {
				for (int j = 0; j < z; j++) {
					int temp = 0;
					for (int k = 0; k < y; k++) {
						temp += m1[i][k] * m2[k][j];
					}
					if (j == z - 1) {
						System.out.print(temp);
					} else {
						System.out.print(temp + " ");
					}
				}
				System.out.println();
			}
		}
		scanner.close();
	}

}
