package offer;

import java.util.ArrayList;
import java.util.List;

public class Offer45 {

	public static void lastRemaining(int total, int index) {
		List<Integer> start = new ArrayList<>();// 初始化人数
		for (int i = 0; i < total; i++) {
			start.add(i);
		}
		int k = 0;// 从第k个开始计数
		while (start.size() > 1) {
			k = (k + index) % start.size() - 1;// 要删除的编号
			// 判断是否到队尾
			if (k < 0) {// 到达队尾要移除最后一个元素
				System.out.println("k < 0 : " + k + " ; " + start.get(start.size() - 1));
				start.remove(start.size() - 1);
				k = 0;
			} else {
				System.out.println("k >= 0 : " + k + " ; " + start.get(k));
				start.remove(k);
			}
		}
		System.out.println(start.get(0));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lastRemaining(5, 5);
	}

}
