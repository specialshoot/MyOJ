package others;

import java.util.Scanner;

/**
 * 挑选镇长 360员工桂最近申请了一个长假，一个人背着包出去自助游了。
 * 路上，他经过了一个小镇，发现小镇的人们都围在一棵树下争吵。桂上前询问情况，得知小镇的人们正缺一个镇长，他们希望能选一个知名又公正的镇长，即，
 * 大家希望能选出一个人，所有人都认识他，但同时他不认识镇上除自己以外的其他人（在此，我们默认每个人自己认识自己）。可是小镇里的人太多了，
 * 一下子大家谁也说服不了谁。 “这简单啊。”桂表示。于是他一下子统计出来了镇上人们相互之间的认识关系，并且一下子找到了合适的镇长人选。
 * 现在你手上也拿到了这样一份认识关系的清单。其中上面给出的认识关系是单向的，即，A认识B与B认识A是相互独立的，只给出A认识B就不能认为B认识A，例如，
 * 我认识你，你不一定认识我。而且，这里的认识关系也不具有传递性，即，A认识B，B认识C，但这不代表A认识C。同时，为了方便处理，这份清单中，
 * 镇上的N个人依次编号为1到N。你能否像桂一样快速找到合适的镇长人选呢？ 输入描述: 首先一个正整数T（T≤20），表示数据组数。
 * 之后每组数据的第一行有2个整数n 和m (1≤n≤105 ,0≤m≤3×105 )，依次表示镇上的人数和相互之间的认识关系数。 之后m行，第 i
 * 行每行两个数Ai和Bi (1≤Ai ,Bi ≤n )，表示Ai认识Bi。（保证没有重复的认识关系，但可能存在自己认识自己的认识关系）
 * 保证所有数据中80%的数据满足n≤1000,m≤10000
 * 
 * 
 * 输出描述: 一共2T 行，每组数据对应2行。 第一行，一个整数，表示你所找出来的合适的镇长人选人数num i 。 第二行，num i
 * 个整数，每两个数中间用空格隔开，表示你所选的合适的镇长的编号。 特别的，如果并没有找到合适的镇长，第一行输出一个数0，第二行留空即可（参见样例）。
 * 
 * http://www.nowcoder.com/question/next?pid=151724&qid=25196&tid=4536552
 * 
 * 题解：某点入度为n-1，出度为0即为所求点
 * 
 * @author han
 *
 */
public class QiHu360ChooseBoss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int T = scanner.nextInt();// 数据组数
			for (int i = 0; i < T; i++) {
				int n = scanner.nextInt();// 镇上的人数
				int m = scanner.nextInt();// 认识关系数
				int[] rudu = new int[n + 1];
				int[] chudu = new int[n + 1];
				for (int j = 0; j < m; j++) {
					int who = scanner.nextInt();
					int known = scanner.nextInt();
					if (who == known) {
						continue;
					}
					chudu[who] += 1;
					rudu[known] += 1;
				}
				boolean has = false;
				for (int j = 1; j <= n; j++) {
					if (rudu[j] == n - 1 && chudu[j] == 0) {
						System.out.println("1");
						System.out.println(j);
						has = true;
						break;
					}
				}
				if (!has) {
					System.out.println("0");
					System.out.println();
				}
			}
		}
		scanner.close();
	}

}
