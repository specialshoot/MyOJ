package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringwithConcatenationOfAllWords {

	//https://leetcode.com/problems/substring-with-concatenation-of-all-words/
	//HARD!!!
	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<Integer>();
		if (s == null || s.length() == 0 || words == null || words.length == 0)
			return res;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < words.length; i++) {
			//Hashmap记录个数
			if (map.containsKey(words[i])) {
				map.put(words[i], map.get(words[i]) + 1);
			} else {
				map.put(words[i], 1);
			}
		}
		for (int i = 0; i < words[0].length(); i++) {
			HashMap<String, Integer> curMap = new HashMap<String, Integer>();
			int count = 0;
			int left = i;
			for (int j = i; j <= s.length() - words[0].length(); j += words[0].length()) {
				String str = s.substring(j, j + words[0].length());

				if (map.containsKey(str)) {
					if (curMap.containsKey(str))
						curMap.put(str, curMap.get(str) + 1);
					else
						curMap.put(str, 1);
					if (curMap.get(str) <= map.get(str))
						count++;
					else {
						while (curMap.get(str) > map.get(str)) {
							String temp = s.substring(left, left + words[0].length());
							if (curMap.containsKey(temp)) {
								curMap.put(temp, curMap.get(temp) - 1);
								if (curMap.get(temp) < map.get(temp))
									count--;
							}
							left += words[0].length();
						}
					}
					if (count == words.length) {
						res.add(left);
						String temp = s.substring(left, left + words[0].length());
						if (curMap.containsKey(temp))
							curMap.put(temp, curMap.get(temp) - 1);
						count--;
						left += words[0].length();
					}
				} else {
					curMap.clear();
					count = 0;
					left = j + words[0].length();
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
