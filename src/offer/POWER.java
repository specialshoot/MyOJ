package offer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @author han
 *
 */
public class POWER {
	
	public static double Power(double base, int exponent) {
		if(exponent == 0) return 1;
        if(base == 0) return 0;
        if(exponent == 1)
            return base;
        else if(exponent == -1)
            return 1/base;
        return Power(base,exponent/2) * Power(base,exponent/2) * Power(base,exponent%2);
	  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Power(2.0, 5)+"");
	}
}
