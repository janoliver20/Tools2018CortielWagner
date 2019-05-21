package at.fhhgb.mc.Aufgabe02test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import at.fhhgb.mc.Aufgabe02.BinarySearchTree;
import at.fhhgb.mc.Aufgabe02.InvalidAccessException;
import at.fhhgb.mc.Aufgabe02.ValueException;

public class BinarySearchTreeTest {

	private static BinarySearchTree t1, t2, t3;

	@BeforeEach
	public void setUp() throws ValueException, InvalidAccessException {

		t1 = new BinarySearchTree(); // Tree with 11 elements
		t1.insert(30);
		t1.insert(15);
		t1.insert(23);
		t1.insert(32);
		t1.insert(31);
		t1.insert(17);
		t1.insert(18);
		t1.insert(1);
		t1.insert(5);
		t1.insert(25);
		t1.insert(111);

		t2 = new BinarySearchTree(); // Empty tree

		t3 = new BinarySearchTree(); // String Tree
		t3.insert("Thanos");
		t3.insert("Joker");
		t3.insert("Scar");
		t3.insert("Voldemort");

	}

	@Test
	public void testInsert() throws ValueException {

		// Tree 1:
		Assertions.assertEquals(false, t1.insert(15));
		Assertions.assertEquals(true, t1.insert(118));
		Assertions.assertEquals(111, t1.getParent(118));
		Assertions.assertEquals(12, t1.size());

		// Invalid input:
		Assertions.assertThrows(ValueException.class, () -> t1.insert("WRONG"));
		Assertions.assertThrows(ValueException.class, () -> t1.insert(null));

		// Tree 2:
		Assertions.assertEquals(true, t2.insert(15));
		Assertions.assertEquals(true, t2.insert(20));
		Assertions.assertEquals(true, t2.insert(8));
		Assertions.assertEquals(false, t2.insert(8));
		Assertions.assertEquals(15, t2.getParent(20));
		Assertions.assertEquals(3, t2.size());

		// Invalid input:
		Assertions.assertThrows(ValueException.class, () -> t2.insert("WRONG"));
		Assertions.assertThrows(ValueException.class, () -> t2.insert(null));

		// String Tree:
		Assertions.assertEquals(false, t3.insert("Thanos"));
		Assertions.assertEquals(true, t3.insert("Freddy Krueger"));

	}

	@Test
	public void testFind() throws ValueException, InvalidAccessException {

		// Tree 1:
		Assertions.assertEquals(true, t1.find(30));
		Assertions.assertEquals(true, t1.find(18));
		Assertions.assertEquals(true, t1.find(31));
		Assertions.assertEquals(false, t1.find(13));
		Assertions.assertEquals(false, t1.find(4));
		Assertions.assertEquals(false, t1.find(0));

		// Invalid key:
		Assertions.assertThrows(ValueException.class, () -> t1.find("WRONG"));
		Assertions.assertThrows(ValueException.class, () -> t1.find(null));

		// Tree 2: empty tree -> invalid Access
		Assertions.assertThrows(InvalidAccessException.class, () -> t2.find(30));
		Assertions.assertThrows(InvalidAccessException.class, () -> t2.find(18));
		Assertions.assertThrows(InvalidAccessException.class, () -> t2.find(31));
		Assertions.assertThrows(InvalidAccessException.class, () -> t2.find(13));
		Assertions.assertThrows(InvalidAccessException.class, () -> t2.find(4));
		Assertions.assertThrows(InvalidAccessException.class, () -> t2.find(0));

		// Invalid key: (Throws InvalidAccessException because list is also empty and
		// that gets checked first.)
		Assertions.assertThrows(InvalidAccessException.class, () -> t2.find("WRONG"));
		Assertions.assertThrows(ValueException.class, () -> t1.find(null));

		// String Tree:
		Assertions.assertEquals(true, t3.find("Scar"));
		Assertions.assertEquals(false, t3.find("Freddy Krueger"));

	}

	@Test
	public void testRemove() throws ValueException, InvalidAccessException {

		// Tree 1:
		Assertions.assertEquals(true, t1.remove(18));
		Assertions.assertEquals(true, t1.remove(1));
		Assertions.assertEquals(15, t1.getParent(5));
		Assertions.assertEquals(true, t1.remove(32));
		Assertions.assertEquals(111, t1.getParent(31));
		Assertions.assertEquals(true, t1.remove(30));
		Assertions.assertEquals(31, t1.getParent(15));
		Assertions.assertEquals(false, t1.remove(4));
		Assertions.assertEquals(false, t1.remove(0));
		Assertions.assertEquals(7, t1.size());

		// Invalid key:
		Assertions.assertThrows(ValueException.class, () -> t1.remove("WRONG"));
		Assertions.assertThrows(ValueException.class, () -> t1.remove(null));

		// Tree 2: (empty)
		Assertions.assertEquals(false, t1.remove(41));
		Assertions.assertEquals(false, t1.remove(0));
		Assertions.assertEquals(false, t1.remove(12));
		Assertions.assertEquals(false, t1.remove(-1));
		Assertions.assertEquals(0, t2.size());

		// Empty tree remove: Access not possible
		Assertions.assertThrows(InvalidAccessException.class, () -> t2.remove(1));
		Assertions.assertThrows(InvalidAccessException.class, () -> t2.remove("NoTree :( "));

		// String Tree:
		Assertions.assertEquals(true, t3.remove("Scar"));
		Assertions.assertEquals(false, t3.remove("Freddy Krueger"));

	}

