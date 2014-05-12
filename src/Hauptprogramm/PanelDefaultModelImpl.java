/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Hauptprogramm;

import java.awt.Graphics;
import java.awt.Graphics2D;

import Base.PanelModelDrawAbstract;


public class PanelDefaultModelImpl extends PanelModelDrawAbstract {

	public PanelDefaultModelImpl(ManagementDefault main, ToolTipManagerDefault tooltip) {
		super(main, tooltip);
		putModelToManagement();
		updateModel();
	}
	
	public void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawString("Stefan G�nther", 100, 100);
    }
	
	@Override
	protected void initComponents() {
				
	}   
}