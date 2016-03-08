package leetcode;

public class CompareStrings {
	
	//http://www.lintcode.com/en/problem/compare-strings/
	//lintcode
	//此题为TwoStringsAreAnagrams的变形
	
	public static boolean compareStrings(String A, String B) {
		// write your code here
		if (A.length()<B.length()) {
			return false;
		}
		
		int[] letterCount = new int[26];	//26个字母
		for (int i = 0; i < letterCount.length; i++) {
			letterCount[i] = 0;
		}
		for (int i = 0; i < A.length(); ++i) {
			++letterCount[(int) (A.charAt(i)-'A')];
		}
		
		for (int i = 0; i < B.length(); ++i) {
			--letterCount[(int) (B.charAt(i)-'A')];
			if(letterCount[(int) (B.charAt(i)-'A')]<0){
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "AABC";
		String b = "ABBC";
		System.out.println(compareStrings(a, b));
	}

}
