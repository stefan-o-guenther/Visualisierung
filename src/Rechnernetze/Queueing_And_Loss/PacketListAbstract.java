package Rechnernetze.Queueing_And_Loss;

import java.util.ArrayList;
import java.util.List;

public abstract class PacketListAbstract implements PacketList {

	protected List<Packet> listPacket;
	protected long term;
	protected long timestamp;
	protected int max;
	
	public PacketListAbstract(long term, long timestamp, int max) {
		try {
			if ((term < 0) || (timestamp < 0) || (max <= 0)) {
				throw new IllegalArgumentException();
			}
			this.term = term;
			this.timestamp = timestamp;
			this.listPacket = new ArrayList<Packet>();
			this.max = max;
		} catch (Exception ex) {
			throw ex;
		}		
	}
	
	@Override
	public void execute(long timeCurrent) {
		try {
			if ((timeCurrent < 0) || (timeCurrent < timestamp)) {
				throw new IllegalArgumentException();
			}
			long termDif = timeCurrent - timestamp;
			int size = listPacket.size();
			if ((size > 0) && (termDif >= term)) {
				timestamp = timeCurrent;
				for (Packet packet : listPacket) {
					int position = packet.getPosition() + 1;
					packet.setPosition(position);
				}
			}
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public List<Packet> getList() {
		return listPacket;
	}

	@Override
	public void addPacket(Packet packet, long timeCurrent) {
		try {
			if (packet == null) {
				throw new NullPointerException();
			}
			if ((timeCurrent < 0) || (timeCurrent < timestamp)) {
				throw new IllegalArgumentException();
			}
			int size = listPacket.size();
			if (size == 0) {
				timestamp = timeCurrent;
			}
			listPacket.add(packet);
		} catch (Exception ex) {
			throw ex;
		}
	}

}
