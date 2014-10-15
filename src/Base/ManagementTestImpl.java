/**
 * @author:	Stefan Otto Günther
 * @date:	01.07.2014
 */

package Base;

public class ManagementTestImpl extends ManagementAbstract implements ManagementTest {

    private static ManagementTest instance = new ManagementTestImpl();
    
    private ManagementTestImpl() {
    	super();
    }
 
    public static ManagementTest getInstance() {
    	return instance;
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
		
	}

	@Override
	protected void create() {
		
	}

	@Override
	protected EnumAutomaticChecked keepAutomaticChecked() {
		return EnumAutomaticChecked.CHOICE;
	}

	@Override
	public ToolTipManager getToolTipManager() {
		return ToolTipManagerTestImpl.getInstance();
	}
}