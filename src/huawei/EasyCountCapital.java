package huawei;

import java.util.Scanner;

public class EasyCountCapital {

	public static int count(String str){
		if(str.isEmpty()){
			return 0;
		}
		int count=0;
		int len=str.length();
		for(int i=0;i<len;i++){
			if(str.charAt(i)>=65 && str.charAt(i)<=90){
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println(count(scanner.nextLine()));
		scanner.close();
	}

}
