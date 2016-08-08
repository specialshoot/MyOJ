package leetcode;

public class ContainerWithMostWater {

	// https://leetcode.com/problems/container-with-most-water/
	/***
	 * 穷举法,最简单最差的方法,time limited
	 * 
	 * @param height
	 * @return
	 */
	public static int maxArea1(int[] height) {
		int max = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				int temp = (j - i) * (height[i] > height[j] ? height[j] : height[i]);
				if (temp > max) {
					max = temp;
					continue;
				}
			}
		}
		return max;
	}

	/**
	 * 线性复杂度 有两个指针i和j分别指向头和尾， 如果a[i]<a[j], 则i++,否则j--: 证明： 对任意ｋ<j：
	 * 都有(k-i)*min(a[k],a[i]) < (j-i)min(a[j],a[i]) = (j-i)a[i] 因为： (k-i) <
	 * (j-i) min(a[k],a[i]) < a[i] < min(a[j],a[i]) 所以此种情况移动j只能得到更小的值， 移动j无用，
	 * 只能移动i。 反之亦然。
	 * 
	 * @param height
	 * @return
	 */
	public static int maxArea2(int[] height) {
		int max = 0;
		int length = height.length;
		int i = 0, j = length - 1;
		while (i < j) {
			int temp = (j - i) * (height[i] < height[j] ? height[i] : height[j]);
			if (height[i] < height[j]) {
				i++;
			} else {
				j--;
			}
			if (temp > max) {
				max = temp;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
