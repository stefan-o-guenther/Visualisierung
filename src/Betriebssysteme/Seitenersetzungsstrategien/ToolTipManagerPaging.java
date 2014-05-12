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
