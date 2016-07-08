package leetcode;

public class CountingBits {

	// https://leetcode.com/problems/counting-bits/
	// 求0到num间数字二进制中1的个数
	 public static int[] countBits2(int num) {
	        int[] result=new int[num+1];
	        result[0]=0;
	        for(int i=1;i<=num;i++){
	            result[i]=getCount(i);
	        }
	        return result;
	    }
	    public static int getCount(int num){
	        int count=0;
	        while(num!=0){
	        	count+=(num&1);
	            num=num>>>1;
	        }
	        return count;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=5;
		System.out.println("num -> "+num);
		int[] result=countBits2(num);
		for(int i=0;i<=num;i++){
			System.out.print(result[i]+"");
		}
		System.out.println("end");
	}

}
