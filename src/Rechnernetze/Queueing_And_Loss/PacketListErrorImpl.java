package Rechnernetze.Queueing_And_Loss;


public class PacketListErrorImpl extends PacketListAbstract implements PacketListError {

	public PacketListErrorImpl(long term, long timestamp, int max) {
		super(term, timestamp, max);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void putPacket(Packet packet) {
		// nothing
	}
}
