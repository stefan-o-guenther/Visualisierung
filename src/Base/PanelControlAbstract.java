package Base;


public abstract class PanelControlAbstract extends PanelMenuAbstract {

	private static final long serialVersionUID = 1L;

	public PanelControlAbstract(Management management) {
		super();
		try {
			Checker.checkIfNotNull(management);
			this.management = management;			
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	protected Management management;
}
