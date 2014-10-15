package Betriebssysteme.Belegungsstrategien;

import java.util.List;

public interface MemoryStrategy {

	public EnumMemoryStrategy getStrategy();
	public List<Space> getListSpace();
}
