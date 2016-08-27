package NetEase;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 地牢逃脱 给定一个 n 行 m 列的地牢，其中 '.' 表示可以通行的位置，'X' 表示不可通行的障碍，牛牛从 (x0 , y0 )
 * 位置出发，遍历这个地牢，和一般的游戏所不同的是，他每一步只能按照一些指定的步长遍历地牢，要求每一步都不可以超过地牢的边界，也不能到达障碍上。
 * 地牢的出口可能在任意某个可以通行的位置上。牛牛想知道最坏情况下，他需要多少步才可以离开这个地牢。 输入描述: 每个输入包含 1
 * 个测试用例。每个测试用例的第一行包含两个整数 n 和 m（1 <= n, m <= 50），表示地牢的长和宽。接下来的 n 行，每行 m
 * 个字符，描述地牢，地牢将至少包含两个 '.'。接下来的一行，包含两个整数 x0, y0，表示牛牛的出发位置（0 <= x0 < n, 0 <= y0 <
 * m，左上角的坐标为 （0, 0），出发位置一定是 '.'）。之后的一行包含一个整数 k（0 < k <= 50）表示牛牛合法的步长数，接下来的 k
 * 行，每行两个整数 dx, dy 表示每次可选择移动的行和列步长（-50 <= dx, dy <= 50）
 * 
 * 
 * 输出描述: 输出一行一个数字表示最坏情况下需要多少次移动可以离开地牢，如果永远无法离开，输出
 * -1。以下测试用例中，牛牛可以上下左右移动，在所有可通行的位置.上，地牢出口如果被设置在右下角，牛牛想离开需要移动的次数最多，为3次。
 * 
 * 输入例子:
 * 
 * 3 3
 * 
 * ...
 * 
 * ...
 * 
 * ...
 * 
 * 0 1
 * 
 * 4
 * 
 * 1 0
 * 
 * 0 1
 * 
 * -1 0
 * 
 * 0 -1
 * 
 * 输出例子: 3
 * 
 * dfs
 * @author han
 *
 */
public class Dungeon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		while (in.hasNext()) {// 注意while处理多个case
			int x = in.nextInt();
			int y = in.nextInt();

			char[][] points = new char[x][y];
			int[][] tar = new int[x][y];
			for (int i = 0; i < x; i++) {
				String str = in.next();
				points[i] = str.toCharArray();
			}
			int startx = in.nextInt();
			int starty = in.nextInt();
			int k = in.nextInt();
			int[] stepx = new int[k];
			int[] stepy = new int[k];
			for (int i = 0; i < k; i++) {
				stepx[i] = in.nextInt();
				stepy[i] = in.nextInt();
			}
			Queue<Integer> xqueue = new LinkedList<Integer>();
			Queue<Integer> yqueue = new LinkedList<Integer>();
			// 引入队列是为了遍历到最后不能走为止

			xqueue.add(startx);
			yqueue.add(starty);

			tar[startx][starty] = 1; // 起始点访问标记；1表示已经访问
			while (!xqueue.isEmpty() && !yqueue.isEmpty()) {
				startx = xqueue.remove(); // 取队首
				starty = yqueue.remove();
				for (int i = 0; i < k; i++) {
					if (startx + stepx[i] < x && startx + stepx[i] >= 0 && starty + stepy[i] < y
							&& starty + stepy[i] >= 0) // 不出界
						if (tar[startx + stepx[i]][starty + stepy[i]] == 0) {
							if (points[startx + stepx[i]][starty + stepy[i]] == '.') {
								tar[startx + stepx[i]][starty + stepy[i]] = tar[startx][starty] + 1;
								xqueue.add(startx + stepx[i]);
								yqueue.add(starty + stepy[i]);
							} else
								tar[startx + stepx[i]][starty + stepy[i]] = -1; // 访问点为X
						}
				}
			}
			int max = 0;
			int getRoad = 1;
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					if (points[i][j] == '.' && tar[i][j] == 0) {
						getRoad = 0; // 有存在没有被访问的“.”说明不能遍历完全，有些出口到不了。
					}
					max = Math.max(max, tar[i][j]);
				}
			}
			if (getRoad == 0)
				System.out.println(-1);
			else
				System.out.println(max - 1);

		}
		in.close();
	}

}
