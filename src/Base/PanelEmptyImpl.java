/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Base;

public class PanelEmptyImpl extends PanelAbstract {	

	private static final long serialVersionUID = 1L;

	public PanelEmptyImpl(int height, int width) {
		super();
		try {
			if ((height < 0) || (width < 0)) {
				throw new IllegalArgumentException();
			}
			this.height = height;
			this.width = width;
			this.createPanel();
		} catch (Exception ex) {
			throw ex;
		}		
	}
	
	public PanelEmptyImpl() {
		super();
		this.createPanel();
	}
	
	private int height;
	private int width;
	
	@Override
	public void updatePanel() {
		// nothing	
	}

	@Override
	public Integer getPanelHeight() {
		return height;
	}

	@Override
	public Integer getPanelWidth() {
		return width;
	}

	@Override
	protected void createPanel() {
		
	}
}
