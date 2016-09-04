package others;

import java.util.Scanner;

public class Main {
	
	public static int getRes(int n){
		int price=1;
		int i=3,j=3;
		for(int m=2;m<=n;++m){
			if(m==i){
				i=i+j;
				j++;
				--price;
			}else{
				++price;
			}
		}
		return price;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n=scanner.nextInt();
			System.out.println(getRes(n));
		}
		scanner.close();
	}

}
