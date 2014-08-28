/**
 * @author:	Stefan Otto Günther
 * @date:	01.06.2014
 */

package Base;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public abstract class PanelMenuBoxAbstract extends PanelMenuAbstract {

	public PanelMenuBoxAbstract(Management management, ToolTipManager tooltip) {
		super(management, tooltip);		
	}	
	
	private PanelMenuMenuAbstract panelMenu;		
	private PanelMenuAbstract panelControl;	
	
	protected abstract PanelMenuAbstract getNewPanelAutomaticMenuControler();
	protected abstract PanelMenuMenuAbstract getNewPanelMenuAutomaticMenu();	
		
	@Override
	protected void initComponentsMenu() {
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
	protected void initMethods() {
		// nothing
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
