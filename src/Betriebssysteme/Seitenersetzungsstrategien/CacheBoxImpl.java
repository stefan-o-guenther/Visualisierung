/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.ArrayList;
import java.util.List;


public class CacheBoxImpl implements CacheBox {

	public CacheBoxImpl(Integer value) {
		number = value;
		listRam = new ArrayList<Cache>();
		listDisk = new ArrayList<Cache>();
	}	
	
	private Integer number = null;
	private List<Cache> listRam = new ArrayList<Cache>();
	private List<Cache> listDisk = new ArrayList<Cache>();
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
	public List<Cache> getRam() {
		return listRam;
	}

	@Override
	public void setRam(List<Cache> value) {
		if (value != null) {
			listRam = value;
		}
	}

	@Override
	public List<Cache> getDisk() {
		return listDisk;
	}

	@Override
	public void setDisk(List<Cache> value) {
		if (value != null) {
			listDisk = value;
		}
	}	
	
	private List<Cache> copyList(List<Cache> list) {
		List<Cache> newList = new ArrayList<Cache>();
		if (list != null) {
			for (Cache cache : list) {
				Cache newCache = cache.getCopy();
				newList.add(newCache);
			}			
		}
		return newList;
	}

	@Override
	public List<Cache> getRamCopy() {
		return copyList(listRam);
	}

	@Override
	public List<Cache> getDiskCopy() {
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
		for (Cache cache : listRam) {
			cache.initializeRPrevious();
			cache.initializeMPrevious();
		}
		for (Cache cache : listDisk) {
			cache.initializeRPrevious();
			cache.initializeMPrevious();
		}
	}

	@Override
	public void initializeRMDisk() {
		for (Cache cache : listDisk) {
			cache.setR(0);
			cache.setM(0);
		}
	}
}
