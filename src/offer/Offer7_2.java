package offer;

import java.util.LinkedList;

/**
 * 两个队列实现栈
 * 
 * @author han
 *
 */
public class Offer7_2 {

	public static class MyStack {
		private LinkedList<String> queue1;
		private LinkedList<String> queue2;

		public MyStack() {
			queue1 = new LinkedList<String>();
			queue2 = new LinkedList<String>();
		}

		public void push(String node) {
			if (queue1.isEmpty() && queue2.isEmpty()) {
				queue1.addLast(node);
			} else if (!queue1.isEmpty()) {
				queue1.addLast(node);
			} else {
				queue2.addLast(node);
			}
		}

		public String pop() {
			if (queue1.isEmpty() && queue2.isEmpty()) {
				return null;
			}
			String re = null;
			if (queue2.isEmpty()) {
				while (!queue1.isEmpty()) {
					re = queue1.removeFirst();
					if (!queue1.isEmpty()) {// 若为空,则上一步removeFirst的元素是最后一个,不需要添加到队列中
						queue2.addLast(re);
					}
				}
			} else if (queue1.isEmpty()) {
				while (!queue2.isEmpty()) {
					re = queue2.removeFirst();
					if (!queue2.isEmpty()) {// 若为空,则上一步removeFirst的元素是最后一个,不需要添加到队列中
						queue1.addLast(re);
					}
				}
			}
			return re;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack stack = new MyStack();
		String tmp;
		stack.push("1");
		stack.push("2");
		tmp = stack.pop();
		System.out.println(tmp);// 3
		tmp = stack.pop();
		System.out.println(tmp);// 3
		tmp = stack.pop();
		System.out.println(tmp);// 3
	}

}
