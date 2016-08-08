package huawei;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * http://blog.csdn.net/DERRANTCM/article/details/51473644
 * http://career-oj.huawei.com/exam/ShowProblemInfo?method=campusProblemInfo&id=
 * 2033 后缀表达式
 * 
 * @author han
 *
 */
public class Easy24Point {

	private static boolean get24point(int a, int b, int c, int d) {
		int arr[] = { a, b, c, d, '+', '-', '*', '/' };
		boolean[] used = new boolean[arr.length];// 是否已经使用
		LinkedList<Integer> list = new LinkedList<>();

		boolean[] rst = { false };// 是否找到24点，用数组形式因为下面有函数要传参，如果不是数组传的是实参，跳出函数不会改变

		// 构造后缀表达式
		for (int i = 0; i < 4; i++) {
			used[i] = true;
			list.add(arr[i]);
			to24(arr, used, 1, 0, list, rst);
			if (rst[0]) {
				return true;// 找到24点
			}
			// 还原现场
			list.removeLast();
			used[i] = false;
		}

		return false;
	}

	/**
	 * 
	 * @param arr
	 *            数字加操作符数组
	 * @param used
	 *            是否已经使用记录数组
	 * @param numCnt
	 *            操作数的个数
	 * @param optCnt
	 *            操作符的个数
	 * @param list
	 *            求得的后缀表达式
	 * @param rst
	 *            中间保留的结果
	 */
	private static void to24(int[] arr, boolean[] used, int numCnt, int optCnt, LinkedList<Integer> list,
			boolean[] rst) {
		if (rst[0]) {
			return;
		}
		if (numCnt > optCnt && numCnt + optCnt == 7) {
			// 操作数个数超过操作符个数且总数>7说明完成了后缀表达式
			// 反解
			calInversePoland(list, rst);
		} else if (numCnt > optCnt) {
			// 没有完成后缀表达式，继续构造后缀表达式
			for (int i = 0; i < arr.length; i++) {
				if (!used[i] || arr[i] < 0 || arr[i] > 10) {
					// 如果arr[i]还没有被使用或者arr[i]是运算符
					if (arr[i] >= 0 && arr[i] <= 10) {// 如果是数字
						list.add(arr[i]);
						numCnt++;
						used[i] = true;

						to24(arr, used, numCnt, optCnt, list, rst);
						if (rst[0]) {
							return;// 找到一个答案就返回
						}

						list.removeLast();
						numCnt--;
						used[i] = false;
					} else if (numCnt + 1 > optCnt) {// 如果是操作符
						list.add(arr[i]);
						optCnt++;
						used[i] = true;

						to24(arr, used, numCnt, optCnt, list, rst);
						if (rst[0]) {
							return;// 找到一个答案就返回
						}

						list.removeLast();
						optCnt--;
						used[i] = false;
					}
				}
			}
		}
	}

	/**
	 * 计算后缀表达式
	 * 
	 * @param list
	 * @param rst
	 */
	private static void calInversePoland(LinkedList<Integer> list, boolean[] rst) {
		LinkedList<Double> stack = new LinkedList<>();
		for (int v : list) {
			// 如果是数字
			if (v >= 0 && v <= 10) {
				stack.add((double) v);
			} else {
				double a = stack.removeLast();
				double b = stack.removeLast();
				double c = 0;
				switch ((char) v) {
				case '+':
					c = a + b;
					break;
				case '-':
					c = a - b;
					break;
				case '*':
					c = a * b;
					break;
				case '/':
					// 除数不能为0
					if (a == 0) {
						return;
					}
					c = b / a;
					break;
				}

				stack.add(c);
			}
		}
		rst[0] = stack.getFirst() == 24.0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			int d = scanner.nextInt();
			System.out.println(get24point(a, b, c, d));
		}
		scanner.close();
	}

}
