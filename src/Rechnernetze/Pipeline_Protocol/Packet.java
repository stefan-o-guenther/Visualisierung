/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Pipeline_Protocol;

public interface Packet {
	Integer getNumber();
	Integer getPosition();
	Boolean isOk();
	void setOk(Boolean value);
	EnumPacketType getPacketType();
	void doStep(Integer value);
}
