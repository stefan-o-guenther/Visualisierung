/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Hauptprogramm;

import Base.PanelModelDrawAbstract;


public class PanelDefaultModelImpl extends PanelModelDrawAbstract {

	private static final long serialVersionUID = 1L;

	public PanelDefaultModelImpl(ManagementDefault main) {
		super(main);
	}
	
	protected void doDrawing() {
        g2d.drawString("Stefan G�nther", 100, 100);
    }
	
	@Override
	protected void initComponents() {
		
	}   
}