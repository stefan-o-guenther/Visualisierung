package Rechnernetze.Queueing_And_Loss;

import java.util.List;

public class PacketListInputImpl extends PacketListAbstract implements PacketListInput {

	public PacketListInputImpl(long term, long timestamp, int max) {
		super(term, timestamp, max);
	}

	@Override
	public void execute(long timeCurrent) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Packet> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPacket(Packet packet, long timeCurrent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPacketListError(PacketListError packetListError) {
		// TODO Auto-generated method stub
		
	}

}
