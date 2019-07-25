package tests;

import lists.LinkedList;

public class LinkedListClient {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.add("Bill");
		System.out.println(list);
	}
}
