/**
 * @author:	Stefan Otto Günther
 * @date:	12.05.2014
 */

package Base;


public interface PanelAutomatic extends Panel {

	public void startAutomatic();
	public void stopAutomatic();
	public void switchAutomatic();
	public void error();
	public void setAutomaticEnabled(Boolean enabled);
}
