/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;

public abstract class BasePanelMain extends BasePanel {

	public BasePanelMain() {
		super();		
	}	
	
	private static final long serialVersionUID = 1L;
	
	protected abstract void initComponents();
	protected abstract BasePanelTitle getPanelTitle();
	protected abstract BasePanelMenu getPanelMenu();
	protected abstract BasePanelModel getPanelModel();	
	
	protected void initLayout() {
		BasePanelTitle panelTitle = getPanelTitle();
		BasePanelMenu panelMenu = getPanelMenu();
		BasePanelModel panelModel = getPanelModel();
		
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
