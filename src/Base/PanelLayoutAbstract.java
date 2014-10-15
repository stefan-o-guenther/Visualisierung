/**
 * @author:	Stefan Otto Günther
 * @date:	14.01.2014
 */

package Base;


public abstract class PanelLayoutAbstract extends PanelAbstract {

	private static final long serialVersionUID = 1L;

	public PanelLayoutAbstract() {
		super();
	}
	
	protected abstract void createComponents();
	protected abstract void createLayout();
	
	@Override
	protected void createPanel() {
		this.createComponents();
		this.createLayout();
		this.updatePanel();
	}
}
