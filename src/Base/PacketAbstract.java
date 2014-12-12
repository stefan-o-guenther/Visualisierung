/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Base;



public abstract class PacketAbstract implements Packet {

	public PacketAbstract(Integer position) {
		super();
		this.setPosition(position);
		this.initialize();
	}
	
	protected Integer position;
	protected Integer step;
	
	private void initialize() {
		this.step = 1;
	}
	
	public Integer getPosition() {
		return this.position;
	}
	
	public void setPosition(Integer position) {
		try {
			Checker.checkIfIntegerNotLessZero(position);
			this.position = position;
		} catch (Exception ex) {
			throw ex;
		}
	}
}
