/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Pipeline_Protocol;

import java.util.List;

import Base.ManagementGeometry;

public interface ManagementARQ extends ManagementGeometry {

	List<Packet> getListPacket();
	Integer getPositionStart();
	Integer getPositionTarget();
	Integer getPacketHeight();
	Integer getPacketWidth();
	Integer getGapBetweenPackets();
	List<Boolean> getListSender();
	List<Boolean> getListReceiver();
	void assume(EnumARQStrategy strategy);
	Boolean canSendPacket();
	void sendPacket();
	void setPacketSpeed(Integer value);
	void setTimeout(Integer value);
	Integer getWindowSizeSender();
	Integer getWindowSizeReceiver();
	void deletePacket(Packet packet);
	void disablePacket(Packet packet);
}
