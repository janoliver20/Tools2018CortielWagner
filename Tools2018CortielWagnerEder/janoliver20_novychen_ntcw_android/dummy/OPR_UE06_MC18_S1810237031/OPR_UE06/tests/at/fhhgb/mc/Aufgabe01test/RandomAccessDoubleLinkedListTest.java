package at.fhhgb.mc.Aufgabe01test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import at.fhhgb.mc.Aufgabe01.InvalidAccessException;
import at.fhhgb.mc.Aufgabe01.RandomAccessDoubleLinkedList;

public class RandomAccessDoubleLinkedListTest {

	private static RandomAccessDoubleLinkedList l1, l2;

	@BeforeEach
	public void setUp() throws InvalidAccessException {

		l1 = new RandomAccessDoubleLinkedList(); // List with five initialized Nodes: [10, 11, 12, X, 14, 15]
		l1.insertAt(0, 10);
		l1.insertAt(1, 11);
		l1.insertAt(2, 12);
		l1.insertAt(4, 14);
		l1.insertAt(5, 15);

		l2 = new RandomAccessDoubleLinkedList(); // Empty list: [empty list]

	}

	@Test
	public void testInsertAt() throws InvalidAccessException {

		// List 1:

		// Insert at the end of the list
		l1.insertAt(6, 16);
		Assertions.assertEquals(16, l1.elementAt(6));
		Assertions.assertEquals(6, l1.elements());
		Assertions.assertEquals(7, l1.nodeCounter());
		Assertions.assertEquals("[10, 11, 12, X, 14, 15, 16]", l1.toString()); // 'X' = Uninitialized Node.

		// Insert at an index higher than the size of the list
		l1.insertAt(10, 100);
		Assertions.assertEquals(100, l1.elementAt(10));
		Assertions.assertEquals(7, l1.elements());
		Assertions.assertEquals(11, l1.nodeCounter());
		Assertions.assertEquals("[10, 11, 12, X, 14, 15, 16, X, X, X, 100]", l1.toString());

		// Insert at invalid index
		Assertions.assertThrows(InvalidAccessException.class, () -> l1.insertAt(-1, 1));
		Assertions.assertThrows(InvalidAccessException.class, () -> l2.insertAt(-9, 1));
		Assertions.assertEquals(100, l1.elementAt(10));
		Assertions.assertEquals(7, l1.elements());
		Assertions.assertEquals(11, l1.nodeCounter());
		Assertions.assertEquals("[10, 11, 12, X, 14, 15, 16, X, X, X, 100]", l1.toString());

		// Insert in the middle of the list
		l1.insertAt(2, 5);
		Assertions.assertEquals(5, l1.elementAt(2));
		Assertions.assertEquals(8, l1.elements());
		Assertions.assertEquals(12, l1.nodeCounter());
		Assertions.assertEquals("[10, 11, 5, 12, X, 14, 15, 16, X, X, X, 100]", l1.toString());

		// Insert into an uninitialized Node
		l1.insertAt(4, 80);
		Assertions.assertEquals(80, l1.elementAt(4));
		Assertions.assertEquals(9, l1.elements());
		Assertions.assertEquals(12, l1.nodeCounter());
		Assertions.assertEquals("[10, 11, 5, 12, 80, 14, 15, 16, X, X, X, 100]", l1.toString());

		// List 2:

		// Insert into empty List
		l2.insertAt(9, 90);
		Assertions.assertEquals(90, l2.elementAt(9));
		Assertions.assertEquals(1, l2.elements());
		Assertions.assertEquals(10, l2.nodeCounter());
		Assertions.assertEquals("[X, X, X, X, X, X, X, X, X, 90]", l2.toString());

	}

	@Test
	public void testContains() {

		// List 1:
		Assertions.assertTrue(l1.contains(10));
		Assertions.assertTrue(l1.contains(11));
		Assertions.assertTrue(l1.contains(12));
		Assertions.assertTrue(l1.contains(14));
		Assertions.assertTrue(l1.contains(15));
		Assertions.assertFalse(l1.contains(1));
		Assertions.assertFalse(l1.contains(16));
		Assertions.assertFalse(l1.contains(13));
		Assertions.assertFalse(l1.contains(-1));
		Assertions.assertFalse(l1.contains(0));

		// List 2:
		Assertions.assertFalse(l2.contains(1));
		Assertions.assertFalse(l2.contains(16));
		Assertions.assertFalse(l2.contains(13));
		Assertions.assertFalse(l2.contains(-1));
		Assertions.assertFalse(l2.contains(0));

	}

