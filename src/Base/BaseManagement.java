/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

public abstract class BaseManagement implements IManagement {

	public BaseManagement() {
		
	}
	
	protected EnumSurface surface = EnumSurface.COLORED;	
	
	@Override
	public EnumSurface getSurface() {
		return surface;
	}

	@Override
	public void setSurface(EnumSurface value) {
		if (value != null) {
			surface = value;
		}
	}	
}
