package Betriebssysteme.Buddy_Systeme;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Base.BaseManagement;

public class BuddyMemoryAllocation extends BaseManagement implements IBuddyMemoryAllocation {

	private IBuddyNode root;
	private HashMap<String, Color> mapColors = new HashMap<String,Color>();
	private List<Color> listColor;
	private List<IProcessNode> listRunningProcesses;
	private EnumBuddyMemoryAllocation status;
	private List<IBuddyOperation> listBuddyOperations;
	private Integer limit = 0;
		
	private void init() {
		root = null;
		listRunningProcesses = new ArrayList<IProcessNode>();
		status = EnumBuddyMemoryAllocation.START;
		listBuddyOperations = new ArrayList<IBuddyOperation>();
		limit = 0;
		initColors();
	}
	
	private void updateList(String text) {
		if (text == null) {
			text = "";
		}
		List<IBuddySpace> list = new ArrayList<IBuddySpace>();
		list = root.getNodeList(limit);
		IBuddyOperation operation = new BuddyOperation();
		operation.setMessage(text);
		operation.setBuddyList(list);
		listBuddyOperations.add(0, operation);
	}
	
	private IProcessNode getSpaceNode(String name) {
		IProcessNode result = null;
		if (name != null) {
			for (IProcessNode space : listRunningProcesses) {
				String n = space.getName();
				if (name.equals(n)) {
					result = space;
					break;
				}
			}
		}
		return result;
	}
	
	private void initColors() {
		listColor = new ArrayList<Color>();
		
		listColor.add(new Color(122,197,205));
		listColor.add(new Color(255,193,193));
		listColor.add(new Color(159,182,205));
		listColor.add(new Color(188,238,104));
		listColor.add(new Color(240,128,128));
		listColor.add(new Color(255,105,180));
		listColor.add(new Color(238,207,161));
		listColor.add(new Color(224,102,255));
		listColor.add(new Color(255,215,0));
		listColor.add(new Color(100,149,237));
		listColor.add(new Color(205,133,63));
		listColor.add(new Color(50,205,50));
		listColor.add(new Color(255,127,80));
		listColor.add(new Color(205,104,137));
		listColor.add(new Color(255,0,255));
		listColor.add(new Color(205,179,139));
		listColor.add(new Color(205,149,12));
		listColor.add(new Color(238,130,238));
		listColor.add(new Color(255,255,0));
		listColor.add(new Color(135,206,250));
		listColor.add(new Color(255,165,79));
		listColor.add(new Color(205,205,0));
		
		mapColors.clear();
	}
	
	public BuddyMemoryAllocation() {
		init();
	}
	
	private IBuddyNode getMinBuddyNode(List<IBuddyNode> list) {
		IBuddyNode buddy = null;
		if (list != null) {
			Integer min = null;
			for (IBuddyNode node : list) {
				Integer valueNode = node.getValue();
				if ((min == null) || (min > valueNode)) {
					buddy = node;
					min = valueNode;
				}				
			}
		}
		return buddy;
	}	
	
