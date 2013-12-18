package Base;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;

public abstract class BaseFrame extends JFrame {
	
	protected final int LENGTH = 1024;
	protected final int HEIGHT = 768;
	
	protected void showWindowCenterScreen() {
		// Get the size of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
         
        // Determine the new location of the window
        int w = getSize().width;
        int h = getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
         
        // Move the window
        setLocation(x, y); 
	}
	
	protected void initWindowSize() {
		setSize(LENGTH, HEIGHT);
	}
	
	protected void initUI(String title, JPanel panel) {
		if (title == null) {
			title = "";
		}		
		setTitle(title);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initWindowSize();
        showWindowCenterScreen();
        add(panel);
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
    	SwingUtilities.invokeLater(new Runnable() {
        	public void run() {
            	try {            		
            		frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}            	
            }
        });		
	}	
}
