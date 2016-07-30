package huawei;

import java.util.Scanner;

public class EasyGetSeven {

	public static int getSeven(int n){
		if(n==0){
			return 0;
		}
		int count=0;
		for(int i=1;i<=n;i++){
			if((i%7)==0){
				count++;
				continue;
			}
			int temp=i;
			while(temp!=0){
				if(temp%10==7){
					count++;
					break;
				}
				temp=temp/10;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNext()){
			int n=scanner.nextInt();
			System.out.println(getSeven(n));
		}
		scanner.close();
	}

}
