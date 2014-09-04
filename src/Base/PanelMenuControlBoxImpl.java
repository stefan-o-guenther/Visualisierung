package Base;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;


public class PanelMenuControlBoxImpl extends PanelMenuControlAbstract {

	private static final long serialVersionUID = 1L;
	
	public PanelMenuControlBoxImpl(Management management) {
		super(management);
	}
	
	private PanelMenuControlBoxImpl() {
		super(new ManagementTestImpl());	
	}
	
	private JPanel panelSpace;
	private PanelMenuAbstract panelCheckbox;
	private PanelMenuAbstract panelSlider;

	@Override
	public Integer getPanelHeight() {
		return this.panelCheckbox.getPanelHeight() + this.panelSlider.getPanelHeight();
	}

	@Override
	public void updatePanel() {
		this.panelCheckbox.updatePanel();
		this.panelSlider.updatePanel();
	}

	@Override
	protected void initComponentsMenu() {
		panelCheckbox = new PanelMenuControlCheckboxImpl(management);
		panelSlider = new PanelMenuControlSpeedVisualizationImpl(management);
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
					.addComponent(panelCheckbox, GroupLayout.PREFERRED_SIZE, panelCheckbox.getPanelHeight(), GroupLayout.PREFERRED_SIZE)
					.addComponent(panelSlider, GroupLayout.DEFAULT_SIZE, panelSlider.getPanelHeight(), Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	@Override
	public Integer getPanelWidth() {
		// TODO Auto-generated method stub
		return null;
	}
}
