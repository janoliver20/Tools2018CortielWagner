package at.fhhgb.mc.Aufgabe02test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import at.fhhgb.mc.Aufgabe02.ActiveMember;
import at.fhhgb.mc.Aufgabe02.AmateurAthlete;
import at.fhhgb.mc.Aufgabe02.ValueException;

public class AmateurAthleteTest {

	private static AmateurAthlete aA1, aA2, aA3, aA4;

	@BeforeEach
	public void setUp() throws ValueException {

		aA1 = new AmateurAthlete(0, "Jan Cortiel");
		aA2 = new AmateurAthlete(7, "John Oliver");

		// Invalid values in constructor call:
		Assertions.assertThrows(ValueException.class, () -> aA3 = new AmateurAthlete(-1, "Jan Cortiel"));
		Assertions.assertThrows(ValueException.class, () -> aA4 = new AmateurAthlete(11, "Jan Cortiel"));

	}

	@Test
	public void getActivityLevelTest() {

		Assertions.assertEquals(0, aA1.getActivityLevel());
		Assertions.assertEquals(7, aA2.getActivityLevel());

	}

	@Test
	public void getIncomeTest() {

		Assertions.assertEquals(300, aA1.getIncome());
		Assertions.assertEquals(300, aA2.getIncome());

	}

	@Test
	public void getCostsTest() {

		Assertions.assertEquals(0, aA1.getCosts());
		Assertions.assertEquals(7 * 2.5 * 12, aA2.getCosts());

	}

	@Test
	public void getSurplusTest() {

		Assertions.assertEquals(300, aA1.getSurplus());
		Assertions.assertEquals(90, aA2.getSurplus());

	}

	@Test
	public void toStringTest() {

		// Note: I did not test the toString with junit assertions but I
		// printed the different members to the console in order so see the
		// results.
		// With the boolean ascending the user can decide if he wants to print the
		// income, costs and surplus in an ascending order or in a descending order.

		// Ascending Test:

		System.out.print(aA1.toString());

		System.out.print(aA2.toString());

		// Descending Test:

		System.out.print(aA1.toString(false));

		System.out.print(aA2.toString(false));
	}

}
