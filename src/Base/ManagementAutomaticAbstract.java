/**
 * @author:	Stefan Otto Günther
 * @date:	21.02.2014
 */

package Base;

public abstract class ManagementAutomaticAbstract extends ManagementAbstract implements ManagementAutomatic {
	
	public ManagementAutomaticAbstract() {
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
		try {
			if (value == null) {
				throw new NullPointerException();
			}
			isAutomaticChecked = value;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public Boolean isAutomaticRunning() {
		return isAutomaticRunning;
	}

	@Override
	public void setAutomaticRunning(Boolean value) {
		try {
			if (value == null) {
				throw new NullPointerException();
			}
			isAutomaticRunning = value;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public Integer getSpeed() {
		return speed;
	}

	@Override
	public void setSpeed(Integer value) {
		try {
			if (value == null) {
				throw new NullPointerException();
			}
			speed = value;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@Override
	public String getButtonAutomaticText() {
		String text = "";
		if (isAutomaticChecked()) {
    		if (isAutomaticRunning()) {
        		text = Labeling.STOP;
        	} else {
        		text = Labeling.START;
        	}
    	} else {
    		text = Labeling.NEXT_STEP;
    	}
		return text;
	}
	
	@Override
	public void resetAutomatic() {
		
	}
}
