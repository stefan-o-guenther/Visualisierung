package Base;

public abstract class BaseManagement implements IManagement {

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
