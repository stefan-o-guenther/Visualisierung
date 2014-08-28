package Rechnernetze.Queueing_And_Loss;

public interface Router extends PacketList {

	PacketListOutput getPacketListOutput();
	void setPacketListOutput(PacketListOutput packetListOutput);
	
	PacketListError getPacketListError();
	void setPacketListError(PacketListError packetListError);
}
