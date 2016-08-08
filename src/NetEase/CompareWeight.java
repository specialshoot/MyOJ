package NetEase;

/**
 * 小明陪小红去看钻石，他们从一堆钻石中随机抽取两颗并比较她们的重量。这些钻石的重量各不相同。在他们们比较了一段时间后，它们看中了两颗钻石g1和g2。
 * 现在请你根据之前比较的信息判断这两颗钻石的哪颗更重。
 * 给定两颗钻石的编号g1,g2，编号从1开始，同时给定关系数组vector,其中元素为一些二元组，第一个元素为一次比较中较重的钻石的编号，
 * 第二个元素为较轻的钻石的编号。最后给定之前的比较次数n。请返回这两颗钻石的关系，若g1更重返回1，g2更重返回-1，无法判断返回0。输入数据保证合法，
 * 不会有矛盾情况出现。 试样例： 2,3,[[1,2],[2,4],[1,3],[4,3]],4 返回: 1
 * 
 * @author han
 *
 */
public class CompareWeight {

	public int cmp(int g1, int g2, int[][] records, int n) {
		// write code here
		int max = records[0][0];

		for (int i = 0; i < n; i++) {// 找出钻石最大编号为总数量
			max = max > records[i][0] ? max : records[i][0];
			max = max > records[i][1] ? max : records[i][1];
		}

		int[][] arr = new int[max + 1][max + 1];
		for (int i = 0; i < n; i++) {
			arr[records[i][0]][records[i][1]] = 1;
		}
		for (int k = 1; k <= max; k++) {
			for (int i = 1; i <= max; i++) {
				for (int j = 1; j <= max; j++) {
					if (arr[i][k] > 0 && arr[k][j] > 0) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}

		if (arr[g1][g2] > 0)
			return 1;
		else if (arr[g2][g1] > 0)
			return -1;
		else
			return 0;
	}

	public int cmp2(int g1, int g2, int[][] records, int n) {
		// write code here
		int i, j, x;
		for (i = 0; i < n; ++i) {
			if (records[i][0] == g1 && records[i][1] == g2)
				return 1;
			if (records[i][0] == g2 && records[i][1] == g1)
				return -1;
			if (records[i][0] == g1) {
				x = records[i][1];
				for (j = 0; j < n; ++j)
					if (records[j][0] == x && records[j][1] == g2)
						return 1;
			}
			if (records[i][0] == g2) {
				x = records[i][1];
				for (j = 0; j < n; ++j)
					if (records[j][0] == x && records[j][1] == g1)
						return -1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
