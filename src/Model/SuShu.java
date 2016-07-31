package Model;
/**
 * 检查是否为素数
 * @author han
 *
 */
public class SuShu {

	/**
	 * 从2开始，迭代到n的平方根即可
	 * 因为如果n可以被一个数整除,那么其中一个数一定小于等于n开方,另一个大于等于n的开方,所以只需要算到这儿,到后面就是多余的了
	 * @param n
	 * @return
	 */
	private static boolean checkSuShu(int n){
	    if(n<2)  
	        return false;
	    for(int i=2;i<=Math.sqrt(n);i++){  
	        if(n%i==0)  
	            return false;  
	    }  
	    return true;  
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkSuShu(9));
	}

}
