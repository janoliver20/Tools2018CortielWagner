package at.fhhgb.mc.Aufgabe02test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import at.fhhgb.mc.Aufgabe02.ActiveMember;
import at.fhhgb.mc.Aufgabe02.ChairMember;
import at.fhhgb.mc.Aufgabe02.ValueException;

public class ChairMemberTest {

	private static ChairMember cM1, cM2, cm3, cm4;

	@BeforeEach
	public void setUp() throws ValueException {

		cM1 = new ChairMember(0, "Jan Cortiel");
		cM2 = new ChairMember(7, "John Oliver");
		// Invalid values in constructor call:
		Assertions.assertThrows(ValueException.class, () -> cM2 = new ChairMember(-1, "Jan Cortiel"));
		Assertions.assertThrows(ValueException.class, () -> cm4 = new ChairMember(11, "Jan Cortiel"));
	}

	@Test
	public void getIncomeTest() {

		Assertions.assertEquals(0, cM1.getIncome());
		Assertions.assertEquals(700, cM2.getIncome());

	}

	@Test
	public void getCostsTest() {

		Assertions.assertEquals(0, cM1.getCosts());
		Assertions.assertEquals(140, cM2.getCosts());

	}

	@Test
	public void getSurplusTest() {

		Assertions.assertEquals(0, cM1.getSurplus());
		Assertions.assertEquals(560, cM2.getSurplus());

	}

	@Test
	public void toStringTest() {

		// Note: I did not test the toString with junit assertions but I
		// printed the different members to the console in order so see the
		// results.
		// With the boolean ascending the user can decide if he wants to print the
		// income, costs and surplus in an ascending order or in a descending order.

		// Ascending Test:

		System.out.print(cM1.toString());

		System.out.print(cM2.toString());

		// Descending Test:

		System.out.print(cM1.toString(false));

		System.out.print(cM2.toString(false));
	}

}
