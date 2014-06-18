package Rechnernetze.Dijkstra;

import Base.PanelMenuAutomaticBoxAbstract;
import Base.PanelMenuAutomaticControlImpl;
import Base.PanelMenuAutomaticMenuAbstract;

public class PanelRNDijkstraAlgorithmMenuAutomaticBoxImpl extends PanelMenuAutomaticBoxAbstract {

	public PanelRNDijkstraAlgorithmMenuAutomaticBoxImpl(ManagementDijkstraAlgorithm dijkstra, ToolTipManagerDijkstraAlgorithm tooltip) {
		super(dijkstra, tooltip);
		this.initPanel();
	}

	@Override
	protected PanelMenuAutomaticMenuAbstract getNewPanelMenuAutomaticMenu() {
		ManagementDijkstraAlgorithm dijkstra = (ManagementDijkstraAlgorithm) this.getManagement();
		ToolTipManagerDijkstraAlgorithm tooltip = (ToolTipManagerDijkstraAlgorithm) this.getToolTipManager();
		return new PanelRNDijkstraAlgorithmMenuAutomaticMenuImpl(dijkstra, tooltip);
	}	
}
