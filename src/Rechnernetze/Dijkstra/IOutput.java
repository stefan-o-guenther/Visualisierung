/**
 * @author:	Stefan Otto Günther
 * @date:	08.02.2014
 */

package Rechnernetze.Dijkstra;

public interface IOutput extends IColorGetter {
	public EnumOutputStatus getStatus();
	public void setStatus(EnumOutputStatus value);
}
