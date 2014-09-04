/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

public abstract class PanelModelAbstract extends PanelInitAbstract {
	
	private static final long serialVersionUID = 1L;
	
	public PanelModelAbstract(Management management) {
		super(management);
	}
	
	public Integer getPanelHeight() {
		return 0;
	}
	
	public Integer getPanelWidth() {
		return 0;
	}
}