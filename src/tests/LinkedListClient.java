package tests;

import lists.LinkedList;

public class LinkedListClient {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.add(0,"Augustus");
		list.add(1,	"Balbinus");
		list.add(2,	"Cresus");
		list.add(3, "Commodus");
		list.add(4, "Julius");
		list.add(5, "Septimius");
		list.add(6, "Tiberius");
		list.add(7, "Valerian");
		System.out.println(list);
		System.out.println(list.getNode(7));
		System.out.println(list.getPrevNode(0));
		System.out.println(list.getNode(0));
		System.out.println(list.indexOf("Valerian"));
	}
}
