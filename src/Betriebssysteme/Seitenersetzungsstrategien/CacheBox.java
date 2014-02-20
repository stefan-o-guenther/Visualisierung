/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.ArrayList;
import java.util.List;


public class CacheBox implements ICacheBox {

	public CacheBox(Integer value) {
		number = value;
		listRam = new ArrayList<ICache>();
		listDisk = new ArrayList<ICache>();
	}	
	
	private Integer number = null;
	private List<ICache> listRam = new ArrayList<ICache>();
	private List<ICache> listDisk = new ArrayList<ICache>();
	private Boolean activated = false;
	
	@Override
	public Integer getNumber() {
		return number;
	}

	@Override
	public void setNumber(Integer value) {
		if (value != null) {
			number = value;
		}
	}

	@Override
	public List<ICache> getRam() {
		return listRam;
	}

	@Override
	public void setRam(List<ICache> value) {
		if (value != null) {
			listRam = value;
		}
	}

	@Override
	public List<ICache> getDisk() {
		return listDisk;
	}

	@Override
	public void setDisk(List<ICache> value) {
		if (value != null) {
			listDisk = value;
		}
	}	
	
	private List<ICache> copyList(List<ICache> list) {
		List<ICache> newList = new ArrayList<ICache>();
		if (list != null) {
			for (ICache cache : list) {
				ICache newCache = cache.getCopy();
				newList.add(newCache);
			}			
		}
		return newList;
	}

	@Override
	public List<ICache> getRamCopy() {
		return copyList(listRam);
	}

	@Override
	public List<ICache> getDiskCopy() {
		return copyList(listDisk);
	}

	@Override
	public Boolean isActivate() {
		return activated;
	}

	@Override
	public void activate(Boolean value) {
		if (value != null) {
			activated = value;
		}
	}

	@Override
	public void initializeRMPrevious() {
		for (ICache cache : listRam) {
			cache.initializeRPrevious();
			cache.initializeMPrevious();
		}
		for (ICache cache : listDisk) {
			cache.initializeRPrevious();
			cache.initializeMPrevious();
		}
	}

	@Override
	public void initializeRMDisk() {
		for (ICache cache : listDisk) {
			cache.setR(0);
			cache.setM(0);
		}
	}
}
