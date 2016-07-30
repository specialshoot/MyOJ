package huawei;
/**
 * 计算最少出列多少位同学，使得剩下的同学排成合唱队形
 * 说明：
 * N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。 
 * 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，   则他们的身高满足存在i（1<=i<=K）使得Ti<T2<......<Ti-1<Ti>Ti+1>......>TK。 
 *  你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。 
 *  
 *  知识点	循环
 *  运行时间限制	0M
 *  内存限制	0
 *  
 *  输入
 *  整数N
 *  一行整数，空格隔开，N位同学身高
 *  
 *  输出	
 *  最少需要几位同学出列
 *  
 *  样例输入	8 186 186 150 200 160 130 197 200
 *  样例输出	4
 */
import java.util.Scanner;

public class EasySing {

	public static int getSingNum(int[] nums, int n) {

		int[] f1 = new int[n];// 存放合唱队人数(从左到右)
		int[] f2 = new int[n];// 存放合唱队人数(从右到左)

		for (int i = 0; i < n; i++) {// 从左向右遍历
			f1[i] = 1;// 至少有一个人符合条件，就是自己
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && f1[i] < f1[j] + 1) {
					f1[i] = f1[j] + 1;
				}
			}
		}
		
		for (int i = n - 1; i >= 0; i--) {// 由右向左依次遍历
			f2[i] = 1;// 至少有一个人符合条件，就是他自己。所以赋初值1.
			for (int j = i + 1; j < n; j++) {
				if (nums[i] > nums[j] && f2[i] < f2[j] + 1)
					f2[i] = f2[j] + 1;
			}
		}
		
		int res=0;
		for(int i=0;i<n;i++){
			if(res<f1[i]+f2[i]-1){
				res=f1[i]+f2[i]-1;
			}
		}
		return n-res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int[] nums = new int[n];
			if (n == 0) {
				System.out.println("0");
				continue;
			}
			for (int i = 0; i < n; i++) {
				nums[i] = scanner.nextInt();
			}
			System.out.println(getSingNum(nums, n)+"");
		}
	}

}
