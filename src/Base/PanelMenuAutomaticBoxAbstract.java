/**
 * @author:	Stefan Otto Günther
 * @date:	01.06.2014
 */

package Base;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public abstract class PanelMenuAutomaticBoxAbstract extends PanelMenuAutomaticAbstract implements PanelMenuAutomaticBox {

	public PanelMenuAutomaticBoxAbstract(ManagementAutomatic management, ToolTipManagerAutomatic tooltip) {
		super(management, tooltip);		
	}	
	
	private PanelMenuAutomaticMenuAbstract panelMenu;		
	private PanelMenuAutomaticControlAbstract panelControl;	
	
	protected abstract PanelMenuAutomaticControlAbstract getNewPanelAutomaticMenuControler();
	protected abstract PanelMenuAutomaticMenuAbstract getNewPanelMenuAutomaticMenu();	
		
	@Override
	protected void initComponents() {
		panelMenu = this.getNewPanelMenuAutomaticMenu();
		panelControl = this.getNewPanelAutomaticMenuControler();
	}

	@Override
	protected void initLayout() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelMenu, GroupLayout.PREFERRED_SIZE, this.getLengthMenu(), GroupLayout.PREFERRED_SIZE)
					.addComponent(panelControl, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelControl, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
				.addComponent(panelMenu, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
		);
		setLayout(groupLayout);
	}
	
	@Override
	public void updatePanel() {
		if (panelMenu != null) {
			panelMenu.updatePanel();
		}
		if (panelControl != null) {
			panelControl.updatePanel();
		}
	}
	
	protected Integer getLengthMenu() {
		if (panelMenu != null) {
			return panelMenu.getLengthMenu();
		} else {
			return 0;
		}
	}

	@Override
	public Integer getHeightMenu() {
		if (panelMenu != null) {
			return panelMenu.getHeightMenu();
		} else {
			return 0;
		}
	}
}
