package Betriebssysteme.Buddy_Systeme;

public class BuddyHelper {

	public static Integer getPotence(Integer value) {
		if ((value == null) || (value < 1)) {
			value = 1;
		}
		Boolean notFound = true;		
		Integer i = 0;
		do {
			Integer x = (int) Math.pow(2, i);
			if (value <= x) {
				notFound = false;
			} else {
				notFound = true;
				i += 1;
			}			
		} while (notFound);		
		return i;
	}
}
