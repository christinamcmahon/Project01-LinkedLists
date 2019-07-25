package tests;

import lists.ArrayList;
import utility.List;

public class ListIntClient {
	public static void main(String[] args) {
		// Step 1
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(4);
		list.add(5);
		list.add(8);
		list.add(9);
		list.add(11);
		list.add(13);
		list.add(15);
		list.add(18);
		list.add(20);
		
		// Step 2
		System.out.println(list);
		
		// Step 3
		System.out.println(average(list));
		
		// Step 4
		System.out.println(even(list));
		
		// Step 5
		revise(list);
		System.out.println(list);
		
		// Step 6
		removal(list);
		System.out.println(list);
		
		// Step 7
		reverse(list);
		System.out.println(list);
	}
	
	/*************************************************************
	 * find the average of the elements in the list
	 * @param list 	list of integers
	 * @return average of the elements
	 *************************************************************/
	public static double average(List<Integer> list) {
		int size = list.size();
		double total = 0;
		for(int i = 0; i < size; i++) {
			total += list.get(i);
		}
		return total/size;
	}
	
	/*************************************************************
	 * return a list of the even numbers in the list
	 * @param list 	list of integers
	 * @return list of even numbers
	 *************************************************************/
	public static List<Integer> even(List<Integer> list) {
		List<Integer> temp = new ArrayList<Integer>();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) % 2 == 0) {
				temp.add(list.get(i));
			}
		}
		return temp;
	}
	
	/*************************************************************
	 * add the current element at each odd index position to the 
	 * end of the list, then update the value at the current odd
	 * position to 3
	 * @param list 	list of integers
	 *************************************************************/
	public static void revise(List<Integer> list) {
		for(int i = 1; i < list.size(); i += 2) {
			list.add(list.get(i));
			list.set(i,  3);
		}
	}
	
	/*************************************************************
	 * remove all elements equal to 3 from the list
	 * @param list 	list of integers
	 *************************************************************/
	public static void removal(List<Integer> list) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) == 3) {
				list.remove(i);
				i--;
			}
		}
	}
	
	/*************************************************************
	 * reverse the order of the elements in the list
	 * @param list 	list of integers
	 *************************************************************/
	public static void reverse(List<Integer> list) {
		int size = list.size();
		for(int i = 0; i < size; i++) {
			int temp = list.get(i);
			list.set(i,  list.get(size - 1 - i));
			list.set(size - 1 - i,  temp);
		}
	}
}
