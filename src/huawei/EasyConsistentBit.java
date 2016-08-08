package huawei;

import java.util.Scanner;

/**
 * 求最大连续bit数
 * 
 * @author han
 *
 */
public class EasyConsistentBit {

	private static int maxBits(int num) {
		int max = 0;
		int tempMax = 0;
		while (num != 0) {
			tempMax = (num & 1) == 1 ? tempMax + 1 : 0;
			max = Math.max(max, tempMax);
			num = num >> 1;
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int num = scanner.nextInt();
			System.out.println(maxBits(num));
		}
		scanner.close();
	}

}
