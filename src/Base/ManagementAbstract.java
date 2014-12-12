/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import java.util.Observable;


public abstract class ManagementAbstract extends Observable implements Management {
	
	protected ManagementAbstract() {
		super();
		this.createManagement();
		this.initializeManagement();
		this.updateViews();
	}
	
	private void createManagement() {
		this.setStatus(EnumVisualizationStatus.START);
		surface = EnumSurface.COLORED;
		height = 100;
		width = 100;
		this.isAutomaticRunning = false;
		this.speed = 0;	
		this.create();
	}
	
	private void initializeManagement() {
		this.timeThread = System.currentTimeMillis();
		this.setStatus(EnumVisualizationStatus.START);
		this.resetAutomatic();
		this.initialize();
	}
	
	private EnumVisualizationStatus status;
	
	protected ToolTipManager tooltip;
	
	protected EnumSurface surface;
	protected Integer height;
	protected Integer width;
	
	private Boolean isAutomaticChecked;
	private Boolean isAutomaticRunning;
	private Boolean isAutomaticPlay;
	protected Integer speed;
	protected ThreadAutomatic tAuto;
	
	private Long timeThread;	
	
	protected abstract void updateSize();
	protected abstract void initialize();
	protected abstract void create();
	protected abstract Boolean execute();
	protected abstract void showErrorMessage();
	protected abstract EnumAutomaticChecked keepAutomaticChecked();
	
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
			Checker.checkIfNotNull(surface);
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
			Checker.checkIfNotNull(height);
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
			Checker.checkIfNotNull(width);
			this.width = width;
			this.updateSize();
		} catch (Exception ex) {
			throw ex;
		}
	}	
	
	@Override
	public void setSize(Integer height, Integer width) {
		try {
			Checker.checkIfNotNull(height);
			Checker.checkIfNotNull(width);
			int widthOld = this.width.intValue();
			int heightOld = this.height.intValue();
			int widthNew = width.intValue();
			int heightNew = height.intValue();
			if ((widthOld != widthNew) || (heightOld != heightNew)) {
				this.height = height;
				this.width = width;				
				this.updateSize();
				this.updateViews();
			}
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
		long timeDif = System.currentTimeMillis() - timeThread;
		if (isAutomaticChecked() && isAutomaticPlay() && (timeDif >= this.getSpeed())) {
			timeThread = System.currentTimeMillis();
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
			Checker.checkIfNotNull(value);
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
			Checker.checkIfNotNull(value);
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
			Checker.checkIfNotNull(value);
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
			Checker.checkIfNotNull(value);
			speed = value;
		} catch (Exception ex) {
			throw ex;
		}
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
	}
	
	@Override
	public void endThread() {
		this.setAutomaticChecked(false);
		this.setAutomaticPlay(false);
		this.updateViews();
	}	
	
	@Override
	public EnumVisualizationStatus getStatus() {
		return status;
	}
	
	@Override
	public void setStatus(EnumVisualizationStatus status) {
		try {
			Checker.checkIfNotNull(status);
			this.status = status;
			this.updateViews();
		} catch (Exception ex) {
			throw ex;
		}		
	}
}