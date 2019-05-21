package at.fhhgb.mc.Aufgabe02test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import at.fhhgb.mc.Aufgabe02.ActiveMember;
import at.fhhgb.mc.Aufgabe02.Trainer;
import at.fhhgb.mc.Aufgabe02.ValueException;

public class TrainerTest {

	private static Trainer t1, t2, t3, t4;

	@BeforeEach
	public void setUp() throws ValueException {

		t1 = new Trainer(0, "Jan Cortiel");
		t2 = new Trainer(7, "John Oliver");

		// Invalid values in constructor call:
		Assertions.assertThrows(ValueException.class, () -> t3 = new Trainer(-1, "Jan Cortiel"));
		Assertions.assertThrows(ValueException.class, () -> t4 = new Trainer(11, "Jan Cortiel"));

	}

	@Test
	public void getIncomeTest() {

		Assertions.assertEquals(120, t1.getIncome());
		Assertions.assertEquals(120, t2.getIncome());

	}

	@Test
	public void getCostsTest() {

		Assertions.assertEquals(0, t1.getCosts());
		Assertions.assertEquals(3360, t2.getCosts());

	}

	@Test
	public void getSurplusTest() {

		Assertions.assertEquals(120, t1.getSurplus());
		Assertions.assertEquals(-3240, t2.getSurplus());

	}

	@Test
	public void toStringTest() {

		// Note: I did not test the toString with junit assertions but I
		// printed the different members to the console in order so see the
		// results.
		// With the boolean ascending the user can decide if he wants to print the
		// income, costs and surplus in an ascending order or in a descending order.

		// Ascending Test:

		System.out.print(t1.toString());

		System.out.print(t2.toString());

		// Descending Test:

		System.out.print(t1.toString(false));

		System.out.print(t2.toString(false));
	}

}
