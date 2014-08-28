/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Retransmission;

import Base.EnumAutomaticChecked;
import Base.EnumVisualizationStatus;
import Base.ManagementAbstract;

public class ManagementRetransmissionImpl extends ManagementAbstract implements ManagementRetransmission {

	public ManagementRetransmissionImpl() {
		super();
	}

	@Override
	public String getTitle() {
		return "TCP-Retransmission";
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
		// TODO Auto-generated method stub
		return null;
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
		return EnumAutomaticChecked.ALWAYS;
	}

	@Override
	public Integer getAutomaticSpace() {
		return 0;
	}
}
