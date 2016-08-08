package offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 青蛙只能从上一阶或上上一阶跳过来，满足F(n)=F(n-1)+F(n-2)，不用递归是因为超时，同FIBONACCI
 * 
 * @author han
 *
 */
public class JumpFloor {

	public static int jumpFloor(int target) {
		if (target == 1 || target == 2) {
			return target;
		}

		int jumpFib = 0;
		int NumberMinusOne = 2;
		int NumberMinusTwo = 1;
		for (int i = 3; i <= target; i++) {
			jumpFib = NumberMinusOne + NumberMinusTwo;
			NumberMinusTwo = NumberMinusOne;
			NumberMinusOne = jumpFib;
		}
		return jumpFib;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(jumpFloor(5));
	}

}
