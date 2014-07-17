/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Rechnernetze.Pipeline_Protocol;

import java.util.List;

import Base.ManagementAutomatic;

public interface ManagementPipelineProtocol extends ManagementAutomatic {

	List<Packet> getListPacket();
	Integer getPositionStart();
	Integer getPositionTarget();
	Integer getPacketHeight();
	Integer getPacketWidth();
	Integer getCount();
}
