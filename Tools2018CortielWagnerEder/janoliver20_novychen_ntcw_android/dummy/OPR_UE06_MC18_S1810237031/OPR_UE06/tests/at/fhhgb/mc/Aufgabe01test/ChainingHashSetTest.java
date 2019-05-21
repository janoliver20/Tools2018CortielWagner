package at.fhhgb.mc.Aufgabe01test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import at.fhhgb.mc.Aufgabe01.ChainingHashSet;

import at.fhhgb.mc.Aufgabe01.ValueException;

public class ChainingHashSetTest {

	private static ChainingHashSet c1, c2;

	@BeforeEach
	public void setUp() throws ValueException {

		c1 = new ChainingHashSet(5); // HashSet: [[5, 15, 10], [X], [X], [3, 18], [9], [X]]
		c1.insert(5);
		c1.insert(15);
		c1.insert(10);
		c1.insert(3);
		c1.insert(18);
		c1.insert(9);

		c2 = new ChainingHashSet(5); // Empty HashSet

	}

	@Test
	public void testInsert() throws ValueException {

		// HashSet 1:

		// Insert new element
		Assertions.assertTrue(c1.insert(2));
		Assertions.assertTrue(c1.insert(23));
		Assertions.assertThrows(ValueException.class, () -> c1.insert(-11));
		Assertions.assertEquals(8, c1.elements());
		Assertions.assertTrue(c1.contains(2));
		Assertions.assertTrue(c1.contains(23));

		// Insert existing element
		Assertions.assertFalse(c1.insert(5));
		Assertions.assertFalse(c1.insert(9));
		Assertions.assertFalse(c1.insert(3));
		Assertions.assertEquals(8, c1.elements());

		// HashSet 2:

		Assertions.assertThrows(ValueException.class, () -> c2.insert(-2));
		Assertions.assertTrue(c2.insert(13));
		Assertions.assertTrue(c2.insert(5));
		Assertions.assertThrows(ValueException.class, () -> c2.insert(-11));
		Assertions.assertTrue(c2.insert(0));
		Assertions.assertTrue(c2.insert(1));
		Assertions.assertEquals(4, c2.elements());

	}

	@Test
	public void contains() {

		// HashSet 1:
		Assertions.assertTrue(c1.contains(5));
		Assertions.assertTrue(c1.contains(15));
		Assertions.assertTrue(c1.contains(9));
		Assertions.assertTrue(c1.contains(18));
		Assertions.assertTrue(c1.contains(3));
		Assertions.assertTrue(c1.contains(10));

		Assertions.assertFalse(c1.contains(1));
		Assertions.assertFalse(c1.contains(16));
		Assertions.assertFalse(c1.contains(13));
		Assertions.assertFalse(c1.contains(-1));
		Assertions.assertFalse(c1.contains(0));

		// HashSet 2:
		Assertions.assertFalse(c2.contains(1));
		Assertions.assertFalse(c2.contains(16));
		Assertions.assertFalse(c2.contains(13));
		Assertions.assertFalse(c2.contains(-1));
		Assertions.assertFalse(c2.contains(0));

	}

	@Test
	public void remove() throws ValueException {

		// HashSet 1:

		// Remove existing elements
		Assertions.assertTrue(c1.remove(5));
		Assertions.assertTrue(c1.remove(9));
		Assertions.assertTrue(c1.remove(3));
		Assertions.assertTrue(c1.remove(10));
		Assertions.assertTrue(c1.remove(18));
		Assertions.assertEquals(1, c1.elements());

		// Remove non existing elements
		Assertions.assertFalse(c1.remove(1));
		Assertions.assertFalse(c1.remove(16));
		Assertions.assertFalse(c1.remove(13));
		Assertions.assertFalse(c1.remove(0));
		Assertions.assertEquals(1, c1.elements());

		// HashSet 2:
		Assertions.assertFalse(c2.remove(1));
		Assertions.assertFalse(c2.remove(16));
		Assertions.assertFalse(c2.remove(13));
		Assertions.assertFalse(c2.remove(0));
		Assertions.assertEquals(0, c2.elements());

	}

	@Test
	public void getOverflowCount() throws ValueException {

		// HashSet 1:

		// Invalid index
		Assertions.assertThrows(ValueException.class, () -> c1.getOverflowCount(5));

		// Negative index
		Assertions.assertThrows(ValueException.class, () -> c1.getOverflowCount(-3));

		// Uninitialized index
		Assertions.assertEquals(0, c1.getOverflowCount(1));

		// Initialized index
		Assertions.assertEquals(3, c1.getOverflowCount(0));
		Assertions.assertEquals(2, c1.getOverflowCount(3));
		Assertions.assertEquals(1, c1.getOverflowCount(4));

		// HashSet 2:
		Assertions.assertEquals(0, c2.getOverflowCount(1));
		Assertions.assertEquals(0, c2.getOverflowCount(3));
		Assertions.assertEquals(0, c2.getOverflowCount(4));
		Assertions.assertThrows(ValueException.class, () -> c2.getOverflowCount(5));

	}

	@Test
	public void elements() throws ValueException {

		// HashSet 1:
		Assertions.assertEquals(6, c1.elements());
		c1.remove(10);
		c1.remove(9);
		Assertions.assertEquals(4, c1.elements());

		// HashSet 2:
		Assertions.assertEquals(0, c2.elements());
		c2.insert(27);
		c2.insert(11);
		Assertions.assertEquals(2, c2.elements());

	}

}
