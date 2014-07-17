package Rechnernetze.Queueing_And_Loss;

import java.util.List;

public class PacketListErrorImpl extends PacketListAbstract implements PacketListError {

	public PacketListErrorImpl(long term, long timestamp, int max) {
		super(term, timestamp, max);
		// TODO Auto-generated constructor stub
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

}
