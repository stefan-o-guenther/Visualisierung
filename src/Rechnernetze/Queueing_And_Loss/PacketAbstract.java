package Rechnernetze.Queueing_And_Loss;


public abstract class PacketAbstract implements Packet {

	public PacketAbstract() {
		
	}
	
	public EnumPacketType getType() {
		return EnumPacketType.FULL;
	}
}
