package Model;

public class PowMN {

	/**
	 * m的n次方
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	private static int pow(int m, int n) {
		int res = 0;
		if (n == 0) {
			res = 1;
		} else {
			res = pow(m, n / 2);
			res = res * res;
			if (n % 2 == 1) {
				res = m * res;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pow(5, 2));
	}

}
