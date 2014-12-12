package Betriebssysteme.Belegungsstrategien;

import Base.Checker;

public class SpaceFactory {

	public static SpaceEmpty getSpaceEmpty(Integer value) {
		Checker.checkIfNotNull(value);
		return new SpaceEmptyImpl(value);
	}
	
	public static SpaceFull getSpaceFullOne() {
		return new SpaceFullImpl(1);
	}
	
	public static SpaceFull getSpaceFull(Integer value) {
		Checker.checkIfNotNull(value);
		return new SpaceFullImpl(value);
	}
	
	public static SpaceUsed getSpaceUsed(Integer value) {
		Checker.checkIfNotNull(value);
		return new SpaceUsedImpl(value);
	}
}
