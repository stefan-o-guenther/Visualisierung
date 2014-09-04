/**
 * @author:	Stefan Otto Günther
 * @date:	18.02.2014
 */

package Base;

public abstract class PanelInitAbstract extends PanelAbstract {

	private static final long serialVersionUID = 1L;
	
	public PanelInitAbstract(Management management) {
		super(management);					
		this.initPanel();	
	}
}
