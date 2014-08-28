package Rechnernetze.Queueing_And_Loss;

import java.util.List;

public interface PacketGroup extends PacketTool {

	List<Packet> getList();
	void addPacket(Packet packet, long timeCurrent);
}
