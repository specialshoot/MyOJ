package NetEase;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 两种排序方法 考拉有n个字符串字符串，任意两个字符串长度都是不同的。考拉最近学习到有两种字符串的排序方法： 1.根据字符串的字典序排序。例如： "car"
 * < "carriage" < "cats" < "doggies < "koala" 2.根据字符串的长度排序。例如： "car" < "cats" <
 * "koala" < "doggies" < "carriage"
 * 考拉想知道自己的这些字符串排列顺序是否满足这两种排序方法，考拉要忙着吃树叶，所以需要你来帮忙验证。 输入描述: 输入第一行为字符串个数n(n ≤ 100)
 * 接下来的n行,每行一个字符串,字符串长度均小于100，均由小写字母组成
 * 
 * 
 * 输出描述: 如果这些字符串是根据字典序排列而不是根据长度排列输出"lexicographically",
 * 
 * 如果根据长度排列而不是字典序排列输出"lengths",
 * 
 * 如果两种方式都符合输出"both"，否则输出"none"
 * 
 * 输入例子:
 * 
 * 3
 * 
 * a
 * 
 * aa
 * 
 * bbb
 * 
 * 输出例子:
 * 
 * both
 * 
 * @author han
 *
 */
public class TwoSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			String[] ss = new String[n];
			for (int i = 0; i < n; i++) {
				ss[i] = scanner.next();
			}
			boolean dic = true;
			boolean leng = true;
			String[] copy1 = Arrays.copyOf(ss, ss.length);
			Arrays.sort(copy1, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					// TODO Auto-generated method stub
					return o1.compareTo(o2);
				}
			});

			for (int i = 0; i < copy1.length; i++) {
				if (!copy1[i].equals(ss[i])) {
					dic = false;
					break;
				}
			}

			String[] copy2 = Arrays.copyOf(ss, ss.length);
			Arrays.sort(copy2, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					// TODO Auto-generated method stub
					if (o1.length() == o2.length()) {
						return 0;
					}
					if (o1.length() < o2.length()) {
						return -1;
					}
					return 1;
				}
			});
			for (int i = 0; i < copy2.length; i++) {
				if (!copy2[i].equals(ss[i])) {
					leng = false;
					break;
				}
			}
			if (dic == true && leng == true) {
				System.out.println("both");
			} else if (dic == true) {
				System.out.println("lexicographically");
			} else if (leng == true) {
				System.out.println("lengths");
			} else {
				System.out.println("none");
			}
		}
		scanner.close();
	}

}
