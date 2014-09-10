/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import java.util.Observable;


public abstract class ManagementAbstract extends Observable implements Management {

	public ManagementAbstract() {
		super();
		this.createManagement();
		this.initializeManagement();
		this.createToolTipManager();
		this.updateViews();
	}
	
	private void createManagement() {
		surface = EnumSurface.COLORED;
		height = 0;
		width = 0;
		this.isAutomaticRunning = false;
		this.speed = 0;	
		this.create();
	}
	
	private void initializeManagement() {
		this.time = System.currentTimeMillis();
		this.resetAutomatic();
		this.initialize();
	}
	
	protected ToolTipManager tooltip;
	
	protected EnumSurface surface;
	protected Integer height;
	protected Integer width;
	
	private Boolean isAutomaticChecked;
	private Boolean isAutomaticRunning;
	private Boolean isAutomaticPlay;
	protected Integer speed;
	protected ThreadAutomatic tAuto;
	protected long time;	
	
	protected abstract void updateSize();
	protected abstract void initialize();
	protected abstract void create();
	protected abstract Boolean execute();
	protected abstract void showErrorMessage();
	protected abstract EnumAutomaticChecked keepAutomaticChecked();	
	
	protected abstract void createToolTipManager();
	
	protected void executeWithCheck() {
		if (!(this.execute())) {
			this.showErrorMessage();
		}
	}
	
	@Override
	public void reset() {
		initializeManagement();
		this.updateViews();
	}
	
	@Override
	public EnumSurface getSurface() {
		return surface;
	}

	@Override
	public void setSurface(EnumSurface surface) {
		try {
			if (surface == null) {
				throw new NullPointerException();
			}
			this.surface = surface;
			this.updateViews();
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public void updateViews() {
		setChanged();
		notifyObservers(this);
	}
	
	@Override
	public Integer getHeight() {
		return height;
	}
	
	@Override
	public void setHeight(Integer height) {
		try {
			if (height == null) {
				throw new NullPointerException();
			}
			this.height = height;
			this.updateSize();
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@Override
	public Integer getWidth() {
		return width;
	}
	
	@Override
	public void setWidth(Integer width) {
		try {
			if (width == null) {
				throw new NullPointerException();
			}
			this.width = width;
			this.updateSize();
		} catch (Exception ex) {
			throw ex;
		}
	}	
	
	@Override
	public void setSize(Integer height, Integer width) {
		try {
			if ((height == null) || (width == null)) {
				throw new NullPointerException();
			}			
			this.height = height;
			this.width = width;				
			this.updateSize();
		} catch (Exception ex) {
			throw ex;
		}
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
	
	@Override
	public Boolean isAutomaticEnabled() {
		EnumVisualizationStatus status = this.getStatus();
		if (status == EnumVisualizationStatus.RUN) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void executeThread() {
		long timeCurrent = System.currentTimeMillis();
		long timeDif = timeCurrent - time;
		if (isAutomaticChecked() && isAutomaticPlay() && (timeDif >= this.getSpeed())) {
			time = timeCurrent;
			this.executeWithCheck();
			this.updateViews();
		}
	}
	
	@Override
	public void executeNormal() {
		if (isAutomaticChecked()) {
			this.switchAutomatic();
		} else {
			this.executeWithCheck();
		}
		this.updateViews();	
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
			switch (this.keepAutomaticChecked()) {
				case ALWAYS: {
					this.isAutomaticChecked = true;
					break;
				}
				case NEVER: {
					this.isAutomaticChecked = false;
					break;
				}
				case CHOICE: {
					this.isAutomaticChecked  = value;
					break;
				}
				default: {
					break;
				}
			}
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
	public Boolean isAutomaticPlay() {
		return this.isAutomaticPlay;
	}
	
	@Override
	public void setAutomaticPlay(Boolean value) {
		try {
			if (value == null) {
				throw new NullPointerException();
			}
			isAutomaticPlay = value;
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
	
	protected void startAutomatic() {
		if ((!(isAutomaticRunning())) && (isAutomaticChecked())) {
			this.setAutomaticPlay(true);
			tAuto = new ThreadAutomatic(this);
			tAuto.start();
		}
		this.updateViews();
	}
	
	
	private void resetAutomatic() {
		this.setAutomaticPlay(false);
		this.setAutomaticChecked(false);
	}
	
	protected void stopAutomatic() {
		if (isAutomaticRunning()) {
			this.resetAutomatic();
		}
		this.updateViews();
	}
	
	@Override
	public void switchAutomatic() {
		if (isAutomaticRunning()) {
			stopAutomatic();
		} else {
			startAutomatic();
		}
		this.updateViews();
	}
	
	@Override
	public void endThread() {
		this.setAutomaticChecked(false);
		this.setAutomaticPlay(false);
		this.updateViews();
	}	
	
	@Override
	public ToolTipManager getToolTipManager() {
		return this.tooltip;
	}
}