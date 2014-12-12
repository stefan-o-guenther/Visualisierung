/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Queueing_And_Loss;

import java.awt.Color;

import Base.EnumSurface;
import Base.Packet;

public interface PacketQal extends Packet {
	public Color getColor(EnumSurface surface);
}
