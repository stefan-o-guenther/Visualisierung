/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import java.awt.Graphics;


public abstract class BasePanelModelDraw extends BasePanelModel implements IPanelModelDraw {	
	
	public BasePanelModelDraw(IManagement management) {
		super(management);
	}
	
	@Override
	public void paintComponent(Graphics g) {        
        super.paintComponent(g);
        doDrawing(g);
    }
}
