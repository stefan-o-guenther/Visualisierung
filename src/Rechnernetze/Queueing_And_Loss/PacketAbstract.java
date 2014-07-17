package Rechnernetze.Queueing_And_Loss;


public abstract class PacketAbstract implements Packet {

	public PacketAbstract() {
		this.position = 0;
	}
	
	private Integer position;
	
	@Override
	public Integer getPosition() {
		return this.position;
	}

	@Override
	public void setPosition(Integer position) {
		try {
			if (position == null) {
				throw new NullPointerException();
			}
			if (position.intValue() < 0) {
				throw new IllegalArgumentException();
			}
			this.position = position;
		} catch (Exception ex) {
			throw ex;
		}
	}
}
