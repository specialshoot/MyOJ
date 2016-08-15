package offer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 题目：输入数字n，按顺序打印出从1最大的的n位数十进制数。比如输入3，则打印出1，2，3一直到最大的3位数即999. 陷阱: 输入的n极大(大数问题)
 * 
 * http://blog.csdn.net/jsqfengbao/article/details/47174629
 * 
 * @author han
 *
 */
public class Offer12 {

	public static void outputOneToMaxNDigits(int n) {
		// 用nlist表示数n,nlist[0]表示n的最低位
		ArrayList<Integer> nlist = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			nlist.add(0);
		}
		increment(nlist);
	}

	/**
	 * 使数字每次+1然后输出
	 * 
	 * @param nlist
	 */
	public static void increment(ArrayList<Integer> nlist) {
		int carrybit = 0;
		boolean end = false;
		while (true) {
			int len = nlist.size();
			for (int i = len - 1; i >= 0; i--) {
				int digit = nlist.get(i);
				int sum = digit + carrybit;
				if (i == (len - 1)) {
					++sum;
				}
				if (sum >= 10) {
					if (i == 0) {
						end = true;
					}
					sum = sum - 10;
					carrybit = 1;
				} else {
					carrybit = 0;
				}
				nlist.set(i, sum);
			}
			output(nlist);
			if (end) {
				break;
			}
		}
	}

	public static void output(ArrayList<Integer> nlist) {
		Iterator<Integer> ite = nlist.iterator();
		int num;
		// 找到第一个为0的位置
		boolean first = false;
		while (ite.hasNext()) {
			if (first) {
				System.out.print(ite.next());
				continue;
			}
			if ((num = ite.next()) != 0) {
				first = true;
				System.out.print(num);
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		outputOneToMaxNDigits(2);
	}

}
