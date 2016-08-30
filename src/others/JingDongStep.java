package others;

/**
 * 上台阶 有一楼梯共m级，刚开始时你在第一级，若每次只能跨上一级或者二级，要走上m级，共有多少走法？ 注：规定从一级到一级有0种走法。
 * 给定一个正整数n，请返回一个数，代表上楼的方式数。保证n小于等于100。为了防止溢出，请返回结果Mod 1000000007的值。
 * 
 * 测试样例： 3
 * 
 * 返回：2
 */
public class JingDongStep {

	public static int countWays(int n) {
		// write code here
		long a0 = 0;
		long a1 = 1;
		long a2 = 0;
		while (n > 0) {
			a2 = a0 % 1000000007l + a1 % 1000000007l;
			a0 = a1 % 1000000007l;
			a1 = a2 % 1000000007l;
			n--;
		}
		return (int) a0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countWays(3));
	}

}
