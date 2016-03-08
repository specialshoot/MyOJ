package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

	/**
	 * 是否可以进行拓扑排序
	 * 
	 * @param numCourses
	 *            元素个数
	 * @param prerequisites
	 *            关系数组 prerequistes是个二维数组，比如一个元素是{0,1}代表0--->1的路径，即0到1的有向图路径
	 * @return
	 */
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] map = new int[numCourses]; // 代表元素的入度数组

		for (int i = 0; i < prerequisites.length; i++) {
			map[prerequisites[i][1]]++; // 后面元素入度+1
		}

		Queue<Integer> que = new LinkedList<Integer>();

		for (int i = 0; i < map.length; i++) {
			if (map[i] == 0)
				que.add(i); // 入度为0的元素加入到队列中
		}

		int count = que.size();
		while (!que.isEmpty()) {
			int k = que.remove(); // 队列中取出第一个元素并移除
			for (int i = 0; i < prerequisites.length; i++) { // 遍历此节点是否有指向的节点
				if (k == prerequisites[i][0]) {
					int l = prerequisites[i][1];
					map[l]--; // 指向的节点度数-1
					if (map[l] == 0) { // 如果度数为0,则加入队列中,计数+1
						que.add(l);
						++count;
					}
				}
			}
		}
		return count == numCourses; // 如果最后count的数字等于元素个数，说明全部遍历完成没有闭环，返回true，否则返回false
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int countNum = 6;
		int[][] prerequisites = { { 0, 2 }, { 1, 2 }, { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 5 }, { 3, 5 }, { 4, 5 } };
		System.out.println(canFinish(countNum, prerequisites));
	}

}
