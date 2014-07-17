/**
 * @author:	Stefan Otto Günther
 * @date:	01.07.2014
 */

package Base;

public class ManagementAutomaticTestImpl extends ManagementAutomaticAbstract implements ManagementAutomatic {

	public ManagementAutomaticTestImpl() {
		super();
	}
	
	@Override
	protected Boolean executeAutomatic() {
		return true;
	}

	@Override
	public void reset() {
		
	}

	@Override
	public String getTitle() {
		return "";
	}

	@Override
	public void showErrorMessage() {
		
	}

	@Override
	public Boolean isAutomaticEnabled() {
		return false;
	}

	@Override
	protected void updateSize() {
		
	}
}