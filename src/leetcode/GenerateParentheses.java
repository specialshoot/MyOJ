package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	// https://leetcode.com/problems/generate-parentheses/
	// http://blog.csdn.net/yutianzuijin/article/details/13161721
	// http://www.programcreek.com/2014/01/leetcode-generate-parentheses-java/
	// http://blog.csdn.net/hackbuteer1/article/details/7450250
	// 亚特兰数,可以参看本电脑han目录下interview文件下catalan.cpp

	public static List<String> generateParenthesis(int n) {
		ArrayList<String> result = new ArrayList<String>();
		dfs(result, "", n, n); // 深优
		return result;
	}

	// 深优递归
	public static void dfs(ArrayList<String> result, String s, int left,
			int right) {
		if (left > right)
			return;

		if (left == 0 && right == 0) {
			result.add(s);
			return;
		}

		if (left > 0) {
			dfs(result, s + "(", left - 1, right);
		}

		if (right > 0) {
			dfs(result, s + ")", left, right - 1);
		}
	}

	// use n=2 to walk though the code没看懂
	public static List<String> generateParenthesis2(int n) {
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<Integer> diff = new ArrayList<Integer>();

		result.add("");
		diff.add(0);

		for (int i = 0; i < 2 * n; i++) {
			ArrayList<String> temp1 = new ArrayList<String>();
			ArrayList<Integer> temp2 = new ArrayList<Integer>();

			for (int j = 0; j < result.size(); j++) {
				String s = result.get(j);
				int k = diff.get(j);

				if (i < 2 * n - 1) {
					temp1.add(s + "(");
					temp2.add(k + 1);
				}

				if (k > 0 && i < 2 * n - 1 || k == 1 && i == 2 * n - 1) {
					temp1.add(s + ")");
					temp2.add(k - 1);
				}
			}

			result = new ArrayList<String>(temp1);
			diff = new ArrayList<Integer>(temp2);
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateParenthesis(3));
	}

}
