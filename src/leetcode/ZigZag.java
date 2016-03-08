package leetcode;

public class ZigZag {

	// https://leetcode.com/problems/zigzag-conversion/
	// ZigZag是环对角线结构

	public static String convert(String s, int numRows) {

		// 不足一列
		if (numRows <= 1 || s.length() == 0)
			return s;

		String res = "";
		int len = s.length();
		for (int i = 0; i < len && i < numRows; ++i) {
			int indx = i;
			System.out.println(indx+"");
			res += s.substring(indx, indx + 1);

			for (int k = 0; indx < len; ++k) {
				// 第一行或最后一行，使用公式1：2n-2
				if (i == 0 || i == numRows - 1) {
					indx += 2 * numRows - 2;
				}
				// 中间行，判断奇偶，使用公式2或3
				else {
					if (k % 2 == 1) { // 奇数位
						indx += 2 * (numRows - 1 - i);
					} else {
						//偶数位
						indx += 2 * i;
					}
				}

				// 判断indx合法性
				if (indx < len) {
					System.out.println(indx+"");
					res += s.substring(indx, indx + 1);
				}
			}
		}
		return res;
	}

	public static void main(String agrs[]) {
		String str = "PAYPALISHIRING";
		System.out.println(convert(str, 3));
	}

}
