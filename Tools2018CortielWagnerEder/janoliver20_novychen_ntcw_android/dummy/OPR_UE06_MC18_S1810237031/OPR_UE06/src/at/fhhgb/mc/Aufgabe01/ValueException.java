package at.fhhgb.mc.Aufgabe01;

public class ValueException extends Exception {

	private int val;

	// think of how you could pass the information on the base class...
	public ValueException(int _whichVal) {
		super("Invalid int:" + _whichVal);
		val = _whichVal;

	}

	public int getVal() {
		return val;
	}

}
