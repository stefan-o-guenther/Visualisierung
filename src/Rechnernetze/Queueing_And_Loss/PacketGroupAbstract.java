package Rechnernetze.Queueing_And_Loss;

import java.util.List;

public abstract class PacketGroupAbstract extends PacketToolAbstract implements PacketGroup {

	protected long term;
	protected long timestamp;
	protected int length;
	protected List<Packet> listPacket;
	
	@Override
	public List<Packet> getList() {
		return listPacket;
	}
}
