package Rechnernetze.Queueing_And_Loss;

public class PacketListOutputImpl extends PacketListAbstract implements	PacketListOutput {

	public PacketListOutputImpl(long term, long timestamp, int max) {
		super(term, timestamp, max);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void putPacket(Packet packet) {
		// nothing
	}
}
