package Betriebssysteme.Seitenersetzungsstrategien;

public enum EnumPagingStrategy {
	NULL,
	OPTIMAL,
	FIFO,
	FIFO_SECOND_CHANCE,
	NRU_RNU,
	NRU_RNU_SECOND_CHANCE,
	LRU,
	NFU_LFU,
	RANDOM
	//"Optimale Strategie", "FIFO", "FIFO - 2nd Chance", "NRU / RNU", "LRU", "NFU / LFU", "Zufall"
}
