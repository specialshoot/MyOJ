package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

	// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

	// 直接循环
	public static List<String> letterCombinations1(String digits) {

		List<String> result = new ArrayList<String>();
		if (digits.isEmpty()) { // 判空
			return result;
		}

		String[] map = new String[10];
		map[0] = "";
		map[1] = "";
		map[2] = "abc";
		map[3] = "def";
		map[4] = "ghi";
		map[5] = "jkl";
		map[6] = "mno";
		map[7] = "pqrs";
		map[8] = "tuv";
		map[9] = "wxyz";

		int[] number = new int[digits.length()]; // 存储digits中每个字符在循环中的编号，初始为0

		int k = digits.length() - 1; // 长度标号
		while (k >= 0) {
			k = digits.length() - 1;
			char[] charTemp = new char[digits.length()];
			for (int i = 0; i < digits.length(); i++) {
				charTemp[i] = map[digits.charAt(i) - '0'].charAt(number[i]);
			}
			result.add(new String(charTemp)); // 将每次遍历的字符数组组成字符串存到result中
			while (k >= 0) {
				if (number[k] < (map[digits.charAt(k) - '0'].length() - 1)) {
					// 如果第k个数字没有遍历完，number自加跳出循环，这样result能将本位字符更改后的字符串通过循环加入到result中
					number[k]++;
					break;
				} else {
					// 将前面的number[k]清零
					number[k] = 0;
					k--;
				}
			}
		}

		return result;
	}

	// 方法2 dfs
	public static List<String> letterCombinations2(String digits) {

		List<String> result = new ArrayList<String>();
		if (digits.isEmpty()) { // 判空
			return result;
		}
		String[] map = new String[10];
		map[0] = "";
		map[1] = "";
		map[2] = "abc";
		map[3] = "def";
		map[4] = "ghi";
		map[5] = "jkl";
		map[6] = "mno";
		map[7] = "pqrs";
		map[8] = "tuv";
		map[9] = "wxyz";
		char[] middleTemp = new char[digits.length()];
		dfsGetStr(digits, 0, middleTemp, map, result);
		return result;
	}

	private static void dfsGetStr(String digits, int index, char[] middleStr, String[] map, List<String> result) {
		if (index == digits.length()) {
			result.add(new String(middleStr));
			return;
		}
		char strChar = digits.charAt(index); // 第index位的数字
		for (int i = 0; i < map[strChar - '0'].length(); i++) { // 遍历第index位数字数组
			middleStr[index] = map[strChar - '0'].charAt(i);
			dfsGetStr(digits, index + 1, middleStr, map, result); // 嵌套index+1位
		}
	}

	public static void main(String[] args) {
		System.out.println(letterCombinations2(""));
	}
}
