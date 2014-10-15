package Base;


public abstract class PanelMenuControlAbstract extends PanelMenuAbstract {

	private static final long serialVersionUID = 1L;

	public PanelMenuControlAbstract(Management management) {
		super();
		try {
			if (management == null) {
				throw new NullPointerException();
			}
			this.management = management;			
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	protected Management management;
}
