package others;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 进程调度算法 短作业优先（SJF, Shortest Job First）又称为“短进程优先”SPN(Shortest Process
 * Next)；是对FCFS算法的改进，其目标是减少平均周转时间。 短作业优先调度算法基于这样一种思想： 运行时间短的优先调度；
 * 如果运行时间相同则调度最先发起请求的进程。 PS:本题题面描述有误，但原题如此，不宜修改，实际优先级如下: 1)接到任务的时间； 2)
 * 如果接收时间相同则调度 运行时间最短的任务。 等待时间：一个进程从发起请求到开始执行的时间间隔。
 * 现在有n个进程请求cpu，每个进程用一个二元组表示：(p,q),p代表该进程发起请求的时间，p代表需要占用cpu的时间。 请计算n个进程的平均等待时间。
 * 
 * 
 * 输入描述:
 * 
 * 
 * 输入包含多组测试数据。
 * 
 * 对于每组测试数据，第一行为一个整数n。
 * 
 * 然后有n行，每行两个整数，代表上述的二元组(p,q).
 * 
 * 保证:
 * 
 * 2<=n<=2000,1<=p<=300,1<=q<=100.
 * 
 * 
 * 
 * 
 * 输出描述:
 * 
 * 对于每组数据，输出一个浮点数，代表平均等待时间，请保留4位有效数字
 * 
 * 输入例子:
 * 
 * 4
 * 
 * 1 4
 * 
 * 1 3
 * 
 * 1 5
 * 
 * 2 1
 * 
 * 
 * 输出例子:
 * 
 * 5.2500
 * 
 * @author han
 *
 */
public class BaiDuJinChengDiaoDu {

	public static class Process {
		public int time;
		public int runtime;

		public Process(int time, int runtime) {
			super();
			this.time = time;
			this.runtime = runtime;
		}

		public int getTime() {
			return time;
		}

		public void setTime(int time) {
			this.time = time;
		}

		public int getRuntime() {
			return runtime;
		}

		public void setRuntime(int runtime) {
			this.runtime = runtime;
		}
	}

	public static Comparator<Process> cmp = new Comparator<Process>() {

		@Override
		public int compare(Process o1, Process o2) {
			// TODO Auto-generated method stub
			if (o1.time < o2.time) {
				return -1;
			}
			if (o1.time > o2.time) {
				return 1;
			}
			if (o1.runtime < o2.runtime) {
				return -1;
			}
			if (o1.runtime > o2.runtime) {
				return 1;
			}
			return 0;
		}
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			Process[] nums = new Process[n];
			for (int i = 0; i < n; i++) {
				nums[i] = new Process(scanner.nextInt(), scanner.nextInt());
			}
			Arrays.sort(nums, cmp);
			int count = nums[0].getTime() + nums[0].getRuntime();
			int waittime = 0;
			for (int i = 1; i < nums.length; i++) {
				if (count >= nums[i].getTime()) {
					waittime += count - nums[i].getTime();
					count += nums[i].getRuntime();
				} else {
					count = nums[i].getTime() + nums[i].getRuntime();
				}
			}
			String result = String.format("%.4f", (double) waittime / n);
			System.out.println(result);
		}
		scanner.close();
	}

}
