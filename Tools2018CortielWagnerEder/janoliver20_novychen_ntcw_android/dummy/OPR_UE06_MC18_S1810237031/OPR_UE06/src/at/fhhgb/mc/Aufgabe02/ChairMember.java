package at.fhhgb.mc.Aufgabe02;

public class ChairMember extends AbstractMember {

	private int competenceLevel;

	public ChairMember(int competenceLevel, String name) throws ValueException {
		super(name);

		if (competenceLevel < 0 || competenceLevel > 10) {
			throw new ValueException(competenceLevel);
		} else {
			this.competenceLevel = competenceLevel;
		}

	}

	@Override
	public double getIncome() {
		return 100 * competenceLevel;
	}

	@Override
	public double getCosts() {

		return 0.2 * getIncome();
	}

}
