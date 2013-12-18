package Base;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public abstract class BasePanelMenu extends JPanel {

	protected abstract void initComponents();	
	protected abstract void updateComponents();
	protected abstract void updateModel();
	protected abstract void initToolTips();
		
	protected ImageIcon IMG_HELP = new ImageIcon("img/help16x16.png");
	protected BasePanelModel panelModel = null;
	
	protected BasePanelMenu(BasePanelModel value) {
		panelModel = value;
	}
}