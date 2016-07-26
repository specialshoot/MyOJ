package others;

/**
 * http://www.nowcoder.com/questionTerminal/729f5e6e2acc4f3cb14a2262888f86fb
 * 给定 x, k ，求满足 x + y = x | y 的第 k 小的正整数 y 。 | 是二进制的或(or)运算，例如 3 | 5 = 7。
 * 比如当 x=5，k=1时返回 2，因为5+1=6 不等于 5|1=5，而 5+2=7 等于 5 | 2 = 7。
 * 
 * 输入描述:
 * 每组测试用例仅包含一组数据，每组数据为两个正整数 x , k。 满足 0 < x , k ≤ 2,000,000,000。
 * 
 * 输出描述:
 * 输出一个数y。
 * 
 * 输入例子:
 * 5 1
 * 
 * 输出例子:
 * 2
 */
import java.math.BigInteger;
import java.util.Scanner;

public class OrAndToday {

	private static Scanner scanner;

	/*
	 * 如果或要和加的运算结果相同，i在x的为0的位上可以是0，也可以是1；在x的为1的位上只能是0。
	 * 所以x的二进制表示为0的位就是可用的“数位”，可以将k的二进制直接“映射”过去。而为1的位只能是0。
	 * 这样就构建出了结果的二进制表示字符串。
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int x = scanner.nextInt();
			int k = scanner.nextInt();
			StringBuilder res=new StringBuilder();
            String k_bin=Integer.toString(k, 2);//二进制表示
            int index=k_bin.length()-1;
            while(k!=0){
                if((x&1)==0){
                    res.append(k_bin.charAt(index--));
                    k/=2;
                }else{
                    res.append("0");
                }
                x>>>=1; //无符号右移，忽略符号位，空位都以0补齐
            }
            BigInteger num=new BigInteger(res.reverse().toString(), 2);
            System.out.println(num);
		}
	}
}
