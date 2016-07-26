package offer;

/**
 * 用%20代替空格
 */
import java.util.Scanner;

public class ReplaceSpace {

	public static String replaceSpace(StringBuffer str) {
		if (str == null) {
			return "";
		}
		char[] strs = str.toString().toCharArray();
		int i = 0;
		int oldCount = 0;
		int spaceCount = 0;
		while (i < strs.length && strs[i] != '\0') {
			oldCount++;
			if (strs[i] == ' ') {
				spaceCount++;
			}
			i++;
		}
		char[] result = new char[spaceCount * 2 + oldCount];
		i = 0;
		int j = 0;
		while (i < strs.length) {
			if (strs[i] != ' ') {
				result[j++] = strs[i];
			} else {
				result[j++] = '%';
				result[j++] = '2';
				result[j++] = '0';
			}
			i++;
		}
		return new String(result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {// 注意while处理多个case
			StringBuffer sb = new StringBuffer(in.nextLine());
			System.out.println(replaceSpace(sb));
		}
	}

}
