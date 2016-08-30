package others;

import java.util.Scanner;

/**
 * 拉姆刚开始学习英文单词，对单词排序很感兴趣。
 * 如果给拉姆一组单词，他能够迅速确定是否可以将这些单词排列在一个列表中，使得该列表中任何单词的首字母与前一单词的为字母相同。
 * 你能编写一个程序来帮助拉姆进行判断吗？
 * 
 * 输入描述:
 * 
 * 输入包含多组测试数据。
 * 
 * 对于每组测试数据，第一行为一个正整数n，代表有n个单词。
 * 
 * 然后有n个字符串，代表n个单词。
 * 
 * 保证：
 * 
 * 2<=n<=200,每个单词长度大于1且小于等于10,且所有单词都是由小写字母组成。
 * 
 * 输出描述: 对于每组数据，输出"Yes"或"No"
 * 
 * @author han
 *
 */
public class BaiDuWordChain {

	public static void getAnswer(String[] words, int n) {
		if (words == null || n == 0) {
			System.out.println("No");
			return;
		}
		if (n == 1) {
			System.out.println("Yes");
			return;
		}
		for (int i = 1; i < n; i++) {
			String back = words[i];
			String front = words[i - 1];
			if (!(back.charAt(0) == front.charAt(front.length() - 1))) {
				System.out.println("No");
				return;
			}
		}
		System.out.println("Yes");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			String[] words = new String[n];
			for (int i = 0; i < n; i++) {
				words[i] = scanner.next();
			}
			getAnswer(words, n);
		}
		scanner.close();
	}

}
