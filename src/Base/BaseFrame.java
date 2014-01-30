/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;

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
	
	/*
	
	    // Bildschirmgröße ein guter Ausgangswert
        Dimension _screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
     
        // Hier kommt im Netz selten gefundene Zeile: Das sichtbare Rechteck!
        Rectangle _maxBounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
       
        // Jetzt kann man die Ränder berechnen...
        Insets _screenInsets =
          new Insets((int)_maxBounds.getY(), (int)_maxBounds.getX(), (int)(_screenDimension.getHeight() -
                                                                           _maxBounds.getY() - _maxBounds.getHeight()),
                     (int)(_screenDimension.getWidth() - _maxBounds.getWidth() - _maxBounds.getX()));
     
        // ... und die Dimensionen der sichtbaren Bildschirmoberfläche.
        Dimension _screenDimensionView =
          new Dimension((int)(_screenDimension.getWidth() - _screenInsets.right - _screenInsets.left),
                        (int)(_screenDimension.getHeight() - _screenInsets.top - _screenInsets.bottom));
       
        // nun ist ein Fenster mit exakter 75%iger Breite und Höhe und richtig zentiert in greifbarer Nähe:
        new JFrame("Test"){
          {
              this.setSize( (int) (_screenDimensionView.getWidth() *.75 ),  (int) (_screenDimensionView.getHeight() *.75 )  );
              this.setLocation((int)((_screenDimensionView.getWidth() - _widthPixels) / 2) + _screenInsets.left,
                               (int)((_screenDimensionView.getHeight() - _heightPixels) / 2) + _screenInsets.top);
              this.setVisible(true);
          }
        }
	
	*/
	
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
