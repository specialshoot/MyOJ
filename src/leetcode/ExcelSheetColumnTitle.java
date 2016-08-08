package leetcode;

public class ExcelSheetColumnTitle {

	// https://leetcode.com/problems/excel-sheet-column-title/
	/*
	 * Excel序是这样的：A~Z, AA~ZZ, AAA~ZZZ, …… 本质上就是将一个10进制数转换为一个26进制的数
	 */
	public static String convertToTitle(int n) {
		String result = "";
		while (n > 0) {
			result = (char) ((n - 1) % 26 + 'A') + result;
			n = (n - 1) / 26;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertToTitle(12));
	}

}
