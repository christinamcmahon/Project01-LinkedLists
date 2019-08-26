package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import lists.ArrayList;
import lists.LinkedList;
import utility.Iterator;

class IteratorTest {
	
	@Test
	void testArrayIterator() {
		ArrayList<String> list = new ArrayList<String>();
		System.out.println("-------------- Test ArrayList Iterator() --------------");
		list.add(0,"Augustus");
		list.add(1,	"Balbinus");
		list.add(2,	"Cresus");
		list.add(3, "Commodus");
		list.add(4, "Julius");
		list.add(5, "Septimius");
		list.add(6, "Valerian");
		System.out.println(list);
		
		String name1 = "Tiberius";
		String name2 = "Valerian";
		
		if (!list.contains(name1)) {
			list.add(6, name1);
		}
		
		assertEquals(name1, list.get(6));
		assertEquals(name2, list.get(7));
		System.out.println(list);
		System.out.println();
		
		Iterator<String> itr = list.iterator();
		assertEquals("Augustus" ,  itr.next());
		assertEquals("Balbinus" ,  itr.next());
		assertEquals("Cresus"   ,  itr.next());
		assertEquals("Commodus" ,  itr.next());
		assertEquals("Julius"   ,  itr.next());
		assertEquals("Septimius",  itr.next());
		assertEquals("Tiberius" ,  itr.next());
		assertEquals("Valerian" ,  itr.next());
		
	}
	
	@Test
	void testAIteratorLoop() {
		ArrayList<String> list = new ArrayList<String>();
		System.out.println("-------------- Test Array Iterator Loop() --------------");
		list.add(0,"Augustus");
		list.add(1,	"Balbinus");
		list.add(2,	"Cresus");
		list.add(3, "Commodus");
		list.add(4, "Julius");
		list.add(5, "Septimius");
		list.add(6, "Tiberius");
		list.add(7, "Valerian");
		System.out.println(list);
		
		Iterator<String> itr = list.iterator();
		
		while(itr.hasNext()) {
			assertTrue(itr.hasNext());
			System.out.print("hasNext: " + itr.hasNext());
			System.out.println("\t next: " + itr.next());
		}
		
		// At end of the list : No more elements
		assertFalse(itr.hasNext());
		
		// No more elements to retrieve will throw Exception
		assertThrows(NoSuchElementException.class, () -> itr.next());
		System.out.println();
	}
	
	@Test
	void testCircularLinkage() {
		
		LinkedList<String> list = new LinkedList<String>();
		System.out.println("-------------- Test Circular Linkage() --------------");
		list.add(0,"Augustus");
		list.add(1,	"Balbinus");
		list.add(2,	"Cresus");
		list.add(3, "Commodus");
		list.add(4, "Julius");
		list.add(5, "Septimius");
		list.add(6, "Tiberius");
		list.add(7, "Valerian");
		System.out.println(list);
		
		assertEquals(list.getNextNode(0), list.getNode(1));
		assertEquals(list.getNextNode(1), list.getNode(2));
		assertEquals(list.getNextNode(2), list.getNode(3));
		assertEquals(list.getNextNode(3), list.getNode(4));
		assertEquals(list.getNextNode(4), list.getNode(5));
		assertEquals(list.getNextNode(5), list.getNode(6));
		assertEquals(list.getNextNode(6), list.getNode(7));
		assertEquals(list.getNextNode(7), list.getNode(0));
		
		assertEquals(list.getNode(0), list.getPrevNode(1));
		assertEquals(list.getNode(1), list.getPrevNode(2));
		assertEquals(list.getNode(2), list.getPrevNode(3));
		assertEquals(list.getNode(3), list.getPrevNode(4));
		assertEquals(list.getNode(4), list.getPrevNode(5));
		assertEquals(list.getNode(5), list.getPrevNode(6));
		assertEquals(list.getNode(6), list.getPrevNode(7));
		assertEquals(list.getNode(7), list.getPrevNode(0));
		
		list.clear();
		
		LinkedList<String> alist = new LinkedList<String>();
		assertTrue(alist.add("Augustus"));
		assertTrue(alist.add("Balbinus"));
		assertTrue(alist.add("Commodus"));
		assertTrue(alist.add("Decius"));
		assertTrue(alist.add("Florianus"));
		assertTrue(alist.add("Gallienus"));
		assertTrue(alist.add("Valerian"));
				
		assertEquals(alist.getNextNode(0), alist.getNode(1));
		assertEquals(alist.getNextNode(1), alist.getNode(2));
		assertEquals(alist.getNextNode(5), alist.getNode(6));
		assertEquals(alist.getNextNode(6), alist.getNode(0));
		
		assertEquals(alist.getNode(0), alist.getPrevNode(1));
		assertEquals(alist.getNode(1), alist.getPrevNode(2));
		assertEquals(alist.getNode(5), alist.getPrevNode(6));
		assertEquals(alist.getNode(6), alist.getPrevNode(0));
	}
	
