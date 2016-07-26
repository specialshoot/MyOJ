package others;

import java.io.BufferedReader;
import java.util.Scanner;

public class DifferentBitXiaoMi {

	static Scanner scanner;
    /**
     * 获得两个整形二进制表达位数不同的数量
     * 
     * @param m 整数m
     * @param n 整数n
     * @return 整型
     */
    public static int countBitDiff(int m, int n) {
    	int diff=m^n;//异或
    	int count=0;
    	while(diff!=0){//统计diff中1的个数
    		count++;
    		diff=diff&(diff-1);
    	}
    	return count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int m=scanner.nextInt();
			int n=scanner.nextInt();
			System.out.println(countBitDiff(m, n)+"");
		}
	}

}
