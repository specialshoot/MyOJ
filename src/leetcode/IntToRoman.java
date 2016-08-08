package leetcode;

public class IntToRoman {

	public static String intToRoman(int num) {
		// https://leetcode.com/problems/integer-to-roman/
		int number = num;
		String result = "";
		int i = 0;
		String[][] roman = { { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" }, // 0-9
				{ "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" }, // 10-90
				{ "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" }, // 100-900
				{ "", "M", "MM", "MMM" } // 1000-3000
		};
		while (number / 10 != 0) {
			result = roman[i][number % 10] + result;
			number = number / 10;
			i++;
		}
		result = roman[i][number] + result;

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(intToRoman(96));
	}

}
