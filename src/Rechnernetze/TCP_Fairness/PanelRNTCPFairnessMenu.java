/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Fairness;

import Base.BasePanelMenu;
import Base.BasePanelModel;

public class PanelRNTCPFairnessMenu extends BasePanelMenu {

	private IFairnessManagement fairness;
	
	/**
	 * Create the panel.
	 */
	public PanelRNTCPFairnessMenu(IFairnessManagement ifairness, BasePanelModel model) {
		super(model);
		if (ifairness == null) {
			ifairness = new FairnessManagement();
		}
		fairness = ifairness;
	}

	@Override
	protected void initComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void updateComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initToolTips() {
		// TODO Auto-generated method stub
		
	}

}
