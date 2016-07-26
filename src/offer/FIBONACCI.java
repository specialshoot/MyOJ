package offer;
/**
 * FIBONACCI数列
 * @author han
 *
 */
public class FIBONACCI {

	public static int fibonacci(int n){//超时
		if(n<=0){
			return 0;
		}
		if(n==1 || n==2){
			return 1;
		}
		return fibonacci(n-1)+fibonacci(n-2);
	}
	
	public static int fibonacci2(int n){//超时
		 int[] f=new int[2];
	        f[0] = 0;
	        f[1] = 1;
	        for(int i = 2; i <= n; i++)
	        {
	            f[i%2] = f[(i-1)%2] + f[(i-2)%2];
	        }
	        return f[n%2];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibonacci2(5));
	}

}
