package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

	//https://leetcode.com/problems/implement-stack-using-queues/
	LinkedList<Integer> queue=new LinkedList<>();
	LinkedList<Integer> temp=new LinkedList<>();
	// Push element x onto stack.
	/**
	 * 放到队头
	 * @param x
	 */
	public void push(int x) {
		while(!queue.isEmpty()){
			temp.offer(queue.poll());
		}
		queue.offer(x);
		while(!temp.isEmpty()){
			queue.offer(temp.poll());
		}
	}

	// Removes the element on top of the stack.
	public void pop() {
		queue.poll();
	}

	// Get the top element.
	public int top() {
		return queue.peek();
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return queue.isEmpty();
	}
}
