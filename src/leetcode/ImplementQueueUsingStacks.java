package leetcode;

import java.awt.ImageCapabilities;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.security.auth.x500.X500Principal;

public class ImplementQueueUsingStacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue queue = new MyQueue();
		queue.push(4);
		queue.push(5);
		System.out.println(queue.peek());
		System.out.println(queue.empty());
		queue.pop();
		System.out.println(queue.peek());
		queue.pop();
		System.out.println(queue.empty());
	}
}
