package Base;

public class Checker {

	public static void checkIfNotNull(Object object) {
		if (object == null) {
			throw new NullPointerException();
		}
	}
	
	public static void checkIfString(String string) {
		checkIfNotNull(string);
		if ((string.equals("")) || (string.length() == 0)) {
			throw new IllegalArgumentException();
		}
	}
	
	public static void checkIfIntegerNotLessZero(Integer integer) {
		checkIfNotNull(integer);
		if (integer.intValue() < 0) {
			throw new IllegalArgumentException();
		}
	}
}
