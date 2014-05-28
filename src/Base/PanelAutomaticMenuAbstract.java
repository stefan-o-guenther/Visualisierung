package Base;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;

public abstract class PanelAutomaticMenuAbstract extends PanelMenuAbstract implements PanelAutomaticMenu {

	public PanelAutomaticMenuAbstract(Management management, ToolTipManager tooltip) {
		super(management, tooltip);
		
		JPanel panelMenu = new JPanel();		
		JPanel panelAutomatic = new JPanel();
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelMenu, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
					.addComponent(panelAutomatic, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelAutomatic, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
				.addComponent(panelMenu, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
		);
		setLayout(groupLayout);
	}

	@Override
	public Integer getHeightMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initLayout() {
		// TODO Auto-generated method stub
		
	}
}
