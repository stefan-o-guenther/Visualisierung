package Base;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;

public abstract class BasePanelMain extends JPanel {

	protected PanelTitle panelTitle;
	protected BasePanelMenu panelMenu;
	protected BasePanelModel panelModel;
	protected IBaseManagement management;
	
	protected abstract void initComponents();
	
	protected BasePanelMain(IBaseManagement bm) {
		if (bm != null) {
			management = bm;
			//initComponents();
		}
	}
	
	
	protected void initLayout(Integer sizeMenu) {
		if ((sizeMenu != null) && (sizeMenu >= 0)) {
			GroupLayout groupLayout = new GroupLayout(this);
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addComponent(panelTitle, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
					.addComponent(panelMenu, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
					.addComponent(panelModel, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addComponent(panelTitle, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						//.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panelMenu, GroupLayout.PREFERRED_SIZE, sizeMenu, GroupLayout.PREFERRED_SIZE)
						//.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panelModel, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
			);
			setLayout(groupLayout);
		}
		
	}
	
}
