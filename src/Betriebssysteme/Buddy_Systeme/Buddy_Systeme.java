/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import Base.FrameMainImpl;
import Base.MainAbstract;

public class Buddy_Systeme extends MainAbstract {

	public Buddy_Systeme() {
		super();
	}
	
	public static void main(String[] args) {
		initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameMainImpl(new ManagementBuddyMemoryAllocationImpl()));	
    }
}