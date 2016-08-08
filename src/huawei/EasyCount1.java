package huawei;

import java.util.Scanner;

/**
 * 求int型数据在内存中存储时1的个数
 * 即某个数二进制形式1的个数
 * @author han
 *
 */
public class EasyCount1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNext()){
			int n=scanner.nextInt();
			int count=0;
			while(n!=0){
				count++;
				n=(n-1)&n;
			}
			System.out.println(count+"");
		}
		scanner.close();
	}

}
