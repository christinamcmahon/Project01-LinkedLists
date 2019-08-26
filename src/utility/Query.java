package utility;

import hospital.Patient;
import utility.Comparator;

public class Query {
	
	/*************************************************************
	 * searches for a particular record in a list using binary 
	 * search algorithm
	 * @param list 		list being searched
	 * @param key 		item being search for
	 * @return index of matching item or -1 if not found
	 *************************************************************/
	public static <T extends Comparable<T>> int binarySearch(List<T> list, T key) {
		int min = 0;
		int max = list.size() - 1;
		int mid;
		while(min <= max) {
			mid = (min + max) / 2;
			if(list.get(mid).compareTo(key) == 0) {
				return mid;
			} else if(list.get(mid).compareTo(key) < 0) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}
		return -1;
	}

	/*************************************************************
	 * search for a name in a list and return its index
	 * @param list 		list being searched
	 * @param key 		name being searched for
	 * @return index of matching name
	 *************************************************************/
	public static int indexOf(List<Patient> list, String key) {
		int found = -1;
		for(int i = 0; i < list.size() && found == -1; i++) {
			if(list.get(i).getName().equals(key)) {
				found = i;
			}
		}
		return found;
	}

	/*************************************************************
	 * partition method for quick sort algorithm
	 * @param list 		list being partitioned
	 * @param left 		left partition
	 * @param right		right partition
	 * @return index of the pivot 
	 *************************************************************/
	public static <T extends Comparable<T>> int partition(List<T> list, int left, int right) {
		int midpoint = left + right / 2;
		T pivot = list.get(midpoint);

		int low = left;
		int high = right;
		boolean done = false;

		while (!done) {
			while (list.get(low).compareTo(pivot) < 0) {
				++low;
			}
			while (list.get(high).compareTo(pivot) > 0) {
				--high;
			}
			if (low >= high) {
				done = true;
			} else {
				T temp = list.get(low);
				list.set(low, list.get(high));
				list.set(high,  temp);
				++low;
				--high;
			}
		}
		return high;
	}

	/*************************************************************
	 * sorts patient records using the quick sort algorithm
	 * @param list		list being sorted
	 * @param left 		left partition
	 * @param right 	right partition
	 *************************************************************/
	public static <T extends Comparable<T>> void quickSort(List<T> list, int left, int right) {
		int pivot;
		// Base case: already sorted
		if (left >= right) {
			return;
		}
		pivot = partition(list, left, right);
		// Recursive case
		quickSort(list, left, pivot);
		quickSort(list, pivot + 1, right);
	}

	/*************************************************************
	 * sorts patient records using the selection sort algorithm
	 * @param list 		list being sorted
	 * @param key		a comparator key with generic type
	 *************************************************************/
	public static <T> void selectionSort(List<T> list, Comparator<T> key) {
		int j;
		int indexSmallest;
		T temp;      
		for (int i = 0; i < list.size() - 1; ++i) {
			indexSmallest = i;
			for (j = i + 1; j < list.size(); ++j) {

				if (key.compare(list.get(j), list.get(indexSmallest)) < 0) {
					indexSmallest = j;
				}
			}
			temp = list.get(i);
			list.set(i, list.get(indexSmallest));
			list.set(indexSmallest, temp);
		}
	}
}
