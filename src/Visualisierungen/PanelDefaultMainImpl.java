/**
 * @author:	Stefan Otto Günther
 * @date:	14.01.2014
 */

package Visualisierungen;

import Base.PanelAbstract;
import Base.PanelMainAbstract;

public class PanelDefaultMainImpl extends PanelMainAbstract {

	private static final long serialVersionUID = 1L;

	public PanelDefaultMainImpl() {
		super(ManagementDefaultImpl.getInstance());
		this.createPanel();
	}

	@Override
	protected PanelAbstract getNewPanelMenu() {
		return new PanelDefaultMenuImpl();
	}

	@Override
	protected PanelAbstract getNewPanelModel() {
		return new PanelDefaultModelImpl();
	}
	
	
}
