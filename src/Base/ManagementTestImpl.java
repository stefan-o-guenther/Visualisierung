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
	protected void createToolTipManager() {
		this.tooltip = new ToolTipManagerTestImpl();
	}
}