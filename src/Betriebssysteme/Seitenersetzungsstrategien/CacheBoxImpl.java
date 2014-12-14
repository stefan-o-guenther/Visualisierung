/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.ArrayList;
import java.util.List;

import Base.Checker;


public class CacheBoxImpl implements CacheBox {

	public CacheBoxImpl(Integer value) {
		Checker.checkIfIntegerNotLessZero(value);
		this.number = value;
		this.initialize();
	}	
	
	private void initialize() {
		listRam = new ArrayList<Cache>();
		listDisk = new ArrayList<Cache>();
		activated = false;
	}
	
	private Integer number;
	private List<Cache> listRam;
	private List<Cache> listDisk;
	private Boolean activated;
	
	@Override
	public Integer getNumber() {
		return number;
	}

	@Override
	public void setNumber(Integer value) {
		Checker.checkIfIntegerNotLessZero(value);
		this.number = value;
	}

	@Override
	public List<Cache> getRam() {
		return listRam;
	}

	@Override
	public void setRam(List<Cache> value) {
		Checker.checkIfNotNull(value);
		this.listRam = value;
	}

	@Override
	public List<Cache> getDisk() {
		return listDisk;
	}

	@Override
	public void setDisk(List<Cache> value) {
		Checker.checkIfNotNull(value);
		this.listDisk = value;
	}	
	
	private List<Cache> copyList(List<Cache> list) {
		Checker.checkIfNotNull(list);
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
	public Boolean isActivated() {
		return activated;
	}

	@Override
	public void setActivated(Boolean value) {
		Checker.checkIfNotNull(value);
		this.activated = value;
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
