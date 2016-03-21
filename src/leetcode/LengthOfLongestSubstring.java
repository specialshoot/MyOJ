package leetcode;

public class LengthOfLongestSubstring {

	//https://leetcode.com/problems/longest-substring-without-repeating-characters/
	public static int lengthOfLongestSubstring(String s){
		
		String str=s;
		int max=0,start=0;
		boolean[] exist=new boolean[128];	//ascii码表中字符是否出现过
		int[] position=new int[128];	//ascii码表中每个字符出现的次数
		
		//初始化
		for(int i=0;i<128;i++){
			exist[i]=false;
			position[i]=0;
		}
	
		for(int i=0;i<str.length();i++){
			if(exist[ (int)(str.substring(i,i+1).getBytes()[0]) ]){
				//如果字母出现过,start移动到之前的那个字母出现的位置的后一位,end向后移动一位
				for(int j=start;j<=position[str.substring(i,i+1).getBytes()[0]];j++){
					exist[str.substring(j,j+1).getBytes()[0]]=false;
				}
				start=position[str.substring(i,i+1).getBytes()[0]]+1;
				exist[str.substring(i,i+1).getBytes()[0]]=true;
				position[str.substring(i,i+1).getBytes()[0]]=i;
			}else{
				//没有出现过,end向后移动一位
				exist[str.substring(i,i+1).getBytes()[0]]=true;
				position[str.substring(i,i+1).getBytes()[0]]=i;
				max=max>(i-start+1)?max:(i-start+1);
			}
		}
		return max;
	}
	
	public static void main(String agrs[]){
		String string="12312341235";
		System.out.println( lengthOfLongestSubstring(string)+"");
	}
}
