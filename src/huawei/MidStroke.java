package huawei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 笔画 1.第一行输入的是边的数目 2.后面是每条边的两个顶点 3.顶点的数目是输入的边中最大的顶点编号 4.欧拉路径、连通图判断、奇点判断
 * 5.不要输出连线的路径，只输出true或false
 * 
 * 欧拉定理：如果一个网络是连通的并且奇顶点的个数等于0或2，那么它可以一笔画出；否则它不可以一笔画出
 * 
 * @author han
 *
 */
public class MidStroke {

	public static class Point {
		public int x;
		public int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static boolean[][] hasLine;// 连接矩阵
	private static boolean[] con;// 某点是否有连接
	private static int[] cnt;// 每个点的连接个数

	/**
	 * 深搜每个节点记录每个点连接的个数及是否有连接
	 * 
	 * @param cur
	 *            深搜的节点
	 * @param n
	 *            节点总数
	 */
	private static void dfs(int cur, int n) {
		con[cur] = true;
		for (int i = 1; i <= n; i++) {
			if (hasLine[cur][i] == true) {// 如果某两点是连接的
				cnt[cur]++;
				if (!con[i]) {// 如果连接的另一个点还没有检测到有连接，则深搜节点i
					dfs(i, n);
				}
			}
		}
	}

	/**
	 * 判断图是否全连通(连通图)
	 * 
	 * @param n
	 * @return
	 */
	private static boolean connect(int n) {
		for (int i = 1; i <= n; i++) {
			if (!con[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int max = 0;
			ArrayList<Point> points = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				int p1 = scanner.nextInt();
				int p2 = scanner.nextInt();
				points.add(new Point(p1, p2));
				max = Math.max(max, Math.max(p1, p2));
			}
			hasLine = new boolean[max + 1][max + 1];
			con = new boolean[max + 1];
			cnt = new int[max + 1];
			for (int i = 0; i < n; i++) {
				int p1 = points.get(i).x;
				int p2 = points.get(i).y;
				hasLine[p1][p2] = true;
				hasLine[p2][p1] = true;
			}
			dfs(1, max);
			if (!connect(max)) {// 有未连接的点说明不是连通图
				System.out.println("false");
				continue;
			}
			int odd = 0;// 统计奇点
			for (int i = 1; i <= max; i++) {
				if (cnt[i] % 2 != 0) {// 奇点
					odd++;
				}
			}
			if (odd == 0 || odd == 2) {
				System.out.println("true");
			} else {
				System.out.println("false");
			}
		}
		scanner.close();
	}

}
