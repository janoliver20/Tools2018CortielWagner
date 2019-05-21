package at.fhhgb.mc.Aufgabe02;

public class ValueException extends Exception {

	private Comparable val;
	private int level;

	// think of how you could pass the information on the base class...
	public ValueException(Comparable _whichVal) {
		super("Invalid element:" + _whichVal);
		val = _whichVal;

	}

	public ValueException(int level) {
		super("Invalid level:" + level);
		this.level = level;

	}

	public int getLevel() {
		return level;
	}

	public Comparable getVal() {
		return val;
	}

}