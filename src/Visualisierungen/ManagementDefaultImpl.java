/**
 * @author:	Stefan Otto Günther
 * @date:	14.01.2014
 */

package Visualisierungen;

import Base.EnumAutomaticChecked;
import Base.ManagementAbstract;
import Base.ToolTipManager;

public class ManagementDefaultImpl extends ManagementAbstract implements ManagementDefault {

	private static ManagementDefault instance = new ManagementDefaultImpl();
    
    private ManagementDefaultImpl() {
    	super();
    }
 
    public static ManagementDefault getInstance() {
    	return instance;
    }
	
	@Override
	public String getTitle() {
		return "Visualisierungen";
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
	protected Boolean execute() {
		return true;
	}

	@Override
	protected void showErrorMessage() {
		
	}

	@Override
	protected EnumAutomaticChecked keepAutomaticChecked() {
		return EnumAutomaticChecked.CHOICE;
	}

	@Override
	public ToolTipManager getToolTipManager() {
		return ToolTipManagerDefaultImpl.getInstance();
	}
}
