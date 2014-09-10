/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;

public abstract class MainAbstract {

	public MainAbstract() {
		super();
	}
	
	protected static void initialize() {
		initToolTipManager();
		initLookAndFeel();
	}
	
	protected static PanelMainAbstract panelMain;
	
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
	
	protected static void baseMain() {
		try {
			if (panelMain == null) {
				throw new NullPointerException();
			}
			panelMain.updatePanel();
			JFrame frame = new FrameMainImpl(panelMain);
			SwingUtilities.invokeLater(new RunnableImpl(frame));	
		} catch (Exception ex) {
			throw ex;
		}		
	}
}
