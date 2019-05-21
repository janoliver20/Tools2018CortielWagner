package at.fhhgb.mc.Aufgabe02;

import java.util.Arrays;

abstract public class AbstractMember implements Comparable<AbstractMember> {

	private String name;

	public AbstractMember(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	abstract public double getIncome();

	abstract public double getCosts();

	public double getSurplus() {
		return this.getIncome() - this.getCosts();
	}

	public String toString(boolean ascending) {

		StringBuilder s = new StringBuilder();
		int memberSpaceLength = 0;

		if (this instanceof AmateurAthlete) {
			memberSpaceLength = 100;
			s.append(spaces(memberSpaceLength) + "-Amateur Athlete--------\n");
		} else if (this instanceof ChairMember) {
			s.append(spaces(memberSpaceLength) + "-Chair Member-----------\n");
		} else if (this instanceof HonoraryMember) {
			memberSpaceLength = 25;
			s.append(spaces(memberSpaceLength) + "-Honorary Member--------\n");
		} else if (this instanceof SupportingMember) {
			memberSpaceLength = 125;
			s.append(spaces(memberSpaceLength) + "-Supporting Member------\n");
		} else if (this instanceof Trainer) {
			memberSpaceLength = 50;
			s.append(spaces(memberSpaceLength) + "-Trainer----------------\n");
		} else {
			memberSpaceLength = 75;
			s.append(spaces(memberSpaceLength) + "-Top Athlete------------\n");
		}

		s.append(spaces(memberSpaceLength) + "Name: " + this.name + "\n");
		Double income = getIncome();
		Double costs = getCosts();
		Double surplus = getSurplus();
		Double[] stats = { income, costs, surplus };
		boolean incomeTest = false;
		boolean costsTest = false;

		Arrays.sort(stats);

		if (ascending) {

			for (int i = 0; i < stats.length; i++) {

				if (stats[i] == getIncome() && !incomeTest) {
					s.append(spaces(memberSpaceLength) + "Income:  ");
					incomeTest = true;
				} else if (stats[i] == getCosts() && !costsTest) {
					s.append(spaces(memberSpaceLength) + "Costs:   ");
					costsTest = true;
				} else {
					s.append(spaces(memberSpaceLength) + "Surplus: ");

				}
				s.append(stats[i].toString() + "€\n");
			}

		} else {

			for (int i = 2; i > -1; i--) {

				if (stats[i] == getIncome() && !incomeTest) {
					s.append(spaces(memberSpaceLength) + "Income:  ");
					incomeTest = true;
				} else if (stats[i] == getCosts() && !costsTest) {
					s.append(spaces(memberSpaceLength) + "Costs:   ");
					costsTest = true;
				} else {
					s.append(spaces(memberSpaceLength) + "Surplus: ");
				}
				s.append(stats[i].toString() + "€\n");
			}

		}
		s.append(spaces(memberSpaceLength) + "------------------------\n");
		return s.toString();

	}

	public String toString() {
		return this.toString(true);
	}

	private String spaces(int memberType) {

		StringBuilder s = new StringBuilder();
		for (int i = 0; i < memberType; i++) {
			s.append(" ");
		}
		return s.toString();

	}

	@Override
	public int compareTo(AbstractMember other) {

		return this.name.compareTo(other.name);

	}


}
