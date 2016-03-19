package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MyQueue {
	Stack<Integer> stack = new Stack<Integer>();
	List<Integer> list=new ArrayList<Integer>();

	public void push(int x) {
		stack.push(x);
		list.add(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		stack.remove(list.get(0));
		list.remove(0);
	}

	// Get the front element.
	public int peek() {
		return list.get(0);
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return stack.isEmpty();
	}
}
