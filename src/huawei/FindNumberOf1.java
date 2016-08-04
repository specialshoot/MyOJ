package huawei;

import java.util.Scanner;

public class FindNumberOf1 {

	public static int findNumberOf1(int num)
    {
        /* 请实现 */
		int count=0;
		while(num!=0){
			count++;
			num=(num-1)&num;
		}
        return count;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		while (scanner.hasNext()) {
			int num=scanner.nextInt();
			System.out.println(findNumberOf1(num));
		}
		scanner.close();
	}

}