	@Override
	public void startProcess(String name, Integer value) {
		if ((name != null) && (value != null) && (root != null)) {	
			if (getSpaceNode(name) == null) {
				List<IBuddyNode> list = root.findPossibleBuddyNodes(value);				
				IBuddyNode buddy = getMinBuddyNode(list);
				if (buddy != null) {
					IProcessNode node = buddy.insertSpace(name, value);
					if (node != null) {
						listRunningProcesses.add(node);
						updateList("Prozess " + name + " gestartet.");
					} else {
						updateList("Prozess " + name + " ist zu groß.");
					}						
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
			IProcessNode space = getSpaceNode(name);
			if (space != null) {
				IBuddyNode parent = space.getParent();
				parent.removeSpace();
				listRunningProcesses.remove(space);
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
		return new ArrayList<IBuddyOperation>(listBuddyOperations);
	}

	@Override
	public void limitOutput(Integer value) {
		if ((value != null) && (value >= 0)) {
			limit = value;
		}
	}

	@Override
	public Integer getTotalSpace() {
		Integer total = 0;
		if (root != null) {
			total = root.getValue();
		}
		return total;
	}	

	@Override
	public Color getProcessNodeColor(String name) {
		Color color = Color.BLACK;
		if (name != null) {
			if (!(mapColors.containsKey(name))) {
				Integer newCount = mapColors.size();
				Integer size = listColor.size();
				Integer index = newCount % size;
				mapColors.put(name, listColor.get(index));
			}
			switch (surface) {
				case COLORED: {
					color = mapColors.get(name);
					break;
				}
				case GRAY: {
					color = Color.GRAY;
					break;
				}
				default: {
					color = Color.BLACK;
					break;
				}
			}	
		}	
		return color;
	}

	@Override
	public Color getRestColor() {
		Color color = Color.BLACK;
		switch (surface) {
			case COLORED: {
				color = new Color(128,0,0);
				break;
			}
			case GRAY: {
				color = Color.BLACK;
				break;
			}
			default: {
				color = Color.BLACK;
				break;
			}
		}
		return color;
	}

	@Override
	public Color getUsedColor() {
		Color color = Color.GRAY;
		return color;
	}

	@Override
	public Color getBuddyColor() {
		Color color = Color.WHITE;
		return color;
	}

	@Override
	public List<String> getListProcessNames() {
		List<String> list = new ArrayList<String>(mapColors.keySet());
		return list;
	}

	@Override
	public List<Color> getListUsedColors() {
		List<Color> list = new ArrayList<Color>(mapColors.values());
		return list;
	}

	@Override
	public Integer getProcessCount() {
		Integer count = 0;
		if (listRunningProcesses != null) {
			count = listRunningProcesses.size();
		}
		return count;
	}

	@Override
	public Integer getProcessSpace() {
		Integer sum = 0;
		if (listRunningProcesses != null) {
			for (IProcessNode process : listRunningProcesses) {
				Integer value = process.getValue();
				sum += value;
			}
		}		
		return sum;
	}
	
	@Override
	public Double getProcessRate() {
		Integer valueTotal = getTotalSpace();
		Integer valueProcess = getProcessSpace();
		Double rate = 0.0;
		if (valueTotal > 0) {
			rate = (((double) valueProcess) * 100.0) / ((double) valueTotal);
		}		
		return rate;
	}
	
	@Override
	public Integer getFreeSpace() {
		Integer valueTotal = getTotalSpace();
		Integer valueProcess = getProcessSpace();
		Integer valueRest = getRestSpace();
		return (valueTotal - valueProcess - valueRest);
	}

	@Override
	public Double getFreeRate() {
		Integer valueTotal = getTotalSpace();
		Integer valueFree = getFreeSpace();
		Double rate = 0.0;
		if (valueTotal > 0) {
			rate = (((double) valueFree) * 100.0) / ((double) valueTotal);
		}
		return rate;
	}

	@Override
	public Integer getRestSpace() {
		Integer sum = 0;
		if (listRunningProcesses != null) {
			for (IProcessNode process : listRunningProcesses) {
				IBuddyNode parent = process.getParent();
				IRestNode rest = parent.getRestNode();
				Integer value = rest.getValue();
				sum += value;
			}
		}		
		return sum;
	}	

	@Override
	public Double getRestRate() {
		Integer valueTotal = getTotalSpace();
		Integer valueRest = getRestSpace();
		Double rate = 0.0;
		if (valueTotal > 0) {
			rate = (((double) valueRest) * 100.0) / ((double) valueTotal);
		}
		return rate;
	}

	@Override
	public List<IProcessNode> getListRunningProcesses() {
		List<IProcessNode> list = new ArrayList<IProcessNode>(listRunningProcesses);
		return list;
	}
}
