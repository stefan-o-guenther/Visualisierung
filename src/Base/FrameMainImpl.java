/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JFrame;

public class FrameMainImpl extends JFrame {
	
	public FrameMainImpl(Management management) {
		super();
		try {		
			if (management == null) {
				throw new NullPointerException();
			}
			Rectangle maxBounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
			
			if (width > maxBounds.width) {
				width = maxBounds.width;
			}			
			if (height > maxBounds.height) {
				height = maxBounds.height;
			}
			initUI(management);
		} catch (Exception ex) {
			throw ex;
		}		
	}
	
	private static final long serialVersionUID = 1L;
	
	protected int width = 1024;
	protected int height = 768;	
	
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
	
	protected void initUI(Management management) {
		setTitle(management.getTitle());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		initWindowSize();
		showWindowCenterScreen();
		add(new PanelMainImpl(management));
	}
	
	protected void initWindowSize() {	
		setSize(width, height);
	}
}
