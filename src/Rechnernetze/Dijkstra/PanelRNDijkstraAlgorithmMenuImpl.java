/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import Base.PanelMenuButtonsAbstract;

public class PanelRNDijkstraAlgorithmMenuImpl extends PanelMenuButtonsAbstract {

	private static final long serialVersionUID = 1L;
	
	public PanelRNDijkstraAlgorithmMenuImpl(ManagementDijkstraAlgorithm dijkstra) {
		super(dijkstra);
	}
	
	@Override
	protected void initComponentsMenuButtons() {
		
	}

	@Override
	protected void initLayout() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(this.btnExampleReset, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(this.btnAssumeSaveExecute, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(this.btnAssumeSaveExecute)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(this.btnExampleReset)
					.addContainerGap(59, Short.MAX_VALUE))
		);
		setLayout(groupLayout);		
	}

	@Override
	protected void initMethodsMenuButtons() {		
		
	}

	@Override
	public void updatePanelMenuButtons() {		
		
	}

	@Override
	public Integer getPanelHeight() {
		return 70;
	}

	@Override
	public Integer getPanelWidth() {
		return 220;
	}

	@Override
	protected void loadExample() {
		
	}

	@Override
	protected void assume() {
		
	}

	@Override
	protected void clearFields() {
		
	}

	@Override
	protected void executeExtra() {
		
	}

	@Override
	protected Boolean hasExample() {
		return false;
	}

	@Override
	protected void input() {
		
	}
}
