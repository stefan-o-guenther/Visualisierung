/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import Base.FrameAbstract;

public class FrameBSBuddySystemeImpl extends FrameAbstract {

	public FrameBSBuddySystemeImpl() {
        super("Buddy Systeme");
        initUI(new PanelBSBuddySystemeMainImpl());
    }
}
