/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;


public abstract class ManagementAbstract implements Management {

	public ManagementAbstract() {
		super();
		surface = EnumSurface.COLORED;
		height = 0;
		width = 0;
	}
	
	protected PanelMainAbstract panelMain;
	protected EnumSurface surface;
	protected Integer height;
	protected Integer width;
	
	protected abstract void updateSize();
	
	protected void updatePanelMain() {
		if (panelMain != null) {
			panelMain.updatePanel();
		}		
	}
	
	protected void updatePanelTitle() {
		if (panelMain != null) {
			panelMain.updatePanelTitle();
		}		
	}
	
	protected void updatePanelMenu() {
		if (panelMain != null) {
			panelMain.updatePanelMenu();
		}		
	}
	
	protected void updatePanelModel() {
		if (panelMain != null) {
			panelMain.updatePanelModel();
		}		
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
			updatePanelMain();
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public void setPanelMain(PanelMainAbstract panelMain) {
		try {
			if (panelMain == null) {
				throw new NullPointerException();
			}
			this.panelMain = panelMain;
		} catch (Exception ex) {
			throw ex;
		}
	}	
	
	@Override
	public void updateAllPanels() {
		this.updatePanelMain();
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
}
