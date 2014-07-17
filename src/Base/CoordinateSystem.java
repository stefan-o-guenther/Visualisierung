/**
 * @author:	Stefan Otto Günther
 * @date:	01.06.2014
 */

package Base;

public interface CoordinateSystem extends Geometry {	
	
	
	
	public Integer getArrowLength();
	public void setArrowLength(Integer length);	
	
	public EnumCoordinateSystem getPosition();
	public void setPostion(EnumCoordinateSystem position);
}