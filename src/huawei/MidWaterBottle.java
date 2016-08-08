package huawei;

import java.util.Scanner;

/**
 * 汽水瓶
 * @author han
 *
 */
public class MidWaterBottle {

	private static int getMax(int n) {
		int count = 0;
		int temp = 0;
		while (n / 3 != 0) {
			temp = n / 3;
			n = temp + n % 3;
			count += temp;
		}
		if (n == 2) {
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			if(n==0){
				break;
			}
			System.out.println(getMax(n));
		}
		scanner.close();
	}

}
