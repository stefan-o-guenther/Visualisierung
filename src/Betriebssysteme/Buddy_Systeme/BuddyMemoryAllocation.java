package Betriebssysteme.Buddy_Systeme;

import java.util.ArrayList;
import java.util.List;

import Base.BaseManagement;

public class BuddyMemoryAllocation extends BaseManagement implements IBuddyMemoryAllocation {

	private IBuddyNode root;
	private List<ISpaceNode> listSpace;
	private EnumBuddyMemoryAllocation status;
	private List<IBuddyOperation> listProcess;
	private Integer limit = 0;
	
	private void init() {
		root = null;
		listSpace = new ArrayList<ISpaceNode>();
		status = EnumBuddyMemoryAllocation.START;
		listProcess = new ArrayList<IBuddyOperation>();
		limit = 0;
	}
	
	private void updateList(String text) {
		if (text != null) {
			text = "";
		}
		List<IProcessSpace> list = new ArrayList<IProcessSpace>();
		list = root.getNodeList(list, limit);
		IBuddyOperation operation = new BuddyOperation();
		operation.setMessage(text);
		operation.setBuddyList(list);
		listProcess.add(0, operation);
	}
	
	private ISpaceNode getSpaceNode(String name) {
		ISpaceNode result = null;
		if (name != null) {
			for (ISpaceNode space : listSpace) {
				String n = space.getName();
				if (name.equals(n)) {
					result = space;
					break;
				}
			}
		}
		return result;
	}
	
	public BuddyMemoryAllocation() {
		init();
	}
	
	@Override
	public void startProcess(String name, Integer value) {
		if ((name != null) && (value != null) && (root != null)) {	
			if (getSpaceNode(name) == null) {
				ISpaceNode node = root.insertSpace(name, value);
				if (node != null) {
					listSpace.add(node);
					updateList("Prozess " + name + " gestartet.");
				} else {
					updateList("Prozess " + name + " ist zu groß.");
				}
			} else {
				updateList("Prozess " + name + " existiert schon.");
			}			
		}		
	}

	@Override
	public void stopProcess(String name) {
		if (name != null) {
			ISpaceNode space = getSpaceNode(name);
			if (space != null) {
				IBuddyNode parent = space.getParent();
				parent.removeSpace();
				listSpace.remove(space);
				updateList("Prozess " + name + " beendet.");
			} else {
				updateList("Prozess " + name + " existiert nicht.");
			}
			while (root.clean()) {
				updateList("Buddies verschmolzen.");
			}
		}
	}

	@Override
	public void setTotalSpace(Integer value) {
		if ((value != null) && (value > 0)) {
			if (value > 4096) {
				value = 4096;			
			}
			root = new BuddyNode(value, null);
			status = EnumBuddyMemoryAllocation.EXECUTE;	
			updateList("Hauptspeicher initialisiert.");
		}		
	}

	@Override
	public void print() {
		if (root != null) {
			root.print();
		}
	}

	@Override
	public void reset() {
		init();
	}

	@Override
	public EnumBuddyMemoryAllocation getStatus() {
		return status;
	}

	@Override
	public List<IBuddyOperation> getNodeList() {
		return new ArrayList<IBuddyOperation>(listProcess);
	}

	@Override
	public void limitOutput(Integer value) {
		if ((value != null) && (value >= 0)) {
			limit = value;
		}
	}

	@Override
	public Integer getTotalSpace() {
		if (root == null) {
			return 0;
		} else {
			return root.getValue();
		}
	}
}
