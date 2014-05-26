/**
 * @author:	Stefan Otto Günther
 * @date:	12.05.2014
 */

package Betriebssysteme.Buddy_Systeme;

import Base.ToolTipManager;

public interface ToolTipManagerBuddyMemoryAllocation extends ToolTipManager {

	String getToolTipSpaceSize();
	String getToolTipProcessName();
	String getToolTipProcessSize();
	String getToolTipLoadExample();
}
