package at.fhhgb.mc.Aufgabe02;

public class Trainer extends ActiveMember {

	public Trainer(int activityLevel, String name) throws ValueException {
		super(activityLevel, name);

	}

	@Override
	public double getActivityLevel() {

		return super.getActivityLevel();
	}

	@Override
	public double getIncome() {

		return 120;
	}

	@Override
	public double getCosts() {

		return getActivityLevel() * 40 * 12;
	}

}
