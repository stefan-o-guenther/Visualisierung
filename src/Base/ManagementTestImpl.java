/**
 * @author:	Stefan Otto Günther
 * @date:	01.07.2014
 */

package Base;

public class ManagementTestImpl extends ManagementAbstract implements Management {

	public ManagementTestImpl() {
		super();
	}
	
	@Override
	protected Boolean execute() {
		return true;
	}

	@Override
	public String getTitle() {
		return "Test";
	}

	@Override
	public void showErrorMessage() {
		
	}

	@Override
	protected void updateSize() {
		
	}

	@Override
	public EnumVisualizationStatus getStatus() {
		return EnumVisualizationStatus.START;
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void create() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected EnumAutomaticChecked keepAutomaticChecked() {
		return EnumAutomaticChecked.CHOICE;
	}

	@Override
	public Integer getAutomaticSpace() {
		return 0;
	}

	@Override
	protected void createPanelMenu() {
		this.panelMenu = new PanelTestImpl(this);
	}

	@Override
	protected void createPanelModel() {
		this.panelModel = new PanelTestImpl(this);
	}

	@Override
	protected void createToolTipManager() {
		this.tooltip = new ToolTipManagerTestImpl();
	}
}