	@Test
	public void testRemoveAt() throws InvalidAccessException {

		// List 1:

		// Remove last element
		Assertions.assertTrue(l1.removeAt(5));
		Assertions.assertThrows(InvalidAccessException.class, () -> l1.elementAt(5));
		Assertions.assertEquals(4, l1.elements());
		Assertions.assertEquals(6, l1.nodeCounter());
		Assertions.assertEquals("[10, 11, 12, X, 14, X]", l1.toString());

		// Remove at index of uninitialized Node
		Assertions.assertTrue(l1.removeAt(5));
		Assertions.assertThrows(InvalidAccessException.class, () -> l1.elementAt(5));
		Assertions.assertEquals(4, l1.elements());
		Assertions.assertEquals(6, l1.nodeCounter());
		Assertions.assertEquals("[10, 11, 12, X, 14, X]", l1.toString());

		// Remove first Element
		Assertions.assertTrue(l1.removeAt(0));
		Assertions.assertThrows(InvalidAccessException.class, () -> l1.elementAt(0));
		Assertions.assertEquals(3, l1.elements());
		Assertions.assertEquals(6, l1.nodeCounter());
		Assertions.assertEquals("[X, 11, 12, X, 14, X]", l1.toString());

		// Remove middle element
		Assertions.assertTrue(l1.removeAt(2));
		Assertions.assertThrows(InvalidAccessException.class, () -> l1.elementAt(2));
		Assertions.assertEquals(2, l1.elements());
		Assertions.assertEquals(6, l1.nodeCounter());
		Assertions.assertEquals("[X, 11, X, X, 14, X]", l1.toString());

		// Remove at invalid index
		Assertions.assertThrows(InvalidAccessException.class, () -> l1.removeAt(6)); // > number of nodes in list:
		Assertions.assertThrows(InvalidAccessException.class, () -> l1.removeAt(-1)); // < 0:

		Assertions.assertThrows(InvalidAccessException.class, () -> l2.elementAt(6));
		Assertions.assertThrows(InvalidAccessException.class, () -> l2.elementAt(-1));
		Assertions.assertEquals(2, l1.elements());
		Assertions.assertEquals(6, l1.nodeCounter());
		Assertions.assertEquals("[X, 11, X, X, 14, X]", l1.toString());

		// List 2:

		// Remove (empty list)
		Assertions.assertThrows(InvalidAccessException.class, () -> l2.removeAt(0));
		Assertions.assertThrows(InvalidAccessException.class, () -> l2.removeAt(-1));
		Assertions.assertThrows(InvalidAccessException.class, () -> l2.removeAt(5));
		Assertions.assertThrows(InvalidAccessException.class, () -> l2.elementAt(6));
		Assertions.assertThrows(InvalidAccessException.class, () -> l2.elementAt(-1));
		Assertions.assertEquals(0, l2.elements());
		Assertions.assertEquals(0, l2.nodeCounter());
		Assertions.assertEquals("[empty list]", l2.toString());

	}

	@Test
	public void testRemoveAll() throws InvalidAccessException {

		// List 1:

		l1.insertAt(8, 12);
		l1.insertAt(0, 12);
		Assertions.assertTrue(l1.removeAll(12));
		Assertions.assertFalse(l1.removeAll(100));
		Assertions.assertThrows(InvalidAccessException.class, () -> l1.elementAt(0));
		Assertions.assertThrows(InvalidAccessException.class, () -> l1.elementAt(3));
		Assertions.assertThrows(InvalidAccessException.class, () -> l1.elementAt(9));
		Assertions.assertEquals(4, l1.elements());
		Assertions.assertEquals(10, l1.nodeCounter());
		Assertions.assertEquals("[X, 10, 11, X, X, 14, 15, X, X, X]", l1.toString());

		// List 2:
		Assertions.assertFalse(l2.removeAll(100));
		Assertions.assertFalse(l2.removeAll(1));
		Assertions.assertFalse(l2.removeAll(0));
		Assertions.assertFalse(l2.removeAll(-1));
		Assertions.assertEquals(0, l2.elements());
		Assertions.assertEquals(0, l2.nodeCounter());
		Assertions.assertEquals("[empty list]", l2.toString());

	}

	@Test
	public void testElementAt() throws InvalidAccessException {

		// List 1:

		// Element at invalid index
		Assertions.assertThrows(InvalidAccessException.class, () -> l1.elementAt(-1));

		// Element at uninitialized node
		Assertions.assertThrows(InvalidAccessException.class, () -> l1.elementAt(3));

		// Elements at valid indexes
		Assertions.assertEquals(10, l1.elementAt(0));
		Assertions.assertEquals(11, l1.elementAt(1));
		Assertions.assertEquals(12, l1.elementAt(2));
		Assertions.assertEquals(14, l1.elementAt(4));
		Assertions.assertEquals(15, l1.elementAt(5));

		// List 2: (empty List)
		Assertions.assertThrows(InvalidAccessException.class, () -> l2.elementAt(0));
		Assertions.assertThrows(InvalidAccessException.class, () -> l2.elementAt(-1));
		Assertions.assertThrows(InvalidAccessException.class, () -> l2.elementAt(2));
		Assertions.assertThrows(InvalidAccessException.class, () -> l2.elementAt(10));

	}

}