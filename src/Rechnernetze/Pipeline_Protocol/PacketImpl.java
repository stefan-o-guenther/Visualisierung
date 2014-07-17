package Rechnernetze.Pipeline_Protocol;

public class PacketImpl implements Packet {

	public PacketImpl() {
		position = 10;
	}
	
	private Integer position = 0;
	
	@Override
	public Integer getPosition() {
		return position;
	}	
}