package NetEase;

/**
 * 扫描透镜
 * 在N*M的草地上,提莫种了K个蘑菇,蘑菇爆炸的威力极大,兰博不想贸然去闯,而且蘑菇是隐形的.只 有一种叫做扫描透镜的物品可以扫描出隐形的蘑菇,于是他回了一趟战争学院,买了2个扫描透镜,一个 扫描透镜可以扫描出(3*3)方格中所有的蘑菇,然后兰博就可以清理掉一些隐形的蘑菇. 问:兰博最多可以清理多少个蘑菇?
 * 
 * 注意：每个方格被扫描一次只能清除掉一个蘑菇。 
 * 输入描述:
 * 第一行三个整数:N,M,K,(1≤N,M≤20,K≤100),N,M代表了草地的大小;
 * 接下来K行,每行两个整数x,y(1≤x≤N,1≤y≤M).代表(x,y)处提莫种了一个蘑菇.
 * 一个方格可以种无穷个蘑菇.
 * 
 * 输出描述:
 * 输出一行,在这一行输出一个整数,代表兰博最多可以清理多少个蘑菇.
 */
import java.util.Scanner;

public class ScanLens {
	public static int LENGTH = 2;

	/**
	 * 
	 * @param N
	 * @param M
	 * @param num
	 * @param startX
	 * @param startY
	 * @return
	 */
	public static Point getNumInLocation(int N, int M, int[][] num, int startX, int startY) {
		int endX, endY;
		// 1.确定区域
		if (startX + LENGTH > N - 1) {
			endX = N - 1;
		} else {
			endX = startX + LENGTH;
		}

		if (startY + LENGTH > M - 1) {
			endY = M - 1;
		} else {
			endY = startY + LENGTH;
		}
		// 2.统计个数
		Point point = new Point();
		point.count = 0;
		point.x = startX;
		point.y = startY;
		point.endX = endX;
		point.endY = endY;
		for (int i = startX; i <= endX; i++) {
			for (int j = startY; j <= endY; j++) {
				if (num[i][j] > 0) {
					point.count++;
				}
			}
		}
		return point;
	}

	/**
	 * 统计能扫描到的最大值
	 * 
	 * @param N
	 * @param M
	 * @param num
	 * @return
	 */
	private static Point findMaxNum(int N, int M, int[][] num) {
		Point point = new Point();
		point.count = 0;
		point.x = 0;
		point.y = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Point tempPoint = getNumInLocation(N, M, num, i, j);
				if (point.count < tempPoint.count) {
					point = tempPoint;
				}
			}
		}
		return point;
	}

	/**
	 * 第一次扫描完 进行清除操作
	 * 
	 * @param point
	 * @param num
	 * @param N
	 * @param M
	 */
	private static void clear(Point point, int[][] num, int N, int M) {
		for (int i = point.x; i <= point.endX; i++) {
			for (int j = point.y; j <= point.endY; j++) {
				if (num[i][j] > 0 && i < N & j < M) {
					num[i][j]--;
				}
			}
		}
	}

	static class Point {
		int x;// 起始坐标
		int y;// 起始坐标
		int count;// 区域内总数
		int endX;// 结束坐标
		int endY;// 结束坐标
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 0, M = 0, K;

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {

			// 1.输入数据
			N = scanner.nextInt();
			M = scanner.nextInt();
			K = scanner.nextInt();
			int[][] num = new int[N][M];// 蘑菇分布
			while (K > 0) {
				int x = scanner.nextInt() - 1;
				int y = scanner.nextInt() - 1;
				if (x < N && y < M) {
					num[x][y]++;
					K--;
				}
			}
			// 2.统计个数
			Point firstPoint = findMaxNum(N, M, num);
			clear(firstPoint, num, N, M);
			Point secondPoint = findMaxNum(N, M, num);
			System.out.println(firstPoint.count + secondPoint.count);
		}
		scanner.close();
	}

}