	@Test
	void testLinkedIterator() {
		LinkedList<String> list = new LinkedList<String>();
		System.out.println("-------------- Test LinkedList Iterator() --------------");
		list.add(0,"Augustus");
		list.add(1,	"Balbinus");
		list.add(2,	"Cresus");
		list.add(3, "Commodus");
		list.add(4, "Julius");
		list.add(5, "Septimius");
		list.add(6, "Valerian");
		System.out.println(list);
		
		String name1 = "Tiberius";
		String name2 = "Valerian";
		
		if (!list.contains(name1)) {
			list.add(6, name1);
		}
		
		assertEquals(name1, list.get(6));
		assertEquals(name2, list.get(7));
		System.out.println(list);
		System.out.println();
		
		Iterator<String> itr = list.iterator();
		assertEquals("Augustus" ,  itr.next());
		assertEquals("Balbinus" ,  itr.next());
		assertEquals("Cresus"   ,  itr.next());
		assertEquals("Commodus" ,  itr.next());
		assertEquals("Julius"   ,  itr.next());
		assertEquals("Septimius",  itr.next());
		assertEquals("Tiberius" ,  itr.next());
		assertEquals("Valerian" ,  itr.next());
	}

	@Test
	void testLLIteratorLoop() {
		LinkedList<String> list = new LinkedList<String>();
		System.out.println("-------------- Test Linked Iterator Loop() --------------");
		list.add(0,"Augustus");
		list.add(1,	"Balbinus");
		list.add(2,	"Cresus");
		list.add(3, "Commodus");
		list.add(4, "Julius");
		list.add(5, "Septimius");
		list.add(6, "Tiberius");
		list.add(7, "Valerian");
		System.out.println(list);
		
		Iterator<String> itr = list.iterator();
		
		while(itr.hasNext()) {
			assertTrue(itr.hasNext());
			System.out.print("hasNext: " + itr.hasNext());
			System.out.println("\t next: " + itr.next());
		}
		
		// At end of the list : No more elements
		assertFalse(itr.hasNext());
		
		// No more elements to retrieve will throw Exception
		assertThrows(NoSuchElementException.class, () -> itr.next());
		System.out.println();
	}
	
	@Test
	void testPeek() {
		LinkedList<String> list = new LinkedList<String>();
		System.out.println("-------------- Test Peek() --------------");
		assertTrue(list.add("Augustus"));
		assertTrue(list.add("Balbinus"));
		assertTrue(list.add("Commodus"));
		assertTrue(list.add("Decius"));
		assertTrue(list.add("Septimius"));
		assertTrue(list.add("Tiberius"));
		assertTrue(list.add("Valerian"));
		
		System.out.println(list);
		
		assertEquals("Augustus", list.peek());
		assertEquals("Augustus", list.remove());
		assertEquals("Balbinus", list.remove());
		assertEquals("Commodus", list.peek());
		assertEquals("Commodus", list.remove());
		assertEquals("Decius"  , list.remove());
		assertEquals("Septimius", list.peek());
	}

