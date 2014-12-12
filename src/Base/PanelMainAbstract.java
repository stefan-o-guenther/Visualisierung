/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import java.util.Observable;
import java.util.Observer;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public abstract class PanelMainAbstract extends PanelLayoutAbstract implements Observer {

	private static final long serialVersionUID = 1L;

	public PanelMainAbstract(Management management) {
		super();		
		try {
			Checker.checkIfNotNull(management);
			this.management = management;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	/*
	private PanelMainAbstract() {
		super();
		panelModel = new PanelEmptyImpl(0,0);
		panelMenu = new PanelEmptyImpl(0,0);
		panelTitle = new PanelEmptyImpl(0,0);
		sizeTitle = 50;
		sizeMenu = 100;
		this.initLayout();
	}
	*/	
	
	private Management management;
	private PanelAbstract panelTitle;
	private PanelAbstract panelMenu;
	private PanelAbstract panelModel;
	
	private int sizeTitle;
	private int sizeMenu;
	
	protected abstract PanelAbstract getNewPanelMenu();
	protected abstract PanelAbstract getNewPanelModel();
	
	protected PanelAbstract getNewPanelTitle() {
		return new PanelTitleImpl(management);
	}
	
	protected PanelAbstract getPanelCoupleHorizontal(PanelAbstract panelLeft, PanelAbstract panelRight) {
		try {
			if ((panelLeft == null) || (panelRight == null)) {
				throw new NullPointerException();
			}
			return new PanelCoupleHorizontalImpl(panelLeft, panelRight);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	protected PanelAbstract getPanelCoupleVertical(PanelAbstract panelTop, PanelAbstract panelBottom) {
		try {
			if ((panelTop == null) || (panelBottom == null)) {
				throw new NullPointerException();
			}
			return new PanelCoupleVerticalImpl(panelTop, panelBottom);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	protected PanelAbstract getPanelMenuControlBox(int gapTop) {
		try {
			if (gapTop < 0) {
				throw new IllegalArgumentException();
			}
			PanelAbstract panelGap = new PanelEmptyImpl(gapTop,1);
			PanelAbstract panelCheckbox = new PanelControlCheckboxImpl(management);
			PanelAbstract panelSlider = new PanelControlSpeedVisualizationImpl(management);
			PanelAbstract panelCouple = this.getPanelCoupleVertical(panelCheckbox, panelSlider);
			return this.getPanelCoupleVertical(panelGap, panelCouple);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	protected PanelAbstract getPanelMenuAutomatic(PanelAbstract panelMenu, int gapTop) {
		try {
			if (panelMenu == null) {
				throw new NullPointerException();
			}
			if (gapTop < 0) {
				throw new IllegalArgumentException();
			}
			PanelAbstract panelAutomatic = this.getPanelMenuControlBox(gapTop);
			return this.getPanelCoupleHorizontal(panelMenu, panelAutomatic);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@Override
	protected void createComponents() {
		Observable observable = (Observable) management;
		observable.addObserver(this);
		
		panelMenu = this.getNewPanelMenu();
		panelModel = this.getNewPanelModel();
		panelTitle = this.getNewPanelTitle();
		sizeTitle = panelTitle.getPanelHeight();
		sizeMenu = panelMenu.getPanelHeight();
		management.updateViews();
	}	
	
	@Override
	protected void createLayout() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelTitle, GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
				.addComponent(panelMenu, GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
				.addComponent(panelModel, GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelTitle, GroupLayout.PREFERRED_SIZE, sizeTitle, GroupLayout.PREFERRED_SIZE)
					.addComponent(panelMenu, GroupLayout.PREFERRED_SIZE, sizeMenu, GroupLayout.PREFERRED_SIZE)
					.addComponent(panelModel, GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE))
		);
		setLayout(groupLayout);				
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof Management) {
			this.updatePanel();
		}		
	}
	
	@Override
	public void updatePanel() {
		if (panelTitle != null) {
			panelTitle.updatePanel();
		}
		if (panelMenu != null) {
			panelMenu.updatePanel();
		}
		if (panelModel != null) {
			panelModel.updatePanel();
		}
	}
	
	public String getTitle() {
		return management.getTitle();
	}

	@Override
	public Integer getPanelHeight() {
		return 768;
	}

	@Override
	public Integer getPanelWidth() {
		return 1024;
	}
}