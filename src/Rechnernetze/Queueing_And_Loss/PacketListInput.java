package Rechnernetze.Queueing_And_Loss;

public interface PacketListInput extends PacketList {

	Router getRouter();
	void setRouter(Router router);
	
	Integer getMinDistance();
}
