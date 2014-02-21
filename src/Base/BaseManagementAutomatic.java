/**
 * @author:	Stefan Otto Günther
 * @date:	21.02.2014
 */

package Base;

public abstract class BaseManagementAutomatic extends BaseManagement implements IManagementAutomatic {
	
	public BaseManagementAutomatic() {
		super();
		isAutomaticChecked = false;
		isAutomaticRunning = false;
		speed = 0;
	}
	
	protected Boolean isAutomaticChecked;
	protected Boolean isAutomaticRunning;
	protected Integer speed;
	
	@Override
	public Boolean isAutomaticChecked() {
		return isAutomaticChecked;
	}

	@Override
	public void setAutomaticChecked(Boolean value) {
		if (value != null) {
			isAutomaticChecked = value;
		}
	}

	@Override
	public Boolean isAutomaticRunning() {
		return isAutomaticRunning;
	}

	@Override
	public void setAutomaticRunning(Boolean value) {
		if (value != null) {
			isAutomaticRunning = value;
		}
	}

	@Override
	public Integer getSpeed() {
		return speed;
	}

	@Override
	public void setSpeed(Integer value) {
		if (value != null) {
			speed = value;
		}
	}
}
