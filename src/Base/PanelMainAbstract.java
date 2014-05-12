/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public abstract class PanelMainAbstract extends PanelAbstract implements PanelMain {

	public PanelMainAbstract(Management management, ToolTipManager tooltip) {
		super(management, tooltip);
		initComponents();
		initLayout();
	}	
	
	private static final long serialVersionUID = 1L;
	
	protected PanelTitleImpl panelTitle;
	protected PanelMenuAbstract panelMenu;
	protected PanelModelAbstract panelModel;
	
	protected abstract PanelMenuAbstract getNewPanelMenu();
	protected abstract PanelModelAbstract getNewPanelModel();
	
	protected PanelTitleImpl getNewPanelTitle() {
		return new PanelTitleImpl(management, tooltip);
	}
	
	public void initComponents() {
		panelModel = this.getNewPanelModel();
		panelMenu = this.getNewPanelMenu();
		panelTitle = this.getNewPanelTitle();
	}	
	
	public void initLayout() {
		Integer sizeMenu = panelMenu.getHeightMenu();
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelTitle, GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
				.addComponent(panelMenu, GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
				.addComponent(panelModel, GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelTitle, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addComponent(panelMenu, GroupLayout.PREFERRED_SIZE, sizeMenu, GroupLayout.PREFERRED_SIZE)					
					.addComponent(panelModel, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
		);
		setLayout(groupLayout);				
	}
}