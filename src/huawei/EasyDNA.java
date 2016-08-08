package huawei;

import java.util.Scanner;

public class EasyDNA {

	public static void getDNA(String dna, int n) {
		int len = dna.length();
		char[] ch = dna.toCharArray();
		int[] hasGC = new int[len];
		int[] sum = new int[len];
		for (int i = 0; i < len; i++) {
			if (ch[i] == 'G' || ch[i] == 'C') {
				hasGC[i] = 1;
			}
		}

		for (int i = 0; i < len - n; i++) {
			for (int j = 0; j < n; j++) {
				sum[i] += hasGC[i + j];
			}
		}

		int max = 0;
		int maxIndex = 0;
		for (int i = 0; i < len - n; i++) {
			if (max < sum[i]) {
				max = sum[i];
				maxIndex = i;
			}
		}
		System.out.println(dna.substring(maxIndex, maxIndex + n));
	}

	public static void getDNA2(String dna, int n) {
		int len = dna.length();
		char[] ch = dna.toCharArray();
		int max = 0;
		int maxIndex = 0;
		for (int i = 0; i < len - n; i++) {
			int maxtemp = 0;
			for (int j = 0; j < n; j++) {
				if (ch[i + j] == 'C' || ch[i + j] == 'G') {
					maxtemp++;
				}
			}
			if (max < maxtemp) {
				max = maxtemp;
				maxIndex = i;
			}
		}

		System.out.println(dna.substring(maxIndex, maxIndex + n));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String dna = scanner.next();
			int n = scanner.nextInt();
			getDNA2(dna, n);
		}
		scanner.close();
	}

}
