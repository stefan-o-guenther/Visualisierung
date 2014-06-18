/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Hauptprogramm;

import Base.ManagementAbstract;

public class ManagementDefaultImpl extends ManagementAbstract implements ManagementDefault {

	public ManagementDefaultImpl() {
		super();
	}

	@Override
	public Boolean execute() {
		return null;
	}

	@Override
	public void reset() {
		
	}

	@Override
	public String getTitle() {
		return "Visualisierung";
	}

	@Override
	public void showErrorMessage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void updateSize() {
		// TODO Auto-generated method stub
		
	}
}
