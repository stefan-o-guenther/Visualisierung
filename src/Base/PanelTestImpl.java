package Base;


public class PanelTestImpl extends PanelInitAbstract {

	private static final long serialVersionUID = 1L;

	public PanelTestImpl(Management management) {
		super(management);
	}
	
	private PanelTestImpl() {
		super(new ManagementTestImpl());
	}

	//@Override
	public void updatePanel() {
		
	}

	//@Override
	public Integer getPanelHeight() {
		return 0;
	}

	//@Override
	protected void initComponents() {
		
	}

	//@Override
	protected void initLayout() {
		
	}

	@Override
	public Integer getPanelWidth() {
		return 0;
	}
}