	@Test
	void testRemove() {
		LinkedList<String> list = new LinkedList<String>();
		System.out.println("-------------- Test Remove() --------------");
		assertTrue(list.add("Augustus"));
		assertTrue(list.add("Balbinus"));
		assertTrue(list.add("Commodus"));
		assertTrue(list.add("Decius"));
		assertTrue(list.add("Septimius"));
		assertTrue(list.add("Tiberius"));
		assertTrue(list.add("Valerian"));
		
		System.out.println(list);
		
		assertEquals("Augustus" , list.remove());
		assertEquals("Balbinus" , list.remove());
		assertEquals("Commodus" , list.remove());
		assertEquals("Decius"   , list.remove());
		assertEquals("Septimius", list.remove());
		assertEquals("Tiberius" , list.remove());
		assertEquals("Valerian" , list.remove());
		assertThrows(NoSuchElementException.class, () -> list.remove());
		
	}

	@Test
	void testRemoveE() {
		LinkedList<String> list = new LinkedList<String>();
		System.out.println("---------------- Test RemoveE() ----------------");
		assertTrue(list.add("Augustus"));
		assertTrue(list.add("Balbinus"));
		assertTrue(list.add("Commodus"));
		assertTrue(list.add("Decius"));
		assertTrue(list.add("Gallienus"));
		assertTrue(list.add("Septimius"));
		assertTrue(list.add("Tiberius"));
		assertTrue(list.add("Valerian"));
		
		System.out.println(list);		
		System.out.println("size before: " + list.size());
		
		assertTrue(list.remove("Decius"));
		assertTrue(list.remove("Commodus"));
		assertTrue(list.remove("Gallienus"));
		assertTrue(list.remove("Balbinus"));
		assertTrue(list.remove("Augustus"));
		assertFalse(list.remove("Decius"));
		assertTrue(list.remove("Septimius"));
		
		System.out.println(list);
		assertTrue(list.remove("Valerian"));
		System.out.println("size after: " + list.size());
		
		assertFalse(list.remove("Florianus"));
		System.out.println(list);		
		System.out.println("size after Flo: " + list.size());		
		System.out.println();
	}

	@Test
	void testRemoveInt() {
		
		System.out.println();
		LinkedList<String> list = new LinkedList<String>();
		System.out.println("---------------- Test RemoveInt() ----------------");
		assertTrue(list.add("Augustus"));
		assertTrue(list.add("Balbinus"));
		assertTrue(list.add("Commodus"));
		assertTrue(list.add("Decius"));
		assertTrue(list.add("Gallienus"));
		assertTrue(list.add("Septimius"));
		assertTrue(list.add("Tiberius"));
		assertTrue(list.add("Valerian"));
		
		System.out.println(list);
		System.out.println("size before: " + list.size());
		assertEquals("Augustus" , list.remove(0));
		assertEquals("Decius"   , list.remove(2));
		assertEquals("Gallienus", list.remove(2));
		assertEquals("Balbinus" , list.remove(0));
		assertEquals("Commodus" , list.remove(0));
		assertEquals("Valerian" , list.remove(2));
		System.out.println(list);
		System.out.println("size after: " + list.size());	
		
		//Test if accessing index out of bounds.
		assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-2));
		assertThrows(IndexOutOfBoundsException.class, () -> list.remove(8));
		System.out.println();
	}
	
	@Test
	void testTrivialCompareTo() {

		LinkedList<String> list = new LinkedList<String>();
		System.out.println("-------------- Test CompareTo() --------------");
		list.add(0, "Augustus");
		list.add(1,	"Balbinus");
		list.add(2,	"Cresus");
		list.add(3, "Commodus");
		list.add(4, "Julius");
		list.add(5, "Septimius");
		list.add(6, "Tiberius");
		list.add(7, "Valerian");
		System.out.println(list);
		
		int w = "Plato".compareTo("Socrates");
		int x = list.get(7).compareTo("Socrates");
		int y = list.get(5).compareTo("Socrates");
		int z = "Socrates".compareTo("Socrates");
		
		System.out.println("compareTo P to S: " + w);
		System.out.println("compareTo V to S: " + x);
		System.out.println("compareTo Se to So: " + y);
		System.out.println("compareTo S to S: " + z);
		
		assertEquals(-3, w);
		assertEquals(3, x);
		assertEquals(-10, y);
		assertEquals(0, z);
		System.out.println();
		
	}

}
