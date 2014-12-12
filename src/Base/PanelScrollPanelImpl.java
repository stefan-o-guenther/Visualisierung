/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import java.awt.Component;

public class PanelScrollPanelImpl extends PanelScrollAbstract {

	private static final long serialVersionUID = 1L;

	public PanelScrollPanelImpl(PanelAbstract panel, EnumScrollbarPolicy scrollbarPolicyHorizontal, EnumScrollbarPolicy scrollbarPolicyVertical) {
		super(scrollbarPolicyHorizontal, scrollbarPolicyVertical);
		try {
			Checker.checkIfNotNull(panel);
			this.panel = panel;
			this.createPanel();
		} catch (Exception ex) {
			throw ex;
		}		
	}
	
	private PanelAbstract panel;	
	
	@Override
	public void updateComponent() {
		panel.updatePanel();
	}
	@Override
	public Integer getPanelHeight() {
		return panel.getPanelHeight();
	}
	@Override
	public Integer getPanelWidth() {
		return panel.getPanelWidth();
	}

	@Override
	protected Component getComponent() {
		return panel;
	}
}