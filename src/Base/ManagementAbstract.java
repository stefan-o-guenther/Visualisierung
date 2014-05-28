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
	
	protected void update() {
		if (panelMain != null) {
			panelMain.updatePanel();
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
			update();
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
		this.update();
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
			if ((panelMain != null) && ((!(this.height.equals(height))) || (!(this.width.equals(width))))) {
				this.height = height;
				this.width = width;				
				panelMain.updatePanelMenu();
			}
		} catch (Exception ex) {
			throw ex;
		}
	}
}
