/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra;

import Base.PanelMainAbstract;
import Base.PanelMenuAbstract;
import Base.PanelModelAbstract;

public class PanelRNDijkstraAlgorithmMainImpl extends PanelMainAbstract {

	public PanelRNDijkstraAlgorithmMainImpl() {
		super(new ManagementDijkstraAlgorithmImpl(), new ToolTipManagerDijkstraAlgorithmImpl());
		initComponents();
		initLayout();
	}

	@Override
	public PanelMenuAbstract getNewPanelMenu() {
		ManagementDijkstraAlgorithm dijkstra = (ManagementDijkstraAlgorithm) this.getManagement();		
		ToolTipManagerDijkstraAlgorithm tooltip = (ToolTipManagerDijkstraAlgorithm) this.getToolTipManager();
		return new PanelRNDijkstraAlgorithmMenuImpl(dijkstra, tooltip);
	}

	@Override
	public PanelModelAbstract getNewPanelModel() {
		ManagementDijkstraAlgorithm dijkstra = (ManagementDijkstraAlgorithm) this.getManagement();		
		ToolTipManagerDijkstraAlgorithm tooltip = (ToolTipManagerDijkstraAlgorithm) this.getToolTipManager();
		return new PanelRNDijkstraAlgorithmModelImpl(dijkstra, tooltip);
	}
}
