package offer;

import java.util.Stack;

/**
 * 栈的压入弹出序列
 * 
 * @author han
 *
 */
public class Offer22 {

	/**
	 * 
	 * @param pPush
	 *            入栈顺序
	 * @param pPop
	 *            需要检测的出栈顺序
	 * @return
	 */
	public static boolean check(int[] pPush, int[] pPop) {
		boolean isPossible = false;
		if (pPush != null && pPop != null) {
			Stack<Integer> stack = new Stack<>();
			int i = 0, j = 0;
			// 检查每个出栈
			while (j < pPop.length) {
				while (i < pPush.length && pPop[j] != pPush[i]) {// 不相同时进栈
					stack.push(pPush[i]);
					i++;
				}
				// 相等的元素没有进栈
				++i;
				++j;
				int top = 0;
				// 出栈比较
				while (!stack.isEmpty() && (top = stack.pop()) == pPop[j]) {
					++j;
				}
				if (i >= pPush.length && !stack.isEmpty()) {// 找不到进栈元素
					break;
				}
			}
			if (stack.isEmpty()) {
				isPossible = true;
			}
		}
		return isPossible;
	}

	public static boolean check2(int[] pPush, int[] pPop) {
		boolean isPossible = false;
		int i = 0, j = 0, tempIndex = 0;
		int[] temp = new int[100];
		for (i = 0; i < pPush.length; i++) {
			temp[tempIndex++] = pPush[i];
			while (tempIndex > 0 && pPop[j] == temp[tempIndex - 1]) {
				tempIndex--;
				j++;
			}
		}
		if (tempIndex == 0) {
			isPossible = true;
		} else {
			isPossible = false;
		}
		return isPossible;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 进栈序列
		int[] pPush = { 1, 2, 3, 4, 5 };
		// 出栈序列
		// int[] pPop = { 3, 1, 2, 5, 4 };
		int[] pPop = { 4, 3, 5, 2, 1 };
		boolean flag = check2(pPush, pPop);
		System.out.println(flag);
	}

}
