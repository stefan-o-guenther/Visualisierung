/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

public enum EnumPagingStrategy {
	OPTIMAL,
	FIFO,
	FIFO_SECOND_CHANCE,
	NRU_RNU,
	NRU_RNU_SECOND_CHANCE,
	LRU,
	NFU_LFU,
	NULL
	//"Optimale Strategie", "FIFO", "FIFO - 2nd Chance", "NRU / RNU", "LRU", "NFU / LFU""
}
