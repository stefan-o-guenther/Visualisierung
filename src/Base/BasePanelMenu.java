package Base;

import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public abstract class BasePanelMenu extends BasePanelUseModel {
	
	private ImageIcon getHelp() {
		ImageIcon icon = null;
		try {
			InputStream stream = BasePanelMenu.class.getResourceAsStream("img/16x16_help.png");
			icon = new ImageIcon(ImageIO.read(stream));				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return icon;
	}
	
	private ImageIcon getRabbit() {
		ImageIcon icon = null;
		try {
			InputStream stream = BasePanelMenu.class.getResourceAsStream("img/rabbit.png");
			icon = new ImageIcon(ImageIO.read(stream));				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return icon;
	}
	
	private ImageIcon getTurtle() {
		ImageIcon icon = null;
		try {
			InputStream stream = BasePanelMenu.class.getResourceAsStream("img/turtle.png");
			icon = new ImageIcon(ImageIO.read(stream));				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return icon;
	}
	
	protected abstract void initComponents();
	protected abstract void updateComponents();
	protected abstract void initToolTips();	
	
	protected ImageIcon IMG_HELP = getHelp();
	protected ImageIcon IMG_RABBIT = getRabbit();
	protected ImageIcon IMG_TURTLE = getTurtle();
		
	protected BasePanelMenu(BasePanelModel model) {
		super(model);
	}
	
	protected void updateView() {
		updateComponents();
		updateModel();
	}
	
	
}