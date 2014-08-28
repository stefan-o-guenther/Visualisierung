package Rechnernetze.Dijkstra;

import Base.PanelMenuBoxStandardAbstract;
import Base.PanelMenuMenuAbstract;

public class PanelRNDijkstraAlgorithmMenuAutomaticBoxImpl extends PanelMenuBoxStandardAbstract {

	public PanelRNDijkstraAlgorithmMenuAutomaticBoxImpl(ManagementDijkstraAlgorithm dijkstra, ToolTipManagerDijkstraAlgorithm tooltip) {
		super(dijkstra, tooltip);
	}

	@Override
	protected PanelMenuMenuAbstract getNewPanelMenuAutomaticMenu() {
		ManagementDijkstraAlgorithm dijkstra = (ManagementDijkstraAlgorithm) this.getManagement();
		ToolTipManagerDijkstraAlgorithm tooltip = (ToolTipManagerDijkstraAlgorithm) this.getToolTipManager();
		return new PanelRNDijkstraAlgorithmMenuAutomaticMenuImpl(dijkstra, tooltip);
	}	
}
