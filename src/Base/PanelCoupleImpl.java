package Base;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;


public class PanelCoupleImpl extends PanelAbstract {

	private static final long serialVersionUID = 1L;

	public PanelCoupleImpl(Management management, PanelAbstract panelLeft, PanelAbstract panelRight) {
		super(management);
		try {
			if ((panelLeft == null) || (panelRight == null)) {
				throw new NullPointerException();
			}
			this.panelLeft = panelLeft;
			this.panelRight = panelRight;
			initPanel();
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public PanelCoupleImpl() {
		super(new ManagementTestImpl());		
		this.init(this.management);
		this.initLayout();
	}
	
	private void init(Management management) {
		panelLeft = new PanelTestImpl(management);
		panelRight = new PanelTestImpl(management);
		heightMenu = 100;
		widthLeft = 300;
	}

	private PanelAbstract panelLeft;
	private PanelAbstract panelRight;
	private int heightMenu;
	private int widthLeft;
	
	@Override
	public void updatePanel() {
		this.panelLeft.updatePanel();
		this.panelRight.updatePanel();
	}	

	@Override
	protected void initComponents() {
		heightMenu = this.getPanelHeight();
		widthLeft = panelLeft.getPanelWidth();
	}

	@Override
	protected void initLayout() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelLeft, GroupLayout.PREFERRED_SIZE, widthLeft, GroupLayout.PREFERRED_SIZE)
					.addComponent(panelRight, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelLeft, GroupLayout.DEFAULT_SIZE, heightMenu, Short.MAX_VALUE)
				.addComponent(panelRight, GroupLayout.DEFAULT_SIZE, heightMenu, Short.MAX_VALUE)
		);
		setLayout(groupLayout);
	}
	
	@Override
	public Integer getPanelHeight() {
		int heightLeft = panelLeft.getPanelHeight();
		int heightRight = panelRight.getPanelHeight();		
		int height = heightLeft;
		if (height < heightRight) {
			height = heightRight;
		}
		return height;
	}
	
	@Override
	public Integer getPanelWidth() {
		int widthLeft = panelLeft.getPanelWidth();
		int widthRight = panelRight.getPanelWidth();
		return widthLeft + widthRight;
	}
}
