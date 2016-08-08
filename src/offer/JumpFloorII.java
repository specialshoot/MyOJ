package offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * f(n)=f(n-1)+f(n-2)+...+f(n-(n-1)) f(n-1)=f(n-2)+f(n-3)+...+f(n-(n-1))
 * 所以f(n)=f(n-1)+f(n-1)=2*f(n-1)
 * 
 * @author han
 *
 */
public class JumpFloorII {

	public int JumpFloorII(int target) {
		if (target == 1) {
			return 1;
		}
		return 2 * JumpFloorII(target - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
