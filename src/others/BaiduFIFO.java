package others;

import java.util.LinkedList;
import java.util.Scanner;

public class BaiduFIFO {

	public static void getAnswer(int[] pagenum, int n, int cache) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int count=0;
		for(int i=0;i<n;i++){
			if(queue.contains(pagenum[i])){
				continue;
			}
			if(queue.size()<cache){
				queue.offerLast(pagenum[i]);
			}else{
				queue.removeFirst();
				queue.offerLast(pagenum[i]);
			}
			count++;
		}
		System.out.println(count);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int cache = scanner.nextInt();
			int n = scanner.nextInt();
			int[] pagenum = new int[n];
			for (int i = 0; i < n; i++) {
				pagenum[i] = scanner.nextInt();
			}
			getAnswer(pagenum, n, cache);
		}
		scanner.close();
	}

}
