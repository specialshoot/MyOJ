package offer;
/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 同jumpfloor
 * @author han
 *
 */
public class RectCover {

    public int RectCover(int target) {
		if (target == 1 || target== 2) {
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

	}

}
