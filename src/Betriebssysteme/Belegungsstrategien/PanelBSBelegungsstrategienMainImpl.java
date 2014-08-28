/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import Base.PanelMainAbstract;
import Base.PanelMenuAbstract;
import Base.PanelModelAbstract;

public class PanelBSBelegungsstrategienMainImpl extends PanelMainAbstract {
		
	public PanelBSBelegungsstrategienMainImpl() {
		super(new ManagementFragmentationImpl(), new ToolTipManagerFragmentationImpl());
	}
	
	@Override
	protected PanelMenuAbstract getNewPanelMenu() {
		ManagementFragmentation memory = (ManagementFragmentation) this.getManagement();
		ToolTipManagerFragmentation tooltip = (ToolTipManagerFragmentation) this.getToolTipManager();
		return new PanelBSBelegungsstrategienMenuAutomaticBoxImpl(memory, tooltip);
	}

	@Override
	protected PanelModelAbstract getNewPanelModel() {
		ManagementFragmentation memory = (ManagementFragmentation) this.getManagement();
		ToolTipManagerFragmentation tooltip = (ToolTipManagerFragmentation) this.getToolTipManager();
		return new PanelBSBelegungsstrategienModelImpl(memory, tooltip);
	}
}