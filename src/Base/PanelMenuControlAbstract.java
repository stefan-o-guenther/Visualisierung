package Base;

public abstract class PanelMenuControlAbstract extends PanelMenuAbstract {

	private static final long serialVersionUID = 1L;
	
	public PanelMenuControlAbstract(Management management) {
		super(management);
	}
	
	public Integer getPanelHeight() {
		return 0;
	}
	
	public Integer getPanelWidth() {
		return 0;
	}
}