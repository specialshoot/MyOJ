package huawei;

import java.util.Scanner;
/**
 * 查找组成一个偶数最接近的两个素数
 * @author han
 *
 */
public class FindPrimeNumber {

	public static class PrimePair {
       public int primeMin;
       public int primeMax;
    }
	
	public static PrimePair findPrimeNumber(int number) {
        /* 请实现 */
		int minMinus=10000;
		PrimePair pair=new PrimePair();
		for(int i=2;i<=number/2;i++){
			if(checkSuShu(i) && checkSuShu(number-i)){
				int temp=Math.min(minMinus, number-2*i);
				if(temp<minMinus){
					minMinus=temp;
					pair.primeMin=i;
					pair.primeMax=number-i;
				}
			}
		}
       return pair;
    }
	
	/**
	 * 判断是否为素数
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
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int num = scanner.nextInt();
			PrimePair pair=findPrimeNumber(num);
			System.out.println(pair.primeMin);
			System.out.println(pair.primeMax);
		}
		scanner.close();
	}

}
