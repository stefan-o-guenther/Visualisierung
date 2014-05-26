/**
 * @author:	Stefan Otto Günther
 * @date:	12.05.2014
 */

package Hauptprogramm;

public class ToolTipManagerDefaultImpl implements ToolTipManagerDefault {

	@Override
	public String getToolTipTitle() {
		String tooltipTitle = ""
				+ "<html>"
	        	+ "Start.<br>"
	        	+ "</html>";
			return tooltipTitle;
	}
}