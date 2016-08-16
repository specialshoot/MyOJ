package huawei;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

import org.omg.CORBA.PRIVATE_MEMBER;

import offer.BinaryTreeNode;

/**
 * Author: 王俊超 Date: 2015-12-24 17:18 All Rights Reserved !!!
 */
public class Candelete {
	public static void findPath(Stack<Integer> nodes) {
		nodes.add(2);
	}
	public static void main(String[] args) {

		Stack<Integer> nodes=new Stack<>();
		nodes.add(1);
		findPath(nodes);
		System.out.println(nodes.pop());
	}
}