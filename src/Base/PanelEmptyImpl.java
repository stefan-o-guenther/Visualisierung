/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Base;

public class PanelEmptyImpl extends PanelAbstract {	

	private static final long serialVersionUID = 1L;

	public PanelEmptyImpl(Management management, int height, int width) {
		super(management);
		try {
			if ((height < 0) || (width < 0)) {
				throw new IllegalArgumentException();
			}
			this.height = height;
			this.width = width;
			this.initPanel();
		} catch (Exception ex) {
			throw ex;
		}		
	}
	
	public PanelEmptyImpl() {
		super(new ManagementTestImpl());
		this.initComponents();
		this.initLayout();
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
	protected void initComponents() {
		// nothing
	}

	@Override
	protected void initLayout() {
		// nothing
	}
}
