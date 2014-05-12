package Hauptprogramm;

import Base.ToolTipManagerAbstract;

public class ToolTipManagerDefaultImpl extends ToolTipManagerAbstract implements ToolTipManagerDefault {

	@Override
	public String getToolTipTitle() {
		String tooltipTitle = ""
				+ "<html>"
	        	+ "Start.<br>"
	        	+ "</html>";
			return tooltipTitle;
	}
}