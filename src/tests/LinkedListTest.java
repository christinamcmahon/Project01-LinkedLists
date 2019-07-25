package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import lists.LinkedList;

class LinkedListTest {

	@Test
	void testLinkedList() {
		LinkedList<String> list = new LinkedList<String>();
		System.out.println("---------------- Test Default Constructor( ) ----------------");
		System.out.println("size before: " + list.size());
		assertTrue(list.add("Augustus"));
		assertTrue(list.add("Commodus"));
		assertTrue(list.add("Decius"  ));
		assertTrue(list.add("Valerian"));
		
		assertEquals(4, list.size());
		System.out.println(list);
		System.out.println("size after: " + list.size());
		System.out.println();
	}

	@Test
	void testAddE() {
		LinkedList<String> list = new LinkedList<String>();
		System.out.println("---------------- Test Add(E e) ----------------");
		assertTrue(list.add("Augustus"));
		assertTrue(list.add("Balbinus"));
		assertTrue(list.add("Commodus"));
		assertTrue(list.add("Decius"));
		assertTrue(list.add("Florianus"));
		assertTrue(list.add("Gallienus"));
		assertTrue(list.add("Valerian"));
		
		System.out.println(list);
		System.out.println("size: " + list.size());
		assertEquals(7, list.size());
		System.out.println();
	}

	@Test
	void testAddIntE() {
		
		System.out.println("------------ Test Add(int, E e) -----------");
		LinkedList<String> list = new LinkedList<String>();
		list.add(0,"Horus");
		list.add(1,"Isis");
		list.add("Marcus");
		
		System.out.println("---------------------- List AddIntE ---------------------");
		System.out.println(list);
		System.out.println();
		
		System.out.println("----------------- Test Add(index, value) ----------------");
		list.add(0, "Augustus");
		list.add(1, "Cresus");
		list.add(2, "Aquinas");
		System.out.println(list);
		System.out.println();
		
		assertEquals("Augustus", list.get(0));
		assertEquals("Cresus"  , list.get(1));
		assertEquals("Aquinas" , list.get(2));
		
		System.out.println("--------------------------- Add @ Location 3 -----------------------");
		list.add(3, "Commodus");
		assertEquals("Commodus", list.get(3));
		
		list.add(3, "Balbinus");
		assertEquals("Balbinus", list.get(3));
		
		list.add(3, "Eurius");
		assertEquals("Eurius"  , list.get(3));
		
		System.out.println(list);
		System.out.println("size: " + list.size());
		
		//Test if accessing index out of bounds.
		assertThrows(IndexOutOfBoundsException.class, () -> list.add(-2, "Hera"));
		assertThrows(IndexOutOfBoundsException.class, () -> list.add(10, "Hera"));
		System.out.println();
	}

	@Test
	void testClear() {
		
		LinkedList<String> list = new LinkedList<String>();
		System.out.println("---------------- Test Clear( ) ----------------");
		assertTrue(list.add("Augustus"));
		assertTrue(list.add("Balbinus"));
		assertTrue(list.add("Commodus"));
		assertTrue(list.add("Decius"));
		assertTrue(list.add("Florianus"));
		assertTrue(list.add("Gallienus"));
		assertTrue(list.add("Valerian"));
		
		assertEquals(7, list.size());
		System.out.println(list);
		
		System.out.println("size before: " + list.size());
		list.clear();
		assertEquals(0, list.size());
		System.out.println("size after: " + list.size());
		
		System.out.println();
	}

	@Test
	void testContains() {
		LinkedList<String> list = new LinkedList<String>();
		System.out.println("---------------- Test Contains(E e) --------------");
		assertTrue(list.add("Augustus"));
		assertTrue(list.add("Balbinus"));
		assertTrue(list.add("Commodus"));
		assertTrue(list.add("Decius"));
		assertTrue(list.add("Florianus"));
		assertTrue(list.add("Gallienus"));
		assertTrue(list.add("Valerian"));
		
		assertTrue(list.contains("Augustus"));
		assertTrue(list.contains("Commodus"));
		assertTrue(list.contains("Valerian"));
		assertFalse(list.contains("Tiberius"));
		
		System.out.println(list);
		System.out.println("has Commodus? " + list.contains("Commodus"));
		System.out.println("has Valerian? " + list.contains("Valerian"));
		System.out.println("has Tiberius? " + list.contains("Tiberius"));
		System.out.println();
	}

	@Test
	void testGet() {
		LinkedList<String> list = new LinkedList<String>();
		System.out.println("---------------- Test Get( ) ----------------");
		assertTrue(list.add("Augustus"));
		assertTrue(list.add("Balbinus"));
		assertTrue(list.add("Commodus"));
		assertTrue(list.add("Decius"));
		assertTrue(list.add("Florianus"));
		assertTrue(list.add("Gallienus"));
		assertTrue(list.add("Valerian"));
		
		assertEquals("Augustus", list.get(0));
		assertEquals("Commodus", list.get(2));
		assertEquals("Valerian", list.get(6));
		
		System.out.println(list);
		System.out.println("who is at 0? " + list.get(0));
		System.out.println("who is at 2? " + list.get(2));
		System.out.println("who is at 6? " + list.get(6));

		//Test if accessing index out of bounds.
		assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
		assertThrows(IndexOutOfBoundsException.class, () -> list.get(8));
		System.out.println();
	}

