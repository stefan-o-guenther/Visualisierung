/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Base;

public abstract class BaseManagement implements IManagement {

	protected EnumSurface surface = EnumSurface.COLORED;

	public BaseManagement() {
		
	}
	
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
