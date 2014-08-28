package Rechnernetze.Queueing_And_Loss;

import java.util.ArrayList;
import java.util.List;

public abstract class PacketListAbstract extends PacketGroupAbstract implements PacketList {
	
	protected abstract void putPacket(Packet packet);
	
	public PacketListAbstract(long term, long timestamp, Integer length) {
		try {
			if (length == null) {
				throw new NullPointerException();
			}
			int l = length.intValue();
			if ((term < 0) || (timestamp < 0) || (l <= 0)) {
				throw new IllegalArgumentException();
			}
			this.term = term;
			this.timestamp = timestamp;
			this.listPacket = new ArrayList<Packet>();
			this.length = length;
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
				listPacket.add(new PacketEmptyImpl());
				size = listPacket.size();
				if (size > this.length) {
					Packet packet = listPacket.get(size-1);
					if (packet.getType() == EnumPacketType.FULL) {
						this.putPacket(packet);
					}
					listPacket.remove(packet);
				}
			}
		} catch (Exception ex) {
			throw ex;
		}
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

	@Override
	public Integer getLength() {
		return this.length;
	}

	@Override
	public void setLength(Integer length) {
		try {
			if (length == null) {
				throw new NullPointerException();
			}
			int l = length.intValue();
			if (l <= 0) {
				throw new IllegalArgumentException();
			}
		} catch (Exception ex) {
			throw ex;
		}
	}
}