	@Test
	void testIndexOf() {
		System.out.println();
		LinkedList<String> list = new LinkedList<String>();
		System.out.println("-------------- Test indexOf(E e) --------------");
		list.add(0,"Augustus");
		list.add(1,	"Balbinus");
		list.add(2,	"Cresus");
		list.add(3, "Commodus");
		list.add(4, "Decius");
		list.add(5, "Florianus");
		list.add(6, "Valerian");
		System.out.println(list);
		assertEquals(0,list.indexOf("Augustus"));
		assertEquals(3,list.indexOf("Commodus"));
		assertEquals(6,list.indexOf("Valerian"));
		assertEquals(-1,list.indexOf("Tiberius"));
		assertEquals(7, list.size());
		System.out.println("-----------------------------------------------");
		System.out.println("indexOf -1 \t" + list.indexOf("Tiberius"));
		System.out.println("indexOf 0 \t"  + list.indexOf("Augustus"));
		System.out.println("indexOf 2 \t"  + list.indexOf("Cresus"));
		System.out.println("indexOf 3 \t"  + list.indexOf("Commodus"));
		System.out.println("indexOf 6 \t"  + list.indexOf("Valerian"));
		list.clear();
		System.out.println(list);
		System.out.println("--------------Exiting IndexOf(E e)----------------");
	}

	@Test
	void testIsEmpty() {
		System.out.println();
		LinkedList<String> list = new LinkedList<String>();
		System.out.println("-------------- Test isEmpty() --------------");
		list.add(0,"Augustus");
		list.add(1,	"Balbinus");
		list.add(2,	"Cresus");
		list.add(3, "Commodus");
		list.add(4, "Decius");
		list.add(5, "Florianus");
		list.add(6, "Valerian");
		assertEquals(7, list.size());
		assertFalse(list.isEmpty());
		System.out.println(list);
		list.clear();
		System.out.println(list);
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
	}

	@Test
	void testRemoveInt() {
		
		LinkedList<String> list = new LinkedList<String>();
		System.out.println("---------------- Test RemoveInt() ----------------");
		assertTrue(list.add("Augustus"));
		assertTrue(list.add("Balbinus"));
		assertTrue(list.add("Commodus"));
		assertTrue(list.add("Decius"));
		assertTrue(list.add("Florianus"));
		assertTrue(list.add("Gallienus"));
		assertTrue(list.add("Valerian"));
		
		System.out.println(list);
		System.out.println("size before: " + list.size());
		assertEquals(7, list.size());
		assertEquals("Decius", list.remove(3));
		assertEquals(6, list.size());
		System.out.println(list);
		System.out.println("size after: " + list.size());	
		
		//Test if accessing index out of bounds.
		assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-2));
		assertThrows(IndexOutOfBoundsException.class, () -> list.remove(8));
		System.out.println();
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
		assertTrue(list.add("Valerian"));
		
		System.out.println(list);
		System.out.println("size before: " + list.size());
		assertEquals(6, list.size());
		assertTrue(list.remove("Decius"));
		assertEquals(5, list.size());
		System.out.println(list);
		System.out.println("size after: " + list.size());		
		assertFalse(list.remove("Florianus"));
		System.out.println("size after Flo: " + list.size());		
		System.out.println();
	}

	@Test
	void testSet() {
		LinkedList<String> list = new LinkedList<String>();
		System.out.println("------------------ Test Set( ) ------------------");
		assertTrue(list.add("Augustus"));
		assertTrue(list.add("Balbinus"));
		assertTrue(list.add("Commodus"));
		assertTrue(list.add("Decius"));
		assertTrue(list.add("Valerian"));
		
		System.out.println(list);
		assertEquals("Balbinus", list.set(1, "Julius"));
		System.out.println(list);
		assertEquals("Decius"  , list.set(3, "Tiberius"));
		System.out.println(list);
		System.out.println();
		
		//Test if accessing index out of bounds.
		assertThrows(IndexOutOfBoundsException.class, () -> list.set(-2, "Hera"));
		assertThrows(IndexOutOfBoundsException.class, () -> list.set(8, "Hera"));
		System.out.println();
	}

	@Test
	void testSize() {

		LinkedList<String> list = new LinkedList<String>();
		System.out.println("---------------- Test Size() ----------------");
		assertTrue(list.add("Augustus"));
		assertTrue(list.add("Balbinus"));
		assertTrue(list.add("Commodus"));
		assertTrue(list.add("Gallienus"));
		assertTrue(list.add("Valerian"));
		
		System.out.println(list);
		assertEquals(5, list.size());
		System.out.println("size end: " + list.size());
		
		System.out.println();
	}
	
}
