/**
 * @author:	Stefan Otto G�nther
 * @date:	08.02.2014
 */

package Rechnernetze.Dijkstra;

public interface Output extends ColorGetter {
	public EnumOutputStatus getStatus();
	public void setStatus(EnumOutputStatus value);
}
