package NetEase;

import java.util.Scanner;

/**
 * 藏宝图 牛牛拿到了一个藏宝图，顺着藏宝图的指示，牛牛发现了一个藏宝盒，藏宝盒上有一个机关，机关每次会显示两个字符串 s 和 t.
 * 根据古老的传说，牛牛需要每次都回答 t 是否是 s 的子序列。注意，子序列不要求在原字符串中是连续的，例如串 abc，它的子序列就有 {空串, a,b,
 * c, ab, ac, bc, abc} 8 种。
 * 
 * 输入描述: 每个输入包含一个测试用例。每个测试用例包含两行长度不超过 10 的不包含空格的可见ASCII 字符串.
 * 
 * 输出描述: 输出一行 “Yes” 或者 “No” 表示结果。
 * 
 * 输入例子:
 * 
 * x.nowcoder.com
 * 
 * ooo
 * 
 * 输出例子: Yes
 * 
 * @author han
 *
 */
public class TreasureMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String str1 = scanner.next();
			String str2 = scanner.next();
			int len1 = str1.length();
			int len2 = str2.length();
			int i = 0;
			while (len2 != i && len1 != 0) {
				int index = str1.indexOf(str2.charAt(i));
				if (index != -1) {
					str1 = str1.substring(index + 1);
					i++;
				} else {
					break;
				}
			}
			if (len2 != i) {
				System.out.println("No");
			} else {
				System.out.println("Yes");
			}
		}
		scanner.close();
	}

}
