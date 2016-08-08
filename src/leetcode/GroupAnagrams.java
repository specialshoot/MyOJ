package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.print.DocFlavor.STRING;

public class GroupAnagrams {

	// https://leetcode.com/problems/anagrams/

	// 使用hashmap Accept
	public static List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for (int i = 0; i < strs.length; ++i) {
			char[] chars = strs[i].toCharArray(); // 将字符串转化为char数组形式
			Arrays.sort(chars);
			String key = String.valueOf(chars);
			if (map.containsKey(key)) {
				map.get(key).add(strs[i]);
			} else {
				List<String> list = new ArrayList<String>();
				list.add(strs[i]);
				map.put(key, list);
			}
		}
		List<List<String>> res = new ArrayList<List<String>>();
		for (List<String> l : map.values()) {
			Collections.sort(l);
			res.add(l);
		}
		return res;
	}

	// 一般的不好的方法:双循环 Time Limited
	public static List<List<String>> groupAnagrams2(String[] strs) {
		int length = strs.length;
		List<List<String>> res = new ArrayList<List<String>>();
		boolean[] visited = new boolean[length]; // 是否遍历过
		for (int i = 0; i < length; i++) {
			visited[i] = false;
		}
		for (int i = 0; i < length; i++) {
			if (visited[i] == true) {
				continue;
			}
			List<String> temp = new ArrayList<String>();
			temp.add(strs[i]);
			visited[i] = true;
			for (int j = i + 1; j < length; j++) {
				if (!visited[j] && isAnagram(strs[i], strs[j])) {
					temp.add(strs[j]);
					visited[j] = true;
				}
			}
			Collections.sort(temp);
			res.add(temp);
		}
		return res;
	}

	// 判断两个字符串是否为异序词
	public static boolean isAnagram(String s, String t) {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		GroupAnagrams g = new GroupAnagrams();
		List<List<String>> res = g.groupAnagrams2(strs);
		for (List<String> subRes : res) {
			for (String s : subRes)
				System.out.print(s + "\t");
			System.out.println("\n");
		}
	}

}
