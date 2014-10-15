/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import javax.swing.ImageIcon;

public abstract class PanelMenuAbstract extends PanelLayoutAbstract {

	private static final long serialVersionUID = 1L;
	
	public PanelMenuAbstract() {
		super();
	}
	
	protected ImageIcon getImageIconHelp() {
		return ImageLoader.getImageIconHelp16();
	}
	
	protected abstract void createMenuComponents();
	protected abstract void createMenuMethods();
	
	@Override
	protected void createComponents() {
		this.createMenuComponents();
		this.createMenuMethods();
	}
}