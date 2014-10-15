/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra_Algorithmus.Version_B;

import Base.PanelAbstract;
import Base.PanelMainAbstract;
import Rechnernetze.Dijkstra_Algorithmus.ManagementDijkstraAlgorithmImpl;
import Rechnernetze.Dijkstra_Algorithmus.PanelRNDijkstraAlgorithmModelImpl;
import Rechnernetze.Dijkstra_Algorithmus.PanelRNDijkstraAlgorithmTableImpl;

public class PanelRNDijkstraAlgorithmMainImpl extends PanelMainAbstract {

	private static final long serialVersionUID = 1L;

	public PanelRNDijkstraAlgorithmMainImpl() {
		super(ManagementDijkstraAlgorithmImpl.getInstance());
		this.createPanel();
	}

	@Override
	public PanelAbstract getNewPanelMenu() {
		PanelAbstract panelMenu = new PanelRNDijkstraAlgorithmMenuImpl();
		return this.getPanelMenuAutomatic(panelMenu, 10);
	}

	@Override
	public PanelAbstract getNewPanelModel() {
		PanelAbstract panelModel = new PanelRNDijkstraAlgorithmModelImpl();
		PanelAbstract panelTable = new PanelRNDijkstraAlgorithmTableImpl();
		return this.getPanelCoupleVertical(panelModel, panelTable);
	}
}
