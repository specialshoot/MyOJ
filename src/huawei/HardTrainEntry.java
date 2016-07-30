package huawei;
/**
 * 未完成！！！！！！
 */
/**
 * 描述	
 * 给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号。要求以字典序排序输出火车出站的序列号。
 * 知识点	栈
 * 运行时间限制	0M
 * 内存限制	0
 * 
 * 输入
 * 有多组测试用例，每一组第一行输入一个正整数N（0<N<10），第二行包括N个正整数，范围为1到9。
 * 
 * 输出
 * 输出以字典序排序的火车出站序列号，每个编号以空格隔开，每个输出序列换行，具体见sample。
 * 
 * 样例输入	
 * 3
 * 1 2 3
 * 样例输出
 * 1 2 3
 * 1 3 2
 * 2 1 3
 * 2 3 1
 * 3 2 1
 */
import java.util.Scanner;
import java.util.Stack;

public class HardTrainEntry {

	private static boolean isRight(int in[], int out[], int n) {
		boolean ret = true;
		Stack<Integer> sta = new Stack<>();
		int index_out = 0, index_in = 0;

		while (index_out < n) {
			while (index_in < n) {
				if (sta.empty()) {
					sta.push(in[index_in]);
					index_in++;
				} else if (sta.firstElement() != out[index_out]) {
					sta.push(in[index_in]);
					index_in++;
				} else {
					break;
				}
			}

			if (sta.firstElement() == out[index_out]) {
				sta.pop();
				index_out++;
			} else {
				break;
			}
		}
		if (sta.empty()) {
			ret = true;
		} else {
			ret = false;
		}
		return ret;
	}

	/**
	 * 全排列
	 * 
	 * @param nums
	 * @param k
	 * @param m
	 */
	private static void range(int[] nums, int k, int m) {
		int[] temp = nums;
		if (k == m) {
			String res = "";
			for (int i = 0; i < temp.length; i++) {
				if (isRight(nums, temp, temp.length)) {
					res = res + temp[i] + " ";
				}
			}
			System.out.println(res.trim());
		} else {
			for (int i = k; i <= m; i++) {
				if (isSwap(temp, k, i)) {
					Swap(temp, k, i);
					range(temp, k + 1, m);
					Swap(temp, k, i);
				}
			}
		}
	}

	private static boolean isSwap(int[] nums, int begin, int end) {
		for (int i = begin; i < end; i++) {
			if (nums[i] == nums[end]) {
				return false;
			}
		}
		return true;
	}

	private static void Swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = scanner.nextInt();
			}
			range(nums, 0, 2);
		}
	}

}
