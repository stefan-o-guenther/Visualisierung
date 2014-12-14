package Rechnernetze.Pipeline_Protocol;

import java.util.List;

public interface ARQProtocolStrategy {

	public EnumARQStrategy getStrategy();
	public void execute();
	public void sendPacket();
	public Boolean canSendPacket();
	public void setSpeedPacket(Integer speed);
	public void setTimeout(Integer timeout);
	public Integer getBaseSender();
	public Integer getBaseReceiver();
	public Integer getWindowSizeSender();	
	public Integer getWindowSizeReceiver();
	public List<PacketArq> getListPacket();
	public Sender[] getArraySender();
	public Receiver[] getArrayReceiver();
	public void disablePacket(PacketArq packet);
	public void deletePacket(PacketArq packet);
	public String getMessage();
}
