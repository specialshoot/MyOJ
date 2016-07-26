package others;

/**
 * 据说是2012年10月人人网校招的一道笔试题-给出一个重物重量为X,另外提供的小砝码重量分别为1，3，9。。。3^N。
 * 将重物放到天平左侧，问在两边如何添加砝码
 * 
 * http://bylijinnan.iteye.com/blog/1707047
 * 
 * @author han
 *
 */
public class ScalesBalance {

	/**
	 * 题目： 给出一个重物重量为X,另外提供的小砝码重量分别为1，3，9。。。3^N。 （假设N无限大，但一种重量的砝码只有一个）
	 * 将重物放到天平左侧，问在两边如何添加砝码使两边平衡
	 * 
	 * 分析： 三进制 我们约定括号表示里面的数是三进制，例如 47=(1202)
	 * 先看天秤右侧。放的全是砝码，由于一种重量的砝码只有一个，那么右侧的重量之和，用三进制表示的话，只包含0和1
	 * 要使两边平衡，那么左边的重量和的三进制也应该只包含0和1
	 * 那么答案就出来了：想办法使得左边的值只包含0和1，那就是把重物里面三进制表示里面的2变成0——对应的位置加1即可
	 * 将重物的重量转化为三进制，从最低位开始 1.遇到0 无操作 2.遇到1 右边放 3.遇到2 左边放 然后进位
	 * 
	 * 在实际程序的书写中，
	 * 1、我们判断一个数三进制的表示里面某一位是0还是1还是2，直接对3求余就可以了；然后右移一位（除以3），再对3求余，则求得更高一位是0还是1还是2
	 * 2、统计放了什么砝码时，将对应的二制进位置为1，例如
	 * 3={11}{二进制}，表示放了3^0和3^1这两个砝码；当然用数组存放也可以，只是浪费了空间
	 * 3、下面代码的balance函数的返回值永远是true，因为任意一个正整数都可以表示为三进制
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 100; i++) {
			boolean ok = balance(i);
			if (!ok) {
				System.out.println("error!");
			}
		}
	}

	private static boolean balance(int weight) {
		if (weight <= 0) {
			System.out.println("invalid input.");
			return false;
		}

		int origin = weight; // 备份
		int left = 0; // 左边放了什么砝码
		int right = 0; // 右边放了什么砝码
		int i = 0; // 判断第i位是0是1还是2。0是最低位
		while (weight != 0) {
			/*
			 * 1.遇到0 无操作 2.遇到1 右边放 3.遇到2 左边放 然后进位
			 */
			int tmp = weight % 3;
			switch (tmp) {
			case 1:
				// 右边放
				right = right | (1 << i);
				break;
			case 2:
				// 左边放 然后进位
				left = left | (1 << i);
				weight += 1;
				break;
			default:
				break;
			}
			i++;
			weight /= 3;
		}

		// 上面已经求得答案了，现在输出验证一下
		StringBuilder sbLeft = new StringBuilder("" + origin);
		int sumLeft = origin;
		if (left != 0) {
			int power = 1;
			while (left != 0) {
				int value = left & 1;
				if (value == 1) {
					sbLeft.append(" + " + power);
					sumLeft += power;
				}
				power *= 3;
				left = left >> 1;
			}
		}

		int sumRight = 0;
		StringBuilder sbRight = new StringBuilder();
		if (right != 0) {
			int m = 1;
			while (right != 0) {
				int value = right & 1;
				if (value == 1) {
					sbRight.append(" + " + m);
					sumRight += m;
				}
				m *= 3;
				right = right >> 1;
			}
		}
		System.out.println(sbLeft.toString() + " = " + sbRight.substring((" + ").length()).toString());
		System.out.println(sumLeft + "," + sumRight);
		return sumLeft == sumRight;
	}

}
