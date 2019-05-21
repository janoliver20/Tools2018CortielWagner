package at.fhhgb.mc.Aufgabe02;

public class AmateurAthlete extends ActiveMember {

	public AmateurAthlete(int activityLevel, String name) throws ValueException {
		super(activityLevel, name);

	}

	@Override
	public double getActivityLevel() {

		return super.getActivityLevel();
	}

	@Override
	public double getIncome() {

		return 25 * 12;
	}

	@Override
	public double getCosts() {

		return getActivityLevel() * 2.5 * 12;
	}

}