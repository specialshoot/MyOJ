package huawei;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;

public class EasyEncrypt {
	
	private static String[] dict={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	
	private static String encrypt(String key,String str){
		String result="";
		int len1=key.length();
		int len2=str.length();
		LinkedHashSet<String> set=new LinkedHashSet<>();
		for(int i=0;i<len1;i++){
			set.add(key.substring(i,i+1));
		}
		for(int i=0;i<26;i++){
			set.add(dict[i]);
		}
		Iterator it=set.iterator();
		Map<String, String> map=new HashMap<>();
		int count=0;
		while(it.hasNext()){
			map.put(dict[count], it.next()+"");
			count++;
		}
		for(int i=0;i<len2;i++){
			result+=map.get(str.substring(i,i+1));
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNext()){
			String key=scanner.next();
			String str=scanner.next();
			System.out.println(encrypt(key, str));
		}
	}

}
