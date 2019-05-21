package at.fhhgb.mc.Aufgabe02;

public abstract class ActiveMember extends AbstractMember {

	private int activityLevel;

	public ActiveMember(int activityLevel, String name) throws ValueException {
		super(name);

		if (activityLevel < 0 || activityLevel > 10) {
			throw new ValueException(activityLevel);
		} else {
			this.activityLevel = activityLevel;
		}
	}

	public double getActivityLevel() {
		return activityLevel;
	}

	@Override
	public double getIncome() {
		return 0;
	}

	@Override
	public double getCosts() {
		return 0;
	}

}
