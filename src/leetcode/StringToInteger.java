package leetcode;

public class StringToInteger {

	//https://leetcode.com/problems/string-to-integer-atoi/
	public static int myAtoi(String str) {
		if(str==null){
	        return 0;
	    }
	    str = str.trim();
	    if(str.length()==0){
	        return 0;
	    }
	    boolean isNeg = false;
	    int i = 0;
	    if(str.charAt(0)=='-' || str.charAt(0)=='+'){
	        i++;
	        if(str.charAt(0)=='-')
	            isNeg = true;
	    }
	    int res = 0;
	    while(i<str.length()){
	    	if(str.charAt(i)<'0' || str.charAt(i)>'9' || str.charAt(i)=='.'){
	    		break;
	    	}
	        int digit = (int)(str.charAt(i)-'0');
	        if(isNeg && res>-((Integer.MIN_VALUE+digit)/10))
	            return Integer.MIN_VALUE;
	        else if(!isNeg && res>(Integer.MAX_VALUE-digit)/10)
	            return Integer.MAX_VALUE;
	        res = res*10+digit;
	        i++;
	    }
	    return isNeg?-res:res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="+123.456";
		System.out.println(myAtoi(str));
	}

}
