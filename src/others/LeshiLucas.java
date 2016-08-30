package others;

/**
 * 卢卡斯的驱逐者大军已经来到了赫柏的卡诺萨城，赫柏终于下定决心,集结了大军,与驱逐者全面开战。
 * 卢卡斯的手下有6名天之驱逐者，这6名天之驱逐者各赋异能，是卢卡斯的主力。
 * 为了击败卢卡斯，赫柏必须好好考虑如何安排自己的狂战士前去迎战。
 * 狂战士的魔法与一些天之驱逐者的魔法属性是相克的，第i名狂战士的魔法可以克制的天之驱逐者的集合为Si(Si中的每个元素属于[0,5])。
 * 为了公平，两名狂战士不能攻击同一个天之驱逐者。
 * 现在赫柏需要知道共有多少种分派方案。
 * 例：
 * S1={01},S2={23}，代表编号为0的狂战士的魔法可以克制编号为0和编号为1的天之驱逐者，编号为1的狂战士的魔法可以克制编号为2和编号为3的天之驱逐者，共有四种方案：02,03,12,13。
 * 02---代表第一个狂战士负责编号为0的驱逐者，第二个狂战士负责编号为2的驱逐者;
 * 03---代表第一个狂战士负责编号为0的驱逐者，第二个狂战士负责编号为3的驱逐者;
 * 12---代表第一个狂战士负责编号为1的驱逐者，第二个狂战士负责编号为2的驱逐者;
 * 13---代表第一个狂战士负责编号为1的驱逐者，第二个狂战士负责编号为3的驱逐者;
 * S1={01},S2={01}，代表编号为0的狂战士的魔法可以克制编号为0和编号为1的天之驱逐者，编号为1的狂战士的魔法可以克制编号为0和编号为1的天之驱逐者，共有两种方案：01,10。
 * 
 * 就是一棵树，求叶子节点个数
 */
import java.io.BufferedInputStream;
import java.util.Scanner;

public class LeshiLucas {

	static Scanner scanner;
	static int[][] visit;
	static int ans = 0;

	public static int getAns(String[] str, int n) {
		ans = 0;
		int[] vis = { 0, 0, 0, 0, 0, 0 };
		dfs(str, vis, n, 0);
		return ans;
	}

	/**
	 * 
	 * @param str
	 *            字符串数组
	 * @param vis
	 *            访问数组
	 * @param n
	 *            字符串总数
	 * @param p
	 *            正在搜索第几个字符串
	 */
	public static void dfs(String[] str, int[] vis, int n, int p) {
		if (p == n) {
			ans++;
			return;
		}
		for (int i = 0; i < str[p].length(); i++) {
			if (vis[str[p].charAt(i) - '0'] == 0) {
				vis[str[p].charAt(i) - '0'] = 1;
				dfs(str, vis, n, p + 1);// 搜索的第p+1个字符串
				vis[str[p].charAt(i) - '0'] = 0;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scanner = new Scanner(new BufferedInputStream(System.in));
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			String[] strings = new String[n];
			for (int i = 0; i < n; i++) {
				strings[i] = scanner.next();
			}
			int res = getAns(strings, n);
			System.out.println(res + "");
		}
		scanner.close();
	}

}
