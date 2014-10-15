/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Betriebssysteme.Buddy_Systeme;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TableModelBSBuddySystemeExplanationImpl extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	public TableModelBSBuddySystemeExplanationImpl() {
		super();
		this.initializeListContent();		
	}
	
	private List<String> listContent;
	
	private void initializeListContent() {
		ManagementBuddyMemoryAllocation buddy = ManagementBuddyMemoryAllocationImpl.getInstance();
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
	public Object getValueAt(int row, int column) {
		if (column == 1) {
			return listContent.get(row);			
		} else {
			return "";					
		}
	}
}
