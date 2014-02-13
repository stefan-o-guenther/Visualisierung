/**
 * @author:	Stefan Otto Günther
 * @date:	08.02.2014
 */

package Rechnernetze.Dijkstra;

public interface IMinOutputRoute extends IMinOutput {
	Integer getWeight();
	void setWeight(Integer value);
}
