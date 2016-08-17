package offer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 第一个只出现一次的字符 使用LinkedHashMap有序哈希表
 * 
 * @author han
 *
 */
public class Offer35 {

	public static Character getOnly(String str) {
		char[] ch = str.toCharArray();
		Map<Character, Integer> map = new LinkedHashMap<>();// 用LinkedHashMap可以保留插入顺序
		for (char key : ch) {
			if (map.containsKey(key)) {
				map.put(key, map.get(key) + 1);
			} else {
				map.put(key, 1);
			}
		}
		for (char key : map.keySet()) {
			if (map.get(key) == 1) {
				return key;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abaccdeff";
		System.out.println(getOnly(str));
	}

}
