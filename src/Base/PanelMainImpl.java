/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class PanelMainImpl extends PanelInitAbstract {

	private static final long serialVersionUID = 1L;

	public PanelMainImpl(Management management) {
		super(management);
	}
	
	private PanelMainImpl() {
		super(new ManagementTestImpl());
		init(this.management);
		this.initLayout();
	}	
	
	private PanelAbstract panelTitle;
	private PanelAbstract panelMenu;
	private PanelAbstract panelModel;
		
	private int sizeTitle;
	private int sizeMenu;
	
	protected void initComponents() {		
		panelMenu = management.getPanelMenu();
		panelModel = management.getPanelModel();
		panelTitle = management.getPanelTitle();
		sizeTitle = panelTitle.getPanelHeight();
		sizeMenu = panelMenu.getPanelHeight();
		management.updateAllPanels();
	}	
	
	private void init(Management management) {
		panelModel = new PanelTestImpl(management);
		panelMenu = new PanelTestImpl(management);
		panelTitle = new PanelTestImpl(management);
		sizeTitle = 50;
		sizeMenu = 100;
	}
	
	protected void initLayout() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelTitle, GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
				.addComponent(panelMenu, GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
				.addComponent(panelModel, GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelTitle, GroupLayout.PREFERRED_SIZE, sizeTitle, GroupLayout.PREFERRED_SIZE)
					.addComponent(panelMenu, GroupLayout.PREFERRED_SIZE, sizeMenu, GroupLayout.PREFERRED_SIZE)
					.addComponent(panelModel, GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE))
		);
		setLayout(groupLayout);				
	}

	@Override
	public void updatePanel() {
		if (panelTitle != null) {
			panelTitle.updatePanel();
		}
		if (panelMenu != null) {
			panelMenu.updatePanel();
		}
		if (panelModel != null) {
			panelModel.updatePanel();
		}
	}

	@Override
	public Integer getPanelHeight() {
		return 768;
	}

	@Override
	public Integer getPanelWidth() {
		return 1024;
	}	
}