package Rechnernetze.Queueing_And_Loss;

import java.util.List;

public interface PacketList {

	void execute(long timeCurrent);
	List<Packet> getList();
	void addPacket(Packet packet, long timeCurrent);
}
