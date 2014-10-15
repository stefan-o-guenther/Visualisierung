/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Base;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;


public class PanelCoupleHorizontalImpl extends PanelLayoutAbstract {

	private static final long serialVersionUID = 1L;

	public PanelCoupleHorizontalImpl(PanelAbstract panelLeft, PanelAbstract panelRight) {
		super();
		try {
			if ((panelLeft == null) || (panelRight == null)) {
				throw new NullPointerException();
			}
			this.panelLeft = panelLeft;
			this.panelRight = panelRight;
			createPanel();
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public PanelCoupleHorizontalImpl() {
		super();		
		this.init();
		this.createLayout();
	}
	
	private void init() {
		panelLeft = new PanelEmptyImpl(0,0);
		panelRight = new PanelEmptyImpl(0,0);
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
	protected void createComponents() {
		heightMenu = this.getPanelHeight();
		widthLeft = panelLeft.getPanelWidth();
	}

	@Override
	protected void createLayout() {
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
