package huawei;

import java.util.Scanner;

/**
 * 计算字符串的相似度
 * 
 * @author han
 *
 */
public class EasyStringSimilar {

	/**
	 * 动态规划，最长公共子序列
	 * 设Ai为字符串A(a1a2a3 … am)的前i个字符(即为a1,a2,a3 … ai)
     * 设Bj为字符串B(b1b2b3 … bn)的前j个字符(即为b1,b2,b3 … bj)
     * 
     *  设 L(i,j)为使两个字符串和Ai和Bj相等的最小操作次数。
     *  
     *  当ai==bj时 显然 L(i,j) = L(i-1,j-1)
     *  
     *  当ai!=bj时
     *  若将它们修改为相等，则对两个字符串至少还要操作L(i-1,j-1)次
     *  若删除ai或在bj后添加ai，则对两个字符串至少还要操作L(i-1,j)次
     *  若删除bj或在ai后添加bj，则对两个字符串至少还要操作L(i,j-1)次
     *  此时L(i,j) = min((L(i-1,j-1), L(i-1,j), L(i,j-1) ) + 1)
     *  
     *  显然，L(i,0)=i，L(0,j)=j, 再利用上述的递推公式，可以直接计算出L(i,j)值。
	 * @param a
	 * @param b
	 * @return
	 */
	private static int stringDistance(char[] a, char[] b) {
        int[][] len = new int[a.length + 1][b.length + 1];

        for (int i = 0; i < len.length; i++) {
            len[i][0] = i;
        }

        for (int j = 0; j < len[0].length; j++) {
            len[0][j] = j;
        }

        for (int i = 1; i < len.length; i++) {
            for (int j = 1; j < len[0].length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    len[i][j] = len[i - 1][j - 1];
                } else {
                    len[i][j] = Math.min(Math.min(len[i - 1][j], len[i - 1][j - 1]), len[i][j - 1]) + 1;
                }
            }
        }

        return len[len.length - 1][len[0].length - 1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String a = scanner.next();
			String b = scanner.next();
            System.out.println("1/" + (stringDistance(a.toCharArray(), b.toCharArray()) + 1));
		}
		scanner.close();
	}

}
