package huawei;

/**
 * 输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数
 */
import java.util.Scanner;

public class EasyCountCharacter {

	private static String str = "";

	public static int getEnglishCharCount() {
		int len = str.length();
		int count = 0;
		for (int i = 0; i < len; i++) {
			if (Character.isLetter(str.charAt(i))) {
				str = str.substring(0, i) + str.substring(i + 1);
				count++;
				i--;
				len--;
			}
		}
		return count;
	}

	public static int getBlankCharCount() {
		int len = str.length();
		int count = 0;
		for (int i = 0; i < len; i++) {
			if (str.charAt(i) == ' ') {
				str = str.substring(0, i) + str.substring(i + 1);
				count++;
				i--;
				len--;
			}
		}
		return count;
	}

	public static int getNumberCharCount() {
		int len = str.length();
		int count = 0;
		for (int i = 0; i < len; i++) {
			if (Character.isDigit(str.charAt(i))) {
				str = str.substring(0, i) + str.substring(i + 1);
				count++;
				i--;
				len--;
			}
		}
		return count;
	}

	public static int getOtherCharCount() {
		return str.length();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			str = scanner.nextLine();
			int english = getEnglishCharCount();
			int blank = getBlankCharCount();
			int num = getNumberCharCount();
			int other = getOtherCharCount();
			System.out.println(english);
			System.out.println(blank);
			System.out.println(num);
			System.out.println(other);
		}
		scanner.close();
	}

}
