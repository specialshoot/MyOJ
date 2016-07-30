package huawei;

import java.util.Scanner;

public class EasyLongestSubString {

	private static int getCommonStrLength(char[] pFirstStr, char[] pSecondStr){
		char[] charA = pFirstStr;
		char[] charB = pSecondStr;
		int lenA = charA.length;
		int lenB = charB.length;
		if(lenA==0 || lenB==0){
			return 0;
		}
		int[][] status = new int[lenA + 1][lenB + 1];
		String res="";
		int max = -1;
		int x=0;//最长字符串的节点
		int y=0;

		for (int i = 1; i <= lenA; i++) {
			for (int j = 1; j <= lenB; j++) {
				if (charA[i - 1] == charB[j - 1]) {
					status[i][j] = status[i - 1][j - 1] + 1;
				} else{
					status[i][j]=0;
				}
				if(status[i][j]>max)  
	            {  
	                max=status[i][j];//记录最长的状态
	                x=i;
	                y=j;
	            }
			}
		}
		
		int i=x-1;
		int j=y-1;
		int count=0;
		while(i>=0 && j>=0){
			if(charA[i]==charB[j]){
				count++;
				i--;
				j--;
			}else{
				break;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String[] strings = scanner.nextLine().split(" ");
			char[] stringA = strings[0].trim().toUpperCase().toCharArray();
			char[] stringB = strings[1].trim().toUpperCase().toCharArray();
			System.out.println(getCommonStrLength(stringA, stringB));
		}
		scanner.close();
	}

}
