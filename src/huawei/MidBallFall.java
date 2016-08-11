package huawei;

import java.util.Scanner;

/**
 * 求小球落地5次后所经历的路程和第5次反弹的高度
 * 
 * @author han
 *
 */
public class MidBallFall {

	/**
	 * 统计出第5次落地时，共经过多少米?
	 * 
	 * @param high
	 *            球的起始高度
	 * @return 英文字母的个数
	 */
	public static double getJourney(int high) {
		double sum = (double) high;
		double init = (double) high;
		for (int i = 1; i < 5; i++) {
			sum += init;
			init /= 2;
		}
		return sum;
	}

	/**
	 * 统计出第5次反弹多高?
	 * 
	 * @param high
	 *            球的起始高度
	 * @return 空格的个数
	 */
	public static double getTenthHigh(int high) {
		double init = (double) high;
		for (int i = 0; i < 5; i++) {
			init /= 2;
		}
		return init;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int high = scanner.nextInt();
			System.out.println(getJourney(high));
			System.out.println(getTenthHigh(high));
		}
		scanner.close();
	}

}
