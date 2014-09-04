package Betriebssysteme.Buddy_Systeme;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TableModelBSBuddySystemeExplanationImpl extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TableModelBSBuddySystemeExplanationImpl(ManagementBuddyMemoryAllocation buddy) {
		super();
		try {
			if (buddy == null) {
				throw new NullPointerException();
			}
			this.buddy = buddy;
			this.initializeListContent();
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	private ManagementBuddyMemoryAllocation buddy;
	private List<String> listContent;
	
	private void initializeListContent() {
		listContent = new ArrayList<String>();
		listContent.add("Frei");
		listContent.add("Verschnitt");
		List<ProcessNode> listProcesses = buddy.getListRunningProcesses();
		for (ProcessNode pn : listProcesses) {
			BuddyNode parent = pn.getParent();
			RestNode rest = parent.getRestNode();
			Integer restValue = rest.getValue();
			Integer processValue = pn.getValue();
			String name = pn.getName();
			String text = (name + " (" + processValue + " / " + restValue + ")");
			listContent.add(text);
		}		
	}
	
	
	public void updateTableModel() {
		this.initializeListContent();
		this.fireTableDataChanged();
	}
	
	@Override
	public int getColumnCount() {
		return 2;
	}	

	@Override
	public int getRowCount() {
		return (this.listContent.size());
	}
	
	@Override
	public Object getValueAt(int column, int row) {
		if (row == 1) {
			return listContent.get(column);			
		} else {
			return "";					
		}
	}
}
