/**
 * @author:	Stefan Otto Günther
 * @date:	21.02.2014
 */

package Base;

public interface IManagementAutomatic extends IManagement {
	public Boolean isAutomaticChecked();
	public void setAutomaticChecked(Boolean value);
	public Boolean isAutomaticRunning();
	public void setAutomaticRunning(Boolean value);
	public Integer getSpeed();
	public void setSpeed(Integer value);
}
