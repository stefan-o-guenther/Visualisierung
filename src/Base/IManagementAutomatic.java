/**
 * @author:	Stefan Otto G�nther
 * @date:	21.02.2014
 */

package Base;

public interface IManagementAutomatic extends IManagement {
	Boolean isAutomaticChecked();
	void setAutomaticChecked(Boolean value);
	Boolean isAutomaticRunning();
	void setAutomaticRunning(Boolean value);
	Integer getSpeed();
	void setSpeed(Integer value);
}
