package offer;

/**
 * 包含min函数的栈
 * 
 * http://blog.csdn.net/jsqfengbao/article/details/47260355
 * 
 * @author han
 *
 */
public class Offer21 {

	public static class ListNode<K> {
		K data;
		ListNode<K> nextNode;
	}

	public static class MyStack<K> {
		public ListNode<K> head;
		public int length;

		public void push(K item) {
			ListNode<K> node = new ListNode<>();
			node.data = item;
			node.nextNode = head;
			head = node;
			length++;
		}

		public K pop() {
			if (head == null) {
				return null;
			}
			ListNode<K> temp = head;
			head = temp.nextNode;
			length--;
			return temp.data;
		}
	}

	private static MyStack<Integer> minStack = new MyStack<>();// 用于存每次加入值最小值的stack
	private static MyStack<Integer> dataStack = new MyStack<>();// 用于存加入数据的stack

	public static void push(Integer item) {
		dataStack.push(item);
		if (minStack.length == 0 || item <= minStack.head.data) {
			minStack.push(item);
		} else {
			minStack.push(minStack.head.data);
		}
	}

	public static Integer pop() {
		if (dataStack.length == 0 || minStack.length == 0) {
			return null;
		}
		minStack.pop();
		return dataStack.pop();
	}

	public static Integer min() {
		if (minStack.length == 0) {
			return null;
		}
		return minStack.head.data;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		push(3);
		push(2);
		push(1);
		System.out.println(pop());
		System.out.println(min());
	}

}
