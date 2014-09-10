/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Base;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;


public class PanelCoupleVerticalImpl extends PanelAbstract {

	private static final long serialVersionUID = 1L;

	public PanelCoupleVerticalImpl(Management management, PanelAbstract panelTop, PanelAbstract panelBottom) {
		super(management);
		try {
			if ((panelTop == null) || (panelBottom == null)) {
				throw new NullPointerException();
			}
			this.panelTop = panelTop;
			this.panelBottom = panelBottom;
			initPanel();
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public PanelCoupleVerticalImpl() {
		super(new ManagementTestImpl());		
		this.init(this.management);
		this.initLayout();
	}
	
	private void init(Management management) {
		panelTop = new PanelEmptyImpl(management,0,0);	
		panelBottom = new PanelEmptyImpl(management,0,0);
		heightTop = 100;
		widthMenu = 300;
	}
	
	private PanelAbstract panelTop;	
	private PanelAbstract panelBottom;
	private int widthMenu;
	private int heightTop;

	@Override
	public void updatePanel() {
		this.panelTop.updatePanel();
		this.panelBottom.updatePanel();
	}

	@Override
	protected void initComponents() {
		widthMenu = this.getPanelWidth();
		heightTop = panelTop.getPanelHeight();
	}

	@Override
	protected void initLayout() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelTop, GroupLayout.DEFAULT_SIZE, widthMenu, Short.MAX_VALUE)
				.addComponent(panelBottom, GroupLayout.DEFAULT_SIZE, widthMenu, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelTop, GroupLayout.PREFERRED_SIZE, heightTop, GroupLayout.PREFERRED_SIZE)
					.addComponent(panelBottom, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	@Override
	public Integer getPanelHeight() {
		int heightTop = panelTop.getPanelHeight();
		int heightBottom = panelBottom.getPanelHeight();		
		return heightTop + heightBottom;
	}

	@Override
	public Integer getPanelWidth() {
		int widthTop = panelTop.getPanelWidth();
		int widthBottom = panelBottom.getPanelWidth();
		int width = widthTop;
		if (width < widthBottom) {
			width = widthBottom;
		}
		return width;
	}
}
