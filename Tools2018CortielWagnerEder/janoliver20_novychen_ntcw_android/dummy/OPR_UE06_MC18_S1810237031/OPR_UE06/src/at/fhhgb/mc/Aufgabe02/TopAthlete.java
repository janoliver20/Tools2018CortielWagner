package at.fhhgb.mc.Aufgabe02;

public class TopAthlete extends ActiveMember {

	public TopAthlete(int activityLevel, String name) throws ValueException {
		super(activityLevel, name);

	}

	@Override
	public double getIncome() {

		return 120;
	}

	@Override
	public double getCosts() {
		return getActivityLevel() * 5 * 12;
	}

}