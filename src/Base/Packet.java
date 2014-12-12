/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Base;

public interface Packet {
	public Packet getClone();
	public Integer getPosition();
	public void setPosition(Integer position);
	public void doStep();
}
