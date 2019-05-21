package at.fhhgb.mc.Aufgabe01test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import at.fhhgb.mc.Aufgabe01.DoubleLinkedList;
import at.fhhgb.mc.Aufgabe01.InvalidAccessException;

public class DoubleLinkedListTest {

	private static DoubleLinkedList l1, l2;

	@BeforeEach
	public void setUp() {

		l1 = new DoubleLinkedList(); // List with 3 elements
		l2 = new DoubleLinkedList(); // Empty list

		l1.pushFront(10);
		l1.pushFront(15);
		l1.pushFront(20);

	}

	// Checks InitDoubleLinkedList(), elements() and pushFront()
	@Test
	public void testInitDoubleLinkedList() {

		Assertions.assertEquals(3, l1.elements());
		Assertions.assertEquals(0, l2.elements());

	}

	@Test
	public void testClear() {

		l1.clear();
		l2.clear();
		Assertions.assertEquals(0, l1.elements());
		Assertions.assertEquals(0, l2.elements());

	}

	@Test
	public void testPushBack() {

		l2.pushBack(2);
		l2.pushBack(4);
		l2.pushBack(6);
		Assertions.assertEquals(3, l2.elements());

	}

	@Test
	public void testPopFront() throws InvalidAccessException {

		Assertions.assertEquals(20, l1.popFront());
		// PopFront (empty List):
		Assertions.assertThrows(InvalidAccessException.class, () -> l2.popFront());
		Assertions.assertEquals(2, l1.elements());
		Assertions.assertEquals(0, l2.elements());

	}

	@Test
	public void testPeekFront() {

		Assertions.assertEquals(20, l1.peekFront());
		Assertions.assertEquals(Integer.MIN_VALUE, l2.peekFront());
		Assertions.assertEquals(3, l1.elements());
		Assertions.assertEquals(0, l2.elements());
	}

	@Test
	public void testPopBack() throws InvalidAccessException {
		Assertions.assertEquals(10, l1.popBack());
		// Popback (empty List):
		Assertions.assertThrows(InvalidAccessException.class, () -> l2.popBack());
		Assertions.assertEquals(2, l1.elements());
		Assertions.assertEquals(0, l2.elements());
	}

	@Test
	public void testPeekBack() {
		Assertions.assertEquals(10, l1.peekBack());
		Assertions.assertEquals(Integer.MIN_VALUE, l2.peekBack());
		Assertions.assertEquals(3, l1.elements());
		Assertions.assertEquals(0, l2.elements());

	}

	@Test
	public void testReverse() {

		l1.reverse();
		l2.reverse();
		Assertions.assertEquals(20, l1.peekBack());
		Assertions.assertEquals(10, l1.peekFront());

	}
}

