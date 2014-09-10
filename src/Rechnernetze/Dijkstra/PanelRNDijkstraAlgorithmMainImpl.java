/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra;

import Base.PanelAbstract;
import Base.PanelMainAbstract;

public class PanelRNDijkstraAlgorithmMainImpl extends PanelMainAbstract {

	private static final long serialVersionUID = 1L;

	public PanelRNDijkstraAlgorithmMainImpl(ManagementDijkstraAlgorithm dijkstra) {
		super(dijkstra);
	}

	@Override
	public PanelAbstract getNewPanelMenu() {
		ManagementDijkstraAlgorithm dijkstra = (ManagementDijkstraAlgorithm) this.getManagement();
		PanelAbstract panelMenu = new PanelRNDijkstraAlgorithmMenuImpl(dijkstra);
		return this.getPanelMenuAutomatic(panelMenu, 0);
	}

	@Override
	public PanelAbstract getNewPanelModel() {
		ManagementDijkstraAlgorithm dijkstra = (ManagementDijkstraAlgorithm) this.getManagement();
		return new PanelRNDijkstraAlgorithmModelImpl(dijkstra);
	}
}
