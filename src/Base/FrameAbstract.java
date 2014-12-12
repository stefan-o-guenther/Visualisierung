/**
 * @author:	Stefan Otto Günther
 * @date:	14.01.2014
 */

package Base;

import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JFrame;

public class FrameAbstract extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public FrameAbstract(PanelMainAbstract panelMain) {
		super();
		try {
			Checker.checkIfNotNull(panelMain);
			this.panelMain = panelMain;
			
			Rectangle maxBounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
			
			width = 1024;
			if (width > maxBounds.width) {
				width = maxBounds.width;
			}			
			
			height = 768;
			if (height > maxBounds.height) {
				height = maxBounds.height;
			}
		} catch (Exception ex) {
			throw ex;
		}		
	}
	
	protected int width;
	protected int height;		
	
	private PanelMainAbstract panelMain;

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
	
	protected void initUI() {
		setTitle(panelMain.getTitle());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		initWindowSize();
		showWindowCenterScreen();
		add(panelMain);
	}
	
	protected void initWindowSize() {	
		setSize(width, height);
	}
}
