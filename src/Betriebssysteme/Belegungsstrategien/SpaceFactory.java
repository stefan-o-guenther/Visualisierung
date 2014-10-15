package Betriebssysteme.Belegungsstrategien;

public class SpaceFactory {

	public static SpaceEmpty getSpaceEmpty(Integer value) {
		return new SpaceEmptyImpl(value);
	}
	
	public static SpaceFull getSpaceFullOne() {
		return new SpaceFullImpl(1);
	}
	
	public static SpaceFull getSpaceFull(Integer value) {
		return new SpaceFullImpl(value);
	}
	
	public static SpaceUsed getSpaceUsed(Integer value) {
		return new SpaceUsedImpl(value);
	}
}
