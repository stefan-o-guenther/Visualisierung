/**
 * @author:	Stefan Otto Günther
 * @date:	14.01.2014
 */

package Visualisierungen;

import Base.ToolTipManagerAbstract;

public class ToolTipManagerDefaultImpl extends ToolTipManagerAbstract implements ToolTipManagerDefault {

	private static ToolTipManagerDefault instance = new ToolTipManagerDefaultImpl();
	
	private ToolTipManagerDefaultImpl() {
		
	}
	
	public static ToolTipManagerDefault getInstance() {
		return instance;
	}	
	
	@Override
	public String getToolTipTitle() {
		return "";
	}

}
