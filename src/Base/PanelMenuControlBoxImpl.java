package Base;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;


public class PanelMenuControlBoxImpl extends PanelMenuControlAbstract {

	public PanelMenuControlBoxImpl(Management management, ToolTipManager tooltip) {
		super(management, tooltip);
	}
	
	private PanelMenuControlBoxImpl() {
		super(new ManagementTestImpl(), new ToolTipManagerTestImpl());	
	}
	
	private JPanel panelSpace;
	private PanelMenuAbstract panelCheckbox;
	private PanelMenuAbstract panelSlider;

	@Override
	public Integer getHeightMenu() {
		return this.panelCheckbox.getHeightMenu() + this.panelSlider.getHeightMenu();
	}

	@Override
	public void updatePanel() {
		this.panelCheckbox.updatePanel();
		this.panelSlider.updatePanel();
	}

	@Override
	protected void initComponentsMenu() {
		panelCheckbox = new PanelMenuControlCheckboxImpl(management, tooltip);
		panelSlider = new PanelMenuControlSpeedVisualizationImpl(management, tooltip);
		panelSpace = new JPanel();
		panelSpace.setBackground(this.getBackground());
	}

	@Override
	protected void initMethods() {
		
	}

	@Override
	protected void initLayout() {			 
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelSlider, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
				.addComponent(panelCheckbox, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
				.addComponent(panelSpace, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addComponent(panelSpace, GroupLayout.PREFERRED_SIZE, management.getAutomaticSpace(), GroupLayout.PREFERRED_SIZE)
					.addComponent(panelCheckbox, GroupLayout.PREFERRED_SIZE, panelCheckbox.getHeightMenu(), GroupLayout.PREFERRED_SIZE)
					.addComponent(panelSlider, GroupLayout.DEFAULT_SIZE, panelSlider.getHeightMenu(), Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}
