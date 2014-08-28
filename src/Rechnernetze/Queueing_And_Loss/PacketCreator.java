package Rechnernetze.Queueing_And_Loss;

public interface PacketCreator extends PacketTool {

	PacketListInput getPacketListInput();
	void setPacketListInput(PacketListInput packetListInput);	
}
