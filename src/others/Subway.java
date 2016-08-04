package others;

import java.util.Scanner;
import java.io.*;

public class Subway {
	double max = Double.MAX_VALUE;
	int fin[] = new int[205];
	double d[] = new double[205];
	double dis[][] = new double[205][205];
	pos p[] = new pos[205];

	void initial() {
		for (int i = 0; i < 205; i++)
			p[i] = new pos();
		Scanner s;
		int n = 2;
		try {
			s = new Scanner(System.in);
			p[0].x = s.nextInt();
			p[0].y = s.nextInt();
			p[1].x = s.nextInt();
			p[1].y = s.nextInt();

			int flag = 0;
			while (s.hasNext()) {
				p[n].x = s.nextInt();
				p[n].y = s.nextInt();
				if (p[n].x == -1 && p[n].y == -1) {
					flag = 0;
					continue;
				}
				if (flag == 1) {
					dis[n][n - 1] = dis[n - 1][n] = Math.sqrt((p[n].x - p[n - 1].x) * (p[n].x - p[n - 1].x)
							+ (p[n].y - p[n - 1].y) * (p[n].y - p[n - 1].y)) / 40000;
				}
				n++;
				flag = 1;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (i != j && dis[i][j] == 0)
					dis[i][j] = dis[j][i] = (Math
							.sqrt((p[j].x - p[i].x) * (p[j].x - p[i].x) + (p[j].y - p[i].y) * (p[j].y - p[i].y)))
							/ 10000.0;

		fin[0] = 1;
		for (int i = 0; i < n; i++){
			d[i] = dis[0][i];
		}
		int v = 0;
		for (int i = 1; i < n; i++) {
			double min = max;
			for (int j = 0; j < n; j++){
				if (fin[j] != 1){ //如果还没有走过此路
					if (d[j] < min) {
						v = j;
						min = d[j];
					}
				}
			}
			fin[v] = 1;//v为局部最短路
			for (int w = 0; w < n; w++){
				if (fin[w] != 1 && (min + dis[v][w] < d[w])){
					d[w] = min + dis[v][w];
				}
			}
		}
		double ans = 60.0 * d[1];
		System.out.println(Math.round(ans));
	}

	public static void main(String[] args) {
		Subway di = new Subway();
		di.initial();
	}
}

class pos {
	int x = 0;
	int y = 0;
}
