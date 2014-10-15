/**
 * @author:	Stefan Otto Günther
 * @date:	22.10.2014
 */

package Rechnernetze.Pipeline_Protocol;

public abstract class PacketAbstract implements Packet {

	public PacketAbstract(Integer number, Integer position) {
		super();
		try {
			if ((position == null) || (number == null)) {
				throw new NullPointerException();
			}
			if ((position.intValue() < 0) || (number.intValue() < 0)) {
				throw new IllegalArgumentException();
			}
			this.position = position;
			this.number = number;
		} catch (Exception ex) {
			throw ex;
		}
		initialize();
	}
	
	protected Integer number;
	protected Integer position;
	protected Boolean ok;
	protected Integer step;
	
	private void initialize() {
		this.ok = true;
		this.step = 2;
	}
	
	@Override
	public Integer getNumber() {
		return number;
	}

	@Override
	public Integer getPosition() {
		return position;
	}

	@Override
	public Boolean isOk() {
		return ok;
	}

	@Override
	public void setOk(Boolean value) {
		try {
			if (value == null) {
				throw new NullPointerException();
			}
			this.ok = value;
		} catch (Exception ex) {
			throw ex;
		}
	}
}
