/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;

public abstract class BaseFrame extends JFrame {
	
	public BaseFrame(String value) {
		super();
		if (value == null) {
			value = "";
		}
		title = value;
		
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
	
	protected static void initToolTipManager() {
		ToolTipManager.sharedInstance().setDismissDelay(2147483647);
		ToolTipManager.sharedInstance().setInitialDelay(0);
	}
	
	protected static void initLookAndFeel() {		
		try {
			Boolean nimbus = false;
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					nimbus = true;
					break;
				}
			}
			if (!(nimbus)) {
				UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	protected static void baseMain(final JFrame frame) {		
		/* Create and display the form */
    	SwingUtilities.invokeLater(new RunFrame(frame));		
	}	
}
