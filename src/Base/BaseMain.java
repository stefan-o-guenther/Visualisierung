/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;

public abstract class BaseMain {

	public BaseMain() {
		super();
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
