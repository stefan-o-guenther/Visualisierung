/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Pipeline_Protocol;

import java.util.List;

import Base.ManagementGeometry;

public interface ManagementPipelineProtocol extends ManagementGeometry {

	List<Packet> getListPacket();
	Integer getPositionStart();
	Integer getPositionTarget();
	Integer getPacketHeight();
	Integer getPacketWidth();
	Integer getCount();
}
