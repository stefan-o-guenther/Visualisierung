/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;

public abstract class FrameAbstract extends JFrame {
	
	public FrameAbstract(String title) {
		super();
		try {		
			if (title == null) {
				throw new NullPointerException();
			}
			this.title = title;
		} catch (Exception ex) {
			throw ex;
		}		
		Rectangle maxBounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		
		if (width > maxBounds.width) {
			width = maxBounds.width;
		}
		
		if (height > maxBounds.height) {
			height = maxBounds.height;
		}		
	}
	
	private static final long serialVersionUID = 1L;
	
	protected int width = 1024;
	protected int height = 768;
	protected String title = "";
	
	protected void showWindowCenterScreen() {
		// Get the size of the screen
		Rectangle maxBounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		
		int xScreen = maxBounds.x;
		int yScreen = maxBounds.y;
		int heightScreen = maxBounds.height;
		int widthScreen = maxBounds.width;
		
		int heightWindow = height;
		int widthWindow = width;
		
		int heightDif = heightScreen - heightWindow;
		int widthDif = widthScreen - widthWindow;
		
		int xWindow = (heightDif / 2) + xScreen;
		int yWindow = (widthDif / 2) + yScreen;
		
		// Move the window
        setLocation(xWindow, yWindow); 
	}
	
	protected void initUI(JPanel panel) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		initWindowSize();
		showWindowCenterScreen();
		add(panel);
	}
	
	protected void initWindowSize() {	
		setSize(width, height);
	}
}
