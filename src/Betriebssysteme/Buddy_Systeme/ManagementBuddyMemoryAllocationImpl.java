/**
 * @author:	Stefan Otto G¸nther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Base.EnumAutomaticChecked;
import Base.EnumSurface;
import Base.ManagementAbstract;
import Base.ToolTipManager;

public class ManagementBuddyMemoryAllocationImpl extends ManagementAbstract implements ManagementBuddyMemoryAllocation {

    private static ManagementBuddyMemoryAllocation instance = new ManagementBuddyMemoryAllocationImpl();
    
    private ManagementBuddyMemoryAllocationImpl() {
    	super();
    }
 
    public static ManagementBuddyMemoryAllocation getInstance() {
    	return instance;
    }
	
	private BuddyNode root;
	private HashMap<String, Color> mapColors;
	private List<Color> listColor;
	private List<ProcessNode> listRunningProcesses;
	private List<BuddyOperation> listBuddyOperations;
	private Integer limit = 0;
	private EnumProcess processOperation;
	private String processName;
	private Integer processSize;
		
	@Override
	protected void initialize() {
		root = null;
		listRunningProcesses = new ArrayList<ProcessNode>();
		listBuddyOperations = new ArrayList<BuddyOperation>();
		limit = 0;
		processOperation = EnumProcess.PROCESS_START;
		processName = "";
		processSize = 0;
		initColors();
	}

	@Override
	protected void create() {
		mapColors = new HashMap<String,Color>();
	}
	
	private void updateList(String text) {
		try {
			if (text == null) {
				throw new NullPointerException();
			}
			List<BuddySpace> list = new ArrayList<BuddySpace>();
			list = root.getNodeList(limit);
			BuddyOperation operation = new BuddyOperationImpl();
			operation.setMessage(text);
			operation.setBuddyList(list);
			listBuddyOperations.add(0, operation);
		} catch (Exception ex) {
			throw ex;
		}		
	}
	
	private ProcessNode getSpaceNode(String name) {
		try {
			if (name == null) {
				throw new NullPointerException();
			}
			ProcessNode result = null;
			for (ProcessNode space : listRunningProcesses) {
				String n = space.getName();
				if (name.equals(n)) {
					result = space;
					break;
				}
			}
			return result;
		} catch (Exception ex) {
			throw ex;
		}
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
	
	private BuddyNode getMinBuddyNode(List<BuddyNode> list) {
		try {
			if (list == null) {
				throw new NullPointerException();
			}
			BuddyNode minBuddyNode = null;
			Integer minValue = null;
			for (BuddyNode node : list) {
				Integer value = node.getValue();
				if ((minValue == null) || (minValue > value)) {
					minBuddyNode = node;
					minValue = value;
				}				
			}
			return minBuddyNode;		
		} catch (Exception ex) {
			throw ex;
		}
	}	
	
	private void startProcess() {
		try {
			if ((processName == null) || (processName == "") || (processName.length() == 0)) {
				updateList("kein Prozessname");
			} else if (processSize == null) {
				updateList("keine Prozessgrˆﬂe");
			} else if (processName.length() > 6) {
				updateList("Prozessname ist zu groﬂ");
			} else if (processSize <= 0) {
				updateList("Prozessgrˆﬂe ist zu klein");
			} else	if (root != null) {
				if (getSpaceNode(processName) == null) {
					List<BuddyNode> list = root.findPossibleBuddyNodes(processSize);				
					BuddyNode buddy = getMinBuddyNode(list);
					if (buddy != null) {
						ProcessNode node = buddy.insertSpace(processName, processSize);
						if (node != null) {
							listRunningProcesses.add(node);
							updateList("Prozess " + processName + " (" + processSize + ") gestartet.");
						} else {
							updateList("Prozess " + processName + " ist zu groﬂ.");
						}						
					} else {
						updateList("Prozess " + processName + " ist zu groﬂ.");
					}														
				} else {
					updateList("Prozess " + processName + " existiert schon.");
				}				
			} else {
				updateList("kein Gesammtspeicher");
			}
		} catch (Exception ex) {
			throw ex;
		}
		this.updateViews();
	}

	private void stopProcess() {
		try {
			if (processName == null) {
				throw new NullPointerException();
			}
			if (processName == "") {
				throw new IllegalArgumentException();
			}
			ProcessNode space = getSpaceNode(processName);
			if (space != null) {
				BuddyNode parent = space.getParent();
				parent.removeSpace();
				listRunningProcesses.remove(space);
				updateList("Prozess " + processName + " beendet.");
			} else {
				updateList("Prozess " + processName + " existiert nicht.");
			}
			while (root.clean()) {
				updateList("Buddies verschmolzen.");
			}			
		} catch (Exception ex) {
			throw ex;
		}
		this.updateViews();
	}

	@Override
	public void setTotalSpace(Integer value) {
		try {
			if (value == null) {
				throw new NullPointerException();
			}
			if (value <= 0) {
				throw new IllegalArgumentException();
			}
			root = new BuddyNodeImpl(value);
			this.setStatusRUN();
			updateList("Hauptspeicher initialisiert.");
			this.updateViews();
		} catch (Exception ex) {
			throw ex;
		}	
	}

	@Override
	public void print() {
		if (root != null) {
			root.print();
		}
	}

	@Override
	public List<BuddyOperation> getNodeList() {
		return new ArrayList<BuddyOperation>(listBuddyOperations);
	}

	@Override
	public void limitOutput(Integer limit) {
		try {
			if (limit == null) {
				throw new NullPointerException();
			}
			if (limit < 0) {
				throw new IllegalArgumentException();
			}
			this.limit = limit;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public Integer getTotalSpace() {
		if (root != null) {
			return root.getValue();
		} else {
			return 0;
		}
	}	

	@Override
	public Color getProcessNodeColor(String name) {
		try {
			if (name == null) {
				throw new NullPointerException();
			}
			if (name == "") {
				throw new IllegalArgumentException();
			}
			if (!(mapColors.containsKey(name))) {
				Integer newCount = mapColors.size();
				Integer size = listColor.size();
				Integer index = newCount % size;
				mapColors.put(name, listColor.get(index));
			}
			if (surface == EnumSurface.COLORED) {
				return mapColors.get(name);
			} else {
				return Color.BLACK;
			}			
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public Color getRestColor() {
		if (surface == EnumSurface.COLORED) {
			return  new Color(128,0,0);
		} else {
			return Color.BLACK;
		}
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
			for (ProcessNode process : listRunningProcesses) {
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
			for (ProcessNode process : listRunningProcesses) {
				BuddyNode parent = process.getParent();
				RestNode rest = parent.getRestNode();
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
	public List<ProcessNode> getListRunningProcesses() {
		List<ProcessNode> list = new ArrayList<ProcessNode>(listRunningProcesses);
		return list;
	}

	@Override
	protected Boolean execute() {
		switch (this.processOperation) {
			case PROCESS_START: {
				this.startProcess();
				break;
			}
			case PROCESS_STOP: {
				this.stopProcess();
				break;
			}
			default: {
				break;
			}
		}		
		return true;
	}

	@Override
	public String getTitle() {
		return "Buddy Systeme";
	}

	@Override
	protected void showErrorMessage() {
		
	}

	@Override
	protected void updateSize() {
		
	}

	@Override
	public EnumProcess getProcessOperation() {
		return this.processOperation;
	}

	@Override
	public void setProcessOperation(EnumProcess type) {
		try {
			if (type == null) {
				throw new NullPointerException();
			}
			this.processOperation = type;
			this.updateViews();
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public void setProcessName(String name) {
		try {
			if (name == null) {
				throw new NullPointerException();
			}
			if (name.length() == 0) {
				throw new IllegalArgumentException();
			}
			this.processName = name;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public void setProcessSize(Integer size) {
		try {
			if (size == null) {
				throw new NullPointerException();
			}
			int v = size.intValue();
			if (v < 0) {
				throw new IllegalArgumentException();
			}
			this.processSize = size;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@Override
	protected EnumAutomaticChecked keepAutomaticChecked() {
		return EnumAutomaticChecked.NEVER;
	}

	@Override
	public ToolTipManager getToolTipManager() {
		return ToolTipManagerBuddyMemoryAllocationImpl.getInstance();
	}
}
