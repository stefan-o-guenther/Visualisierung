/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Hauptprogramm;

import Base.PanelModelDrawAbstract;


public class PanelDefaultModelImpl extends PanelModelDrawAbstract {

	public PanelDefaultModelImpl(ManagementDefault main, ToolTipManagerDefault tooltip) {
		super(main, tooltip);
	}
	
	protected void doDrawing() {
        g2d.drawString("Stefan Günther", 100, 100);
    }
	
	@Override
	protected void initComponents() {
		
	}   
}