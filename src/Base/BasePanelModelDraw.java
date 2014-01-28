/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import java.awt.Graphics;


public abstract class BasePanelModelDraw extends BasePanelModel {	
	
	private static final long serialVersionUID = 1L;

	protected abstract void doDrawing(Graphics g);
	protected abstract void updateData();
	
	public BasePanelModelDraw() {
		super();
	}
	
	@Override
	public void paintComponent(Graphics g) {        
        super.paintComponent(g);
        doDrawing(g);
    }
}
