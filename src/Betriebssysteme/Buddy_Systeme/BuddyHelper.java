/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

public class BuddyHelper {

	public static Integer getPotence(Integer value) {
		try {
			if (value == null) {
				throw new NullPointerException();
			}
			if (value < 0) {
				throw new IllegalArgumentException();
			}
			if (value.equals(0)) {
				return 1;
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
		} catch (Exception ex) {
			throw ex;
		}
	}
}