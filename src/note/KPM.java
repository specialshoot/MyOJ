package note;

public class KPM {

	// java实现kpm算法
	// 算法原理:http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html
	// http://v.youku.com/v_show/id_XOTMyMjcxNzIw.html?from=s1.8-1-1.2
	// 见note文件夹下kmp算法.txt笔记

	// KMP中的核心算法,获得记录跳转状态的next数组
	public static int[] next1(String sub) {
		int[] a = new int[sub.length()];
		char[] c = sub.toCharArray();
		int length = sub.length();
		int i, j;
		a[0] = -1;
		i = 0;
		for (j = 1; j < length; j++) {
			i = a[j - 1];
			while (i >= 0 && c[j] != c[i + 1]) {
				i = a[i];
			}
			if (c[j] == c[i + 1]) {
				a[j] = i + 1;
			} else {
				a[j] = -1;
			}
		}
		return a;
	}

	// 与上面算法思路一致,换一种写法
	public static int[] next2(String sub) {
		int[] next = new int[sub.length()];
		char[] c = sub.toCharArray();
		int length = sub.length();
		next[0] = -1;
		int k = -1, j = 0;
		while (j < length - 1) {
			if (k == -1 || c[j] == c[k]) {
				++k;
				++j;
				if (c[j] == c[k]) {
					next[j] = next[k];
				} else {
					next[j] = k;
				}
			} else {
				k = next[k];
			}
		}
		return next;
	}

	public static void pattern(String str, String sub, int[] next) {
		char[] ch1 = str.toCharArray();
		char[] ch2 = sub.toCharArray();
		int i = 0, j = 0; // i控制ch1,j控制ch2;
		for (; i < ch1.length;) {
			if (ch1[i] == ch2[j]) {// 匹配就自动递增，往后匹配。
				if (j == ch2.length - 1) {
					System.out.println(i - ch2.length + 1);
					break;
				}
				j++;
				i++;
			} else if (j == 0) {
				i++;
			} else {
				j = next[j - 1] + 1;
			}
		}
	}

	public static void main(String[] args) {
		String sub = "aabaccfaddddaabc";
		String str = "gdsaadfdgffccsdaabaccfdaddaabaccfaddddaabcga";
		int[] next = next1(sub);
		pattern(str, sub, next);
	}
}
