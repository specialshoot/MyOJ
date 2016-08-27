package NetEase;

import java.util.Scanner;

public class MixPaint {

	private static int getPaint(int[] colors, int n) {
		int res = 0;
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String[] strs=scanner.nextLine().split("\\s+");
			int countNegative=0;
			int countPositive=0;
			int sum=0;
			for(int i=0;i<strs.length;i++){
				if (Integer.parseInt(strs[i])<0) {
					countNegative++;
				}else{
					countPositive++;
					sum+=Integer.parseInt(strs[i]);
				}
			}
			System.out.println(countNegative+" "+(double)sum/countPositive);
		}
		scanner.close();
	}

}
