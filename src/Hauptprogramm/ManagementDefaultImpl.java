/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Hauptprogramm;

import Base.EnumAutomaticChecked;
import Base.EnumVisualizationStatus;
import Base.ManagementAbstract;

public class ManagementDefaultImpl extends ManagementAbstract implements ManagementDefault {

	public ManagementDefaultImpl() {
		super();
	}

	@Override
	public String getTitle() {
		return "Visualisierung";
	}

	@Override
	protected void showErrorMessage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void updateSize() {
		// TODO Auto-generated method stub
		
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
	protected Boolean execute() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void create() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected EnumAutomaticChecked keepAutomaticChecked() {
		return EnumAutomaticChecked.NEVER;
	}

	@Override
	public Integer getAutomaticSpace() {
		return 0;
	}
}
