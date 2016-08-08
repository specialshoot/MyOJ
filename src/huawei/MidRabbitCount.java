package huawei;

import java.util.Scanner;

/**
 * 统计每个月兔子的总数 http://blog.csdn.net/DERRANTCM/article/details/51343986
 * 
 * @author han
 *
 */
public class MidRabbitCount {

	public static int getTotalCount(int monthCount) {
		if (monthCount <= 0) {
			return 0;
		}
		if (monthCount <= 2) {
			return 1;
		}
		int prev1 = 1;
		int prev2 = 1;
		int result = 0;
		for (int i = 3; i <= monthCount; i++) {
			result = prev1 + prev2;
			prev1 = prev2;
			prev2 = result;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int monthCount = scanner.nextInt();
			System.out.println(getTotalCount(monthCount));
		}
		scanner.close();
	}

}
