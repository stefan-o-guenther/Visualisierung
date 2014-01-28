/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public abstract class BasePanelMenu extends BasePanelUseModel {

	private static final long serialVersionUID = 1L;
	
	protected abstract void initComponents();
	protected abstract void updateComponents();
	protected abstract void initToolTips();	
	
	protected ImageIcon IMG_HELP = ImageLoader.getImageIconHelp16();
	protected ImageIcon IMG_RABBIT = ImageLoader.getImageIconRabbit();
	protected ImageIcon IMG_TURTLE = ImageLoader.getImageIconTurtle();
		
	public BasePanelMenu(BasePanelModel model) {
		super(model);		
	}
	
	protected void updateView() {
		updateComponents();
		updateModel();
	}	
}