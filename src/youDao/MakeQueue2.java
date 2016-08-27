package youDao;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * MakeQueue不超时
 * @author han
 *
 */
public class MakeQueue2 {
	public static LinkedList<Integer> q;
	public static int[] QQ = new int[10000];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int a = 0;
		a = in.nextInt();
		int num = 0;
		for (int i = 0; i < a; i++) {
			num = in.nextInt();
			get_arr(num);
			for (int j = 0; j < num; j++) {
				System.out.print(QQ[j]);
				if (j != num - 1) {
					System.out.print(" ");
				} else {
					System.out.print("\n");
				}
			}
		}
	}

	public static void get_arr(int x) {
		q = new LinkedList<Integer>();
		for (int i = 0; i < x; i++) {
			q.addLast(i + 1);
		}
		int sequence = 1;
		while (!q.isEmpty()) {
			int xx = q.getFirst();
			q.removeFirst();
			q.addLast(xx);
			xx = q.getFirst();
			QQ[xx - 1] = sequence;
			q.removeFirst();
			sequence++;
		}
	}

}