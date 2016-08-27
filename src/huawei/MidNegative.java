package huawei;

import java.util.Scanner;

public class MidNegative {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int countzs = 0;
		int countfs = 0;
		double average = 0.0;
		while (input.hasNext()) {
			int temp = input.nextInt();
			if (temp > 0) {
				countzs++;
				average += temp;
			} else if (temp < 0) {
				countfs++;
			}
		}
		System.out.println(countfs);
		System.out.println((countzs > 0 ? average / countzs : 0.0));
		input.close();
	}

}
