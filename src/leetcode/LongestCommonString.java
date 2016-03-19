package leetcode;

import org.omg.CORBA.PRIVATE_MEMBER;

public class LongestCommonString {

	//最长公共子序列
	//http://www.cnblogs.com/huangxincheng/archive/2012/11/11/2764625.html
	private static void LCS(String str1, String str2) {

		int[][] martix = new int[str1.length() + 1][str2.length() + 1];
		String[][] flag = new String[str1.length() + 1][str2.length() + 1];
		for (int i = 0; i <= str1.length(); i++) {
			martix[i][0] = 0;
		}
		for (int j = 0; j < str2.length(); j++) {
			martix[0][j] = 0;
		}
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					martix[i][j] = martix[i - 1][j - 1] + 1;
					flag[i][j] = "left_up";
				} else {
					if (martix[i - 1][j] >= martix[i][j - 1]) {
						martix[i][j] = martix[i - 1][j];
						flag[i][j] = "left";
					} else {
						martix[i][j] = martix[i][j - 1];
						flag[i][j] = "up";
					}
				}
			}
		}
		System.out.println("最长子序列长度 -> " + martix[str1.length()][str2.length()]);
		SubSequence(flag, str1, str2, str1.length(), str2.length());
	}

	private static void SubSequence(String[][] flag, String str1, String str2, int i, int j) {
		if (i == 0 || j == 0) {
			return;
		}
		if (flag[i][j] == "left_up") {
			System.out.println(str2.charAt(j - 1) + " -> 当前坐标 : " + (i - 1) + "" + (j - 1) + "");
			SubSequence(flag, str1, str2, i - 1, j - 1);
		} else {
			if (flag[i][j] == "up") {
				SubSequence(flag, str1, str2, i, j - 1);
			} else {
				SubSequence(flag, str1, str2, i - 1, j);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "acgbfhk";
		String str2 = "cegefkh";
		LCS(str1, str2);
	}
}
