package Betriebssysteme.Belegungsstrategien;

import Base.PanelAbstract;
import Base.PanelBuilderAbstract;
import Base.PanelMenuControlBoxImpl;

public class PanelBuilderFragmentationImpl extends PanelBuilderAbstract	implements PanelBuilderFragmentation {

	public PanelBuilderFragmentationImpl(ManagementFragmentation fragmentation) {
		super(fragmentation);
	}

	@Override
	protected void createPanelMenu() {
		ManagementFragmentation fragmentation = (ManagementFragmentation) this.management;
		PanelAbstract panelLeft = new PanelBSBelegungsstrategienMenuImpl(fragmentation);
		PanelAbstract panelRight = new PanelMenuControlBoxImpl(fragmentation);
		panelMenu = this.getPanelCouple(panelLeft, panelRight);		
	}

	@Override
	protected void createPanelModel() {
		ManagementFragmentation fragmentation = (ManagementFragmentation) this.management;
		panelModel = new PanelBSBelegungsstrategienModelImpl(fragmentation);
	}
}
