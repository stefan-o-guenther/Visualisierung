/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Pipeline_Protocol;

import java.awt.Color;
import java.util.List;

import Base.ManagementGeometry;
import Base.ManagementPacket;

public interface ManagementAutomaticRepeatRequest extends ManagementGeometry, ManagementPacket {

	public List<PacketArq> getListPacket();
	public Integer getPositionStart();
	public Integer getPositionTarget();
	public Integer getPacketHeight();
	public Integer getPacketWidth();
	public Integer getGapBetweenPackets();
	public Sender[] getArraySender();
	public Receiver[] getArrayReceiver();
	public void assume(EnumARQStrategy strategy);
	public Boolean canSendPacket();
	public void sendPacket();
	public void setTimeout(Integer value);
	public Integer getWindowSenderBase();
	public Integer getWindowSenderSize();
	public Integer getWindowReceiverBase();
	public Integer getWindowReceiverSize();
	public void deletePacket(PacketArq packet);
	public void disablePacket(PacketArq packet);
	public Color getColorData();
	public Color getColorAck();
	public Color getColorNak();
	public Color getColorBroken();
	public Color getColorSenderOk();
	public Color getColorReceiverOk();
	public String getMessage();
}
