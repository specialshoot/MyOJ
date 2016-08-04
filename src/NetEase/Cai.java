package NetEase;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Cai {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		Set<String> sets=new HashSet<>();
		while(scanner.hasNext()){
			String res=scanner.nextLine();
			if(res==null || res.equals("")|| res.equals("EOF")){
				break;
			}
			String[] temp=res.split(" ");
			for(int i=0;i<temp.length;i++){
				sets.add(temp[i]);
			}
		}
		System.out.println(sets.size());
		scanner.close();
	}

}
