/**
 * @author:	Stefan Otto Günther
 * @date:	21.02.2014
 */

package Base;

public abstract class ManagementAutomaticAbstract extends ManagementAbstract implements ManagementAutomatic {
	
	public ManagementAutomaticAbstract() {
		super();
		this.isAutomaticChecked = false;
		this.isAutomaticRunning = false;
		this.speed = 0;
		this.initTime();
	}
	
	protected Boolean isAutomaticChecked;
	protected Boolean isAutomaticRunning;
	protected Boolean isAutomaticEnabled;
	protected Integer speed;
	protected ThreadAutomatic tAuto; //= new AutoThread();
	protected long time;
	
	protected abstract Boolean executeAutomatic();
	
	protected void initTime() {
		this.time = System.currentTimeMillis();
	}
	
	protected long getTime() {
		return time;
	}
	
	protected void setTime(long time) {
		try {
			if (time < 0) {
				throw new IllegalArgumentException();
			}
			this.time = time;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	protected void setAutomaticEnabled(Boolean isAutomaticEnabled) {
		try {
			if (isAutomaticEnabled == null) {
				throw new NullPointerException();
			}
			this.isAutomaticEnabled = isAutomaticEnabled;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public Boolean execute() {
		long timeCurrent = System.currentTimeMillis();
		long timeDif = timeCurrent - time;
		if ((!(this.isAutomaticChecked())) || (timeDif >= this.getSpeed())) {
			time = timeCurrent;
			return this.executeAutomatic();
		} else {
			return true;
		}
	}
	
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
	
	@Override
	public void startAutomatic() {
		if ((!(isAutomaticRunning())) && (isAutomaticChecked())) {
			setAutomaticRunning(true);
			tAuto = new ThreadAutomatic(this);
			tAuto.start();
		}
		this.updatePanelMain();
	}
	
	@Override
	public void stopAutomatic() {
		if (isAutomaticRunning()) {
			setAutomaticRunning(false);
			setAutomaticChecked(false);
		}
		updatePanelMain();
	}
	
	@Override
	public void switchAutomatic() {
		if (isAutomaticRunning()) {
			stopAutomatic();
		} else {
			startAutomatic();
		}
		updatePanelMain();
	}
}
