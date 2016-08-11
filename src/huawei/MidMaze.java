package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 迷宫问题
 * 
 * @author han
 *
 */
public class MidMaze {

	private static int[][] maze;
	private static int width = 0;
	private static int height = 0;
	private static int[][] go = { { 0, 1 }, { 1, 0 } };
	private static boolean[][] vis;
	private static boolean find = false;

	private static boolean check(int x, int y) {
		if (x >= width || y >= height || maze[x][y] == 1 || vis[x][y] == true) {// 超过边境或者有障碍或已经访问过
			return false;
		}
		return true;
	}

	private static void bfs(int x, int y, List<String> res) {
		if (find) {// 找到
			return;
		}
		if (!check(x, y)) {// 此点不能走
			return;
		}
		if (x == width - 1 && y == height - 1) {
			// 到达终点
			find = true;
			vis[x][y] = true;
			res.add("(" + x + "," + y + ")");
			return;
		}
		vis[x][y] = true;
		res.add("(" + x + "," + y + ")");
		for (int i = 0; i < 2; i++) {
			bfs(x + go[i][0], y + go[i][1], res);
			if (find) {
				return;
			}
		}
		// 如果没有找到
		vis[x][y] = false;
		res.remove(res.size() - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int m = scanner.nextInt();
			int n = scanner.nextInt();
			maze = new int[m][n];
			vis = new boolean[m][n];
			find = false;
			width = m;
			height = n;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					maze[i][j] = scanner.nextInt();
				}
			}
			ArrayList<String> res = new ArrayList<>();
			bfs(0, 0, res);
			for (int i = 0; i < res.size(); i++) {
				System.out.println(res.get(i));
			}
		}
		scanner.close();
	}

}
