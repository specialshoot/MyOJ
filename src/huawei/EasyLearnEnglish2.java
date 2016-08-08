package huawei;

import java.util.Scanner;

public class EasyLearnEnglish2 {

	private static String[] number = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
			"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen" };
	private static String[] shangshi = { "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
			"ninety" };

	public static String toEnglish(long num) {
		if (num >= 10_000_000_000L) {
			return "error";
		}
		long[] shuwei = new long[10];
		shuwei[0] = num % 10;
		int i = 1;
		while (num / 10 != 0) {
			num = num / 10;
			shuwei[i] = num % 10;
			i++;
		}
		long oneWei = shuwei[2] * 100 + shuwei[1] * 10 + shuwei[0];
		long twoWei = shuwei[5] * 100 + shuwei[4] * 10 + shuwei[3];
		long threeWei = shuwei[8] * 100 + shuwei[7] * 10 + shuwei[6];
		long fourWei = shuwei[9];
		String first = handleThree(oneWei);
		String second = handleThree(twoWei);
		String third = handleThree(threeWei);
		String four = handleThree(shuwei[9]);
		String res = "";
		if (fourWei != 0) {
			res += four + " billion";
		}
		if (threeWei != 0) {
			res += " " + third + " million";
		}
		if (twoWei != 0) {
			res += " " + second + " thousand";
		}
		if (oneWei != 0) {
			res += " " + first;
		}
		return res;
	}

	private static String handleThree(long numlong) {
		int num = (int) numlong;
		String temp = "";
		if (num == 0) {
			return "";
		}
		int bai = num / 100;
		int shi = num / 10 % 10;
		int ge = num % 10;
		int lastTwo = shi * 10 + ge;
		if (bai != 0) {// 百位不为0
			temp += number[num / 100] + " hundred";
			if (lastTwo > 0) {
				temp += " and ";
			}
		}
		if (lastTwo < 20) {
			temp += number[lastTwo];
		} else {
			temp += shangshi[shi] + " " + number[ge];
		}
		return temp.trim();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			long num = scanner.nextLong();
			System.out.println(toEnglish(num).trim());
		}
		scanner.close();
	}

}
