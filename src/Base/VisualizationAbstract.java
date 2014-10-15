/**
 * @author:	Stefan Otto Günther
 * @date:	14.01.2014
 */

package Base;

public class VisualizationAbstract extends MainAbstract {

	public VisualizationAbstract() {
		super();
	}
	
	protected static void baseVisualization(PanelMainAbstract panelMain) {
		try {
			if (panelMain == null) {
				throw new NullPointerException();
			}
			panelMain.updatePanel();
			FrameAbstract frame = new FrameVisualizationImpl(panelMain);
			baseMain(frame);	
		} catch (Exception ex) {
			throw ex;
		}		
	}
}
