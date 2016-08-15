package offer;

/**
 * 数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 
 * @author han
 *
 */
public class Offer11 {

	public static double Power(double base, int exponent) {
		if (exponent == 0)
			return 1;
		if (base == 0)
			return 0;
		if (exponent == 1)
			return base;
		else if (exponent == -1)
			return 1 / base;
		double res=Power(base, exponent / 2) ;
		return res* res * ((exponent&0x01)==1? base:1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Power(2.0, 4));
	}
}
