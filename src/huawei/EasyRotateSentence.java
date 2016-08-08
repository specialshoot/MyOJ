package huawei;

import java.util.Scanner;
import java.util.Stack;

/**
 * 句子逆序 将一个英文语句以单词为单位逆序排放。
 * 
 * @author han
 *
 */
public class EasyRotateSentence {

	public static String reverse(String sentence) {
		String[] sentences = sentence.split(" ");
		int len = sentences.length;
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < len; i++) {
			stack.push(sentences[i]);
		}
		String temp = "";
		while (!stack.isEmpty()) {
			temp += stack.pop() + " ";
		}
		return temp.trim();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String sentence = scanner.nextLine();
			System.out.println(reverse(sentence));
		}
		scanner.close();
	}

}
