package Base;

public abstract class PanelBuilderAbstract implements PanelBuilder {

	public PanelBuilderAbstract(Management management) {
		super();
		try {
			if (management == null) {
				throw new NullPointerException();
			}
			this.management = management;
			this.createPanelModel();
			this.createPanelMenu();
			this.createPanelTitle();
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	protected Management management;
	protected PanelAbstract panelTitle;
	protected PanelAbstract panelMenu;
	protected PanelAbstract panelModel;
	
	protected abstract void createPanelMenu();
	protected abstract void createPanelModel();
	
	protected void createPanelTitle() {
		panelTitle = new PanelTitleImpl(management);
	}
	
	protected Management getManagement() {
		return this.management;
	}
	
	protected PanelCoupleImpl getPanelCouple(PanelAbstract panelLeft, PanelAbstract panelRight) {
		try {
			if ((panelLeft == null) || (panelRight == null)) {
				throw new NullPointerException();
			}
			PanelCoupleImpl panelCouple = new PanelCoupleImpl(management, panelLeft, panelRight);
			return panelCouple;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@Override
	public PanelAbstract getPanelTitle() {
		return this.panelTitle;
	}

	@Override
	public PanelAbstract getPanelMenu() {
		return this.panelMenu;
	}

	@Override
	public PanelAbstract getPanelModel() {
		return this.panelModel;
	}
}
