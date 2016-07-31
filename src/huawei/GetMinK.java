package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class GetMinK {

	public static int[] getMinK(int n, int[] num, int k) {
		Arrays.sort(num);
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = num[i];
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			int[] num = new int[n];
			for (int i = 0; i < n; i++) {
				num[i] = scanner.nextInt();
			}
			int[] res = getMinK(n, num, k);
			String temp = "";
			for (int i = 0; i < res.length; i++) {
				temp += res[i] + " ";
			}
			System.out.println(temp.trim());
		}
	}

}
