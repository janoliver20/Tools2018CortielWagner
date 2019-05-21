package at.fhhgb.mc.Aufgabe02test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import at.fhhgb.mc.Aufgabe02.ActiveMember;
import at.fhhgb.mc.Aufgabe02.TopAthlete;
import at.fhhgb.mc.Aufgabe02.ValueException;

public class TopAthleteTest {

	private static TopAthlete tA1, tA2, tA3, tA4;

	@BeforeEach
	public void setUp() throws ValueException {

		tA1 = new TopAthlete(0, "Jan Cortiel");
		tA2 = new TopAthlete(7, "John Oliver");

		// Invalid values in constructor call:
		Assertions.assertThrows(ValueException.class, () -> tA3 = new TopAthlete(-1, "Jan Cortiel"));
		Assertions.assertThrows(ValueException.class, () -> tA4 = new TopAthlete(11, "Jan Cortiel"));

	}

	@Test
	public void getIncomeTest() {

		Assertions.assertEquals(120, tA1.getIncome());
		Assertions.assertEquals(120, tA2.getIncome());

	}

	@Test
	public void getCostsTest() {

		Assertions.assertEquals(0, tA1.getCosts());
		Assertions.assertEquals(420, tA2.getCosts());

	}

	@Test
	public void getSurplusTest() {

		Assertions.assertEquals(120, tA1.getSurplus());
		Assertions.assertEquals(-300, tA2.getSurplus());

	}

	@Test
	public void toStringTest() {

		// Note: I did not test the toString with junit assertions but I
		// printed the different members to the console in order so see the
		// results.
		// With the boolean ascending the user can decide if he wants to print the
		// income, costs and surplus in an ascending order or in a descending order.

		// Ascending Test:

		System.out.print(tA1.toString());

		System.out.print(tA2.toString());

		// Descending Test:

		System.out.print(tA1.toString(false));

		System.out.print(tA2.toString(false));
	}
}
