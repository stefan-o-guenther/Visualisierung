/**
 * @author:	Stefan Otto Günther
 * @date:	12.05.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import Base.ToolTipManager;

public interface ToolTipManagerPaging extends ToolTipManager {

	String getToolTipStrategy();
	String getToolTipReference();
	String getToolTipRam();
	String getToolTipDisk();
	String getToolTipPagingError();
	String getToolTipR();
	String getToolTipM();
}
