/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;

public abstract class BasePanelMain extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected PanelTitle panelTitle;
	protected BasePanelMenu panelMenu;
	protected BasePanelModel panelModel;
	protected IManagement management;
	
	protected abstract void initComponents();
	
	public BasePanelMain(IManagement bm) {
		super();
		if (bm != null) {
			management = bm;
			//initComponents();
		}
	}	
	
	protected void initLayout(Integer sizeMenu) {
		if ((sizeMenu == null) || (sizeMenu < 0)) {
			sizeMenu = 100;
		}		
		
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
					.addComponent(panelTitle, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addComponent(panelMenu, GroupLayout.PREFERRED_SIZE, sizeMenu, GroupLayout.PREFERRED_SIZE)					
					.addComponent(panelModel, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}	
}
