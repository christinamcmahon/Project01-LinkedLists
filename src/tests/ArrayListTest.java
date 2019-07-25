
package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import lists.ArrayList;

class ArrayListTest {

	ArrayList<String> list;
	
	/*******************************************************
	 * Test method for {@link lists.ArrayList#ArrayList()}.
	 *******************************************************/
	@Test
	void testArrayList() {
		list = new ArrayList<String>();
		System.out.println("---------------- Test Default Constructor( ) ----------------");
		assertNull(list.get(0));
		System.out.println("size before: " + list.size());
		assertTrue(list.add("Augustus"));
		assertTrue(list.add("Commodus"));
		assertTrue(list.add("Decius"));
		assertTrue(list.add("Valerian"));
		assertEquals(4, list.size());
		
		System.out.println(list);
		System.out.println("size after: " + list.size());
		System.out.println();
	}

	/***********************************************************
	 * Test method for {@link lists.ArrayList#ArrayList(int)}.
	 ***********************************************************/
	@Test
	void testArrayListInt() {
		
		list = new ArrayList<String>(5);
		System.out.println("---------------- Test Constructor( ) ----------------");
		assertNull(list.get(0));
		System.out.println("size before: " + list.size());
		assertTrue(list.add("Augustus"));
		assertTrue(list.add("Commodus"));
		assertTrue(list.add("Decius"));
		assertTrue(list.add("Valerian"));
		assertEquals(4, list.size());
		
		System.out.println(list);
		System.out.println("size after: " + list.size());
		System.out.println();
	}

	/*****************************************************************
	 * Test method for {@link lists.ArrayList#add(java.lang.Object)}.
	 *****************************************************************/
	@Test
	void testAddE() {
		
		list = new ArrayList<String>();
		
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

	/**********************************************************************
	 * Test method for {@link lists.ArrayList#add(int, java.lang.Object)}.
	 **********************************************************************/
	@Test
	void testAddIntE() {
		list = new ArrayList<String>();
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
		System.out.println("--------------------------- Add @ 3 -----------------------");
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

	/***************************************************
	 * Test method for {@link lists.ArrayList#clear()}.
	 ***************************************************/
	@Test
	void testClear() {
		list = new ArrayList<String>();
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
		assertNull(list.get(0));
		
		System.out.println();
	}

	/**********************************************************************
	 * Test method for {@link lists.ArrayList#contains(java.lang.Object)}.
	 **********************************************************************/
	@Test
	void testContains() {
		list = new ArrayList<String>();
		System.out.println("---------------- Test Contains( ) ----------------");
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
		
		System.out.println();
	}

	/***************************************************************
	 * Test method for {@link lists.ArrayList#ensureCapacity(int)}.
	 ***************************************************************/
	@Test
	void testEnsureCapacity() {
		
		list = new ArrayList<String>(5);
		
		System.out.println("---------------- Test EnsureCapacity( ) ----------------");
		assertTrue(list.add("Augustus"));
		assertTrue(list.add("Balbinus"));
		assertTrue(list.add("Commodus"));
		assertTrue(list.add("Decius"));
		assertTrue(list.add("Florianus"));
		
		assertEquals(5, list.size());
		System.out.println("List Threshold @ Capacity");
		System.out.println("Should expand beyound this point or will CRASH");
		System.out.println("TEST VIA add method");
		
		assertTrue(list.add("Gallienus"));
		assertTrue(list.add("Julius"));
		assertTrue(list.add("Tiberius"));
		assertTrue(list.add("Valerian"));
		
		assertEquals(9, list.size());
		System.out.println(list);
		System.out.println();
	}

	/****************************************************
	 * Test method for {@link lists.ArrayList#get(int)}.
	 ****************************************************/
	@Test
	void testGet() {
		list = new ArrayList<String>();
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

	/*********************************************************************
	 * Test method for {@link lists.ArrayList#indexOf(java.lang.Object)}.
	 *********************************************************************/
	@Test
	void testIndexOf() {
		
		list = new ArrayList<String>();
		System.out.println("---------------- Test IdexOf( ) ----------------");
		assertTrue(list.add("Augustus"));
		assertTrue(list.add("Balbinus"));
		assertTrue(list.add("Commodus"));
		assertTrue(list.add("Decius"));
		assertTrue(list.add("Florianus"));
		assertTrue(list.add("Gallienus"));
		assertTrue(list.add("Valerian"));
		
		assertEquals(0, list.indexOf("Augustus"));
		assertEquals(2, list.indexOf("Commodus"));
		assertEquals(6, list.indexOf("Valerian"));
		assertEquals(-1, list.indexOf("Tiberius"));
		
		System.out.println(list);
		System.out.println("location of Commodus " + list.indexOf("Commodus"));
		System.out.println("location of Valerian " + list.indexOf("Valerian"));
		System.out.println("location of Tiberius " + list.indexOf("Tiberius"));
		System.out.println();
	}

	/*****************************************************
	 * Test method for {@link lists.ArrayList#isEmpty()}.
	 *****************************************************/
	@Test
	void testIsEmpty() {

		list = new ArrayList<String>();
		System.out.println("---------------- Test IsEmpty( ) ----------------");
		assertTrue(list.isEmpty());
		assertTrue(list.add("Augustus"));
		assertTrue(list.add("Balbinus"));
		assertTrue(list.add("Commodus"));
		assertTrue(list.add("Decius"));
		assertTrue(list.add("Florianus"));
		assertTrue(list.add("Gallienus"));
		assertTrue(list.add("Valerian"));
		
		assertFalse(list.isEmpty());
		assertEquals(7, list.size());
		
		System.out.println(list);
		System.out.println("size before: " + list.size());
		list.clear();
		
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		
		System.out.println("size after: " + list.size());
		assertNull(list.get(0));
		
		System.out.println();
	}

	/*******************************************************
	 * Test method for {@link lists.ArrayList#remove(int)}.
	 *******************************************************/
	@Test
	void testRemoveInt() {
		list = new ArrayList<String>();
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

	/********************************************************************
	 * Test method for {@link lists.ArrayList#remove(java.lang.Object)}.
	 ********************************************************************/
	@Test
	void testRemoveE() {
		list = new ArrayList<String>();
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

	/**********************************************************************
	 * Test method for {@link lists.ArrayList#set(int, java.lang.Object)}.
	 **********************************************************************/
	@Test
	void testSet() {
		list = new ArrayList<String>();
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

	/**************************************************
	 * Test method for {@link lists.ArrayList#size()}.
	 **************************************************/
	@Test
	void testSize() {
		list = new ArrayList<String>();
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
