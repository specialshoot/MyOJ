package youDao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * [编程题] 洗牌 洗牌在生活中十分常见，现在需要写一个程序模拟洗牌的过程。
 * 现在需要洗2n张牌，从上到下依次是第1张，第2张，第3张一直到第2n张。首先，我们把这2n张牌分成两堆，左手拿着第1张到第n张（上半堆），右手拿着第n+
 * 1张到第2n张（下半堆）。接着就开始洗牌的过程，先放下右手的最后一张牌，再放下左手的最后一张牌，接着放下右手的倒数第二张牌，再放下左手的倒数第二张牌，
 * 直到最后放下左手的第一张牌。接着把牌合并起来就可以了。
 * 例如有6张牌，最开始牌的序列是1,2,3,4,5,6。首先分成两组，左手拿着1,2,3；右手拿着4,5,6。在洗牌过程中按顺序放下了6,3,5,2,4,1
 * 。把这六张牌再次合成一组牌之后，我们按照从上往下的顺序看这组牌，就变成了序列1,4,2,5,3,6。
 * 现在给出一个原始牌组，请输出这副牌洗牌k次之后从上往下的序列。 输入描述: 第一行一个数T(T ≤
 * 100)，表示数据组数。对于每组数据，第一行两个数n,k(1 ≤ n,k ≤ 100)，接下来一行有2n个数a1,a2,...,a2n(1 ≤ ai ≤
 * 1000000000)。表示原始牌组从上到下的序列。
 * 
 * 
 * 输出描述: 对于每组数据，输出一行，最终的序列。数字之间用空格隔开，不要在行末输出多余的空格。
 * 
 * 输入例子:
 * 
 * 3
 * 
 * 3 1
 * 
 * 1 2 3 4 5 6
 * 
 * 3 2
 * 
 * 1 2 3 4 5 6
 * 
 * 2 2
 * 
 * 1 1 1 1
 * 
 * 输出例子:
 * 
 * 1 4 2 5 3 6
 * 
 * 1 5 4 3 2 6
 * 
 * 1 1 1 1
 * 
 * @author han
 *
 */
public class ShuffleCards {

	public static int[] getLast(int[] group1, int[] group2, int n, int k) {
		if (k == 0) {
			int[] both = new int[2 * n];
			System.arraycopy(group1, 0, both, 0, group1.length);
			System.arraycopy(group2, 0, both, group1.length, group2.length);
			return both;
		}
		int[] newgroup = new int[2 * n];
		for (int i = 0; i < n; i++) {
			newgroup[2 * i] = group1[i];
			newgroup[2 * i + 1] = group2[i];
		}
		return getLast(Arrays.copyOfRange(newgroup, 0, n), Arrays.copyOfRange(newgroup, n, 2 * n), n, k - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int m = scanner.nextInt();
			for (int i = 0; i < m; i++) {
				int n = scanner.nextInt();
				int k = scanner.nextInt();
				int[] group1 = new int[n];
				int[] group2 = new int[n];
				for (int j = 0; j < n; j++) {
					group1[j] = scanner.nextInt();
				}
				for (int j = 0; j < n; j++) {
					group2[j] = scanner.nextInt();
				}
				int[] res = getLast(group1, group2, n, k);
				for (int j = 0; j < 2 * n; j++) {
					System.out.print(res[j]);
					if (j != 2 * n - 1) {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}
		scanner.close();
	}

}
