/**
 * @author:	Stefan Otto G�nther
 * @date:	08.02.2014
 */

package Rechnernetze.Dijkstra;

public interface IOutput extends IColorGetter {
	EnumOutputStatus getStatus();
	void setStatus(EnumOutputStatus value);
}
