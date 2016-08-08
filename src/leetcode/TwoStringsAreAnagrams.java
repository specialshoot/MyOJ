package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoStringsAreAnagrams {

	// http://www.lintcode.com/en/problem/two-strings-are-anagrams/
	// 这道题时lintcode的题,判断两个字符串是否为异序词

	// 方法一,统计词频
	public static boolean anagram1(String s, String t) {
		// write your code here
		if (s.isEmpty() || t.isEmpty()) {
			return false;
		}
		if (s.length() != t.length()) {
			return false;
		}
		int[] letterCount = new int[256];
		for (int i = 0; i < 256; i++) {
			letterCount[i] = 0;
		}
		for (int i = 0; i != s.length(); ++i) {
			++letterCount[(int) (s.charAt(i))];
			--letterCount[(int) (t.charAt(i))];
		}
		for (int i = 0; i != t.length(); ++i) {
			if (letterCount[(int) (t.charAt(i))] != 0) {
				return false;
			}
		}
		return true;
	}

	// 方法二.排序字符串
	public static boolean anagram2(String s, String t) {
		// write your code here
		if (s.isEmpty() || t.isEmpty()) {
			return false;
		}
		if (s.length() != t.length()) {
			return false;
		}
		char[] cs = s.toCharArray();
		char[] ct = t.toCharArray();
		Arrays.sort(cs);
		Arrays.sort(ct);
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] != ct[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "abcabcabc";
		String b = "aaabbbccd";
		System.out.println(anagram2(a, b));
	}

}
