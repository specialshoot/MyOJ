package others;

/**
 * 小球的距离 小东和三个朋友一起在楼上抛小球，他们站在楼房的不同层，假设小东站的楼层距离地面N米，球从他手里自由落下，每次落地后反跳回上次下落高度的一半，
 * 并以此类推知道全部落到地面不跳，求4个小球一共经过了多少米？(数字都为整数) 给定四个整数A,B,C,D，请返回所求结果。
 * 
 *  测试样例：
 * 
 * 100,90,80,70 
 * 
 * 返回：
 * 
 * 1020
 * 
 * 每个小球的距离(x+x/2)+(x/2+x/4)+(x/4+x/8)+(x/8+x/16)+...=x+x+(x/2+x/4+x/8...)=x+x+x(1/2+1/4+1/8+...)极限=3*x
 * @author han
 *
 */
public class JingDongBallDistance {

	public static int calcDistance(int A, int B, int C, int D) {
		// write code here
		return 3*(A+B+C+D);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