	@Test
	public void testSize() throws ValueException, InvalidAccessException {

		// Tree 1:
		Assertions.assertEquals(11, t1.size());
		t1.remove(31);
		t1.remove(23);
		Assertions.assertEquals(9, t1.size());

		// Tree 2:
		Assertions.assertEquals(0, t2.size());

		// String Tree:
		Assertions.assertEquals(4, t3.size());

	}

	@Test
	public void testGetParent() {

		// Tree 1:
		Assertions.assertEquals(17, t1.getParent(18));
		Assertions.assertEquals(Integer.MIN_VALUE, t1.getParent(30));
		Assertions.assertEquals(Integer.MIN_VALUE, t1.getParent(70));
		Assertions.assertEquals(15, t1.getParent(23));
		Assertions.assertEquals(23, t1.getParent(25));
		Assertions.assertEquals(1, t1.getParent(5));

		// Tree 2:
		Assertions.assertEquals(Integer.MIN_VALUE, t2.getParent(3));
		Assertions.assertEquals(Integer.MIN_VALUE, t2.getParent(11));
		Assertions.assertEquals(Integer.MIN_VALUE, t2.getParent(30));
		Assertions.assertEquals(Integer.MIN_VALUE, t2.getParent(15));
		Assertions.assertEquals(Integer.MIN_VALUE, t2.getParent(2));
		Assertions.assertEquals(Integer.MIN_VALUE, t2.getParent(18));

		// String Tree:
		Assertions.assertEquals("Joker", t3.getParent("Scar"));
		Assertions.assertEquals(Integer.MIN_VALUE, t3.getParent("Freddy Krueger"));

	}

	@Test
	public void testToArray() {

		// Tree 1:
		Comparable[] expectedAsc = { 1, 5, 15, 17, 18, 23, 25, 30, 31, 32, 111 };
		Assertions.assertArrayEquals(expectedAsc, t1.toArray(true));
		Comparable[] expectedRev = { 111, 32, 31, 30, 25, 23, 18, 17, 15, 5, 1 };
		Assertions.assertArrayEquals(expectedRev, t1.toArray(false));

		// Tree 2:
		Comparable[] expectedAsc2 = null;
		Comparable[] expectedRev2 = null;
		Assertions.assertArrayEquals(expectedAsc2, t2.toArray(true));
		Assertions.assertArrayEquals(expectedRev2, t2.toArray(false));

		// String Tree:
		Comparable[] expectedAsc3 = { "Joker", "Scar", "Thanos", "Voldemort" };
		Comparable[] expectedRev3 = { "Voldemort", "Thanos", "Scar", "Joker" };

		Assertions.assertArrayEquals(expectedAsc3, t3.toArray(true));
		Assertions.assertArrayEquals(expectedRev3, t3.toArray(false));
	}

	@Test
	public void testToArrayPostOrder() {

		// Tree 1:
		Comparable[] expected1 = { 5, 1, 18, 17, 25, 23, 15, 31, 111, 32, 30 };
		Assertions.assertArrayEquals(expected1, t1.toArrayPostOrder());

		// Tree 2:
		Comparable[] expected2 = null;
		Assertions.assertArrayEquals(expected2, t2.toArrayPostOrder());

		// String Tree:
		Comparable[] expected3 = { "Scar", "Joker", "Voldemort", "Thanos" };
		Assertions.assertArrayEquals(expected3, t3.toArrayPostOrder());

	}

	@Test
	public void testToArrayPreOrder() {

		// Tree 1:
		Comparable[] expected1 = { 30, 15, 1, 5, 23, 17, 18, 25, 32, 31, 111 };
		Assertions.assertArrayEquals(expected1, t1.toArrayPreOrder());

		// Tree 2:
		Comparable[] expected2 = null;
		Assertions.assertArrayEquals(expected2, t2.toArrayPreOrder());

		// String Tree:
		Comparable[] expected3 = { "Thanos", "Joker", "Scar", "Voldemort" };
		Assertions.assertArrayEquals(expected3, t3.toArrayPreOrder());

	}

	@Test
	public void testMax() {

		// Tree 1:
		int expected1 = 111;
		Assertions.assertEquals(expected1, t1.max());

		// Tree 2:
		int expected2 = Integer.MIN_VALUE;
		Assertions.assertEquals(expected2, t2.max());

		// Tree 3 (String):
		String expected3 = "Voldemort";
		Assertions.assertEquals(expected3, t3.max());

	}

	@Test
	public void testMin() {

		// Tree 1:
		int expected1 = 1;
		Assertions.assertEquals(expected1, t1.min());

		// Tree 2:
		int expected2 = Integer.MIN_VALUE;
		Assertions.assertEquals(expected2, t2.min());

		// Tree 3 (String):
		String expected3 = "Joker";
		Assertions.assertEquals(expected3, t3.min());

	}

	@Test
	public void testToString() {

		// Tree 1: Shown in console to be reviewed (30 == Root)
		System.out.print(t1.toString() + "\n\n\n");
		System.out.print(t3.toString());
		Assertions.assertEquals("\n" + "              30      \n" + "\n" + "    15            32  \n" + "\n"
				+ "1        23    31  111\n" + "\n" + "  5  17    25        \n" + "\n" + "        18            \n"
				+ "", t1.toString());

		// Tree 2:
		Assertions.assertEquals(null, t2.toString());

		// Tree 2:
		Assertions.assertEquals("\n" + "    Thanos  \n" + "\n" + "Joker    Voldemort\n" + "\n" + "  Scar    \n" + "",
				t3.toString());

	}

}
