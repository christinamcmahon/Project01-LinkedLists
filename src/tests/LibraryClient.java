package tests;

import java.util.ArrayList;
import java.util.List;

public class LibraryClient {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Robert");
		list.add("Thomas");
		list.add(0, "Henry");
		list.add(9, "Augustus");
		list.add("Albert");
		list.add("Gilbert");
		list.add(5, "Willow");
		list.add(5, "Wilbert");
		list.add(0, "Cornelius");
		list.add(8, "Augustus");
		System.out.println(list);
	}
}
