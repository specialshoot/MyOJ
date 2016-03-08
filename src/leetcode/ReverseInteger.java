package leetcode;

public class ReverseInteger {

	//https://leetcode.com/problems/reverse-integer/
	public static int reverse(int x) {
		int INT_MAX=2147483647;
		int INT_MIN=-2147483648;
	
		double result = 0;
		int num=x;
		while (num / 10 != 0) {
			result *= 10;
			result += num % 10;
			num = num / 10;
		}
		result = result * 10 +num;
		return (result >= INT_MAX || result < INT_MIN? 0 : (int)result);
	}
	
	public static int reverse1(int num){
		char[] numArray = null;
	    String numStr="";
	    if (num == 0) {
	        return 0;
	    } else if (num > 0) {
	        numArray = (num + "").toCharArray();
	    } else {
	        numStr+="-";
	        numArray = (num + "").substring(1).toCharArray();
	    }
	    for(int i =numArray.length-1;i>=0;i--){
	        numStr+=numArray[i];
	    }
	    System.out.println(numStr);
	    return Integer.valueOf(numStr.trim());
	}

	public static void main(String agrs[]) {
		System.out.println(reverse(1234567899));
	}
}
