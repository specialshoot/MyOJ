package NetEase;

import java.util.Arrays;
import java.util.Scanner;

public class NumBlackHole {

	public static void getHole(int input) {
		if (input % 1111 == 0) {
			he(fen(input));
			return;
		}
		while (input != 6174) {
			input = he(fen(input));
		}
	}

	public static int[] fen(int input) // 拆分4位数
	{
		int a[] = new int[4];
		a[0] = input / 1000; // 千位数
		input = input % 1000;
		a[1] = input / 100; // 百位数
		input = input % 100;
		a[2] = input / 10; // 十位数
		input = input % 10;
		a[3] = input; // 个位数
		Arrays.sort(a); // 从小到大排序
		return a;
	}

	public static int[] fenRes(int input) // 拆分4位数
	{
		int a[] = new int[4];
		a[0] = input / 1000; // 千位数
		input = input % 1000;
		a[1] = input / 100; // 百位数
		input = input % 100;
		a[2] = input / 10; // 十位数
		input = input % 10;
		a[3] = input; // 个位数
		return a;
	}

	public static int he(int a[]) // 合并4位数，重新组成最大和最小的四位数
	{
		Arrays.sort(a);
		int max = a[3] * 1000 + a[2] * 100 + a[1] * 10 + a[0]; // 最大的四位数
		int min = a[0] * 1000 + a[1] * 100 + a[2] * 10 + a[3]; // 最小四位数
		int[] res = fenRes(max - min);
		String maxString = "";
		String minString = "";
		String resString = "";
		for (int i = 0; i < 4; i++) {
			maxString += a[3 - i] + "";
			minString += a[i] + "";
			resString += res[i] + "";
		}
		System.out.println(maxString + " - " + minString + " = " + resString);
		return max - min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			getHole(n);
		}
		scanner.close();
	}

}
