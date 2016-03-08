package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PeekingIterator implements Iterator<Integer> {

	// https://leetcode.com/problems/peeking-iterator/

	private Iterator<Integer> iterator;
	private boolean flag = false; // 是否已经peek过
	private Integer item;

	public PeekingIterator(Iterator<Integer> iterator) {
		this.iterator = iterator;
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			list.add(i);
		}
		Iterator<Integer> it = list.iterator();
		PeekingIterator pi = new PeekingIterator(it);
		while (pi.hasNext()) {
			System.out.println(pi.peek() + "");
			System.out.println(pi.next() + "");
		}
	}

	/**
	 * Returns the next element in the iteration without advancing the iterator.
	 * 
	 * @return
	 */
	public Integer peek() {
		if (flag == false) {
			Integer it = iterator.next();
			flag = true;
			item = it;
			return item;
		}
		return item;
	}

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		if (flag) {
			flag = false;
			return item;
		} else {
			return iterator.next();
		}
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return flag || iterator.hasNext();
	}

	@Override
	public void remove() {
		iterator.remove();
	}

}
