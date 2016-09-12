package NetEase;

import java.util.Scanner;

/**
 * 网易黑暗数
 * 
 * 一串字符串只有ABC三个字符,如果该字符串中连续的3个字符中含有ABC则该字符串为黑暗的,否则是纯净的
 * 
 * 如AABBCAAA是黑暗的,AABBCC是纯净的
 * 
 * 输入:输入整数n(1<=n<=30)表示输入字符串长度
 * 
 * 输出:输出含有黑暗字符串个数
 * 
 * 例如:
 * 
 * 输入:2
 * 
 * 输出:9
 * 
 * 输入:3
 * 
 * 输出:21
 * 
 * @author han
 *
 */
public class NetEaseBlackNum {

	private static final int MAXN = 35;
	private static long dp[] = new long[MAXN];

	public static void main(String[] args) {
		// TODO Auto-generated method
		dp[1] = 3;
		dp[2] = 9;
		for (int i = 3; i < MAXN; i++) {
			dp[i] = dp[i - 1] * 2 + dp[i - 2];
		}
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			System.out.println(dp[scanner.nextInt()]);
		}
		scanner.close();
	}

}
