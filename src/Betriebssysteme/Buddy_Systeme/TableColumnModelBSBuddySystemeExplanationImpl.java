package Betriebssysteme.Buddy_Systeme;

import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class TableColumnModelBSBuddySystemeExplanationImpl extends DefaultTableColumnModel implements TableColumnModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TableColumnModelBSBuddySystemeExplanationImpl(ManagementBuddyMemoryAllocation buddy) {
		super();
		try {
			if (buddy == null) {
				throw new NullPointerException();
			}
			this.buddy = buddy;	
			addColumn("", 0);
			addColumn("Legende", 1);
		} catch (Exception ex) {
			throw ex;
		}		
	}
	
	private ManagementBuddyMemoryAllocation buddy;
	
	private void addColumn(String columnName, int modelIndex) {
		TableColumn column= new TableColumn(modelIndex);
		column.setHeaderValue(columnName);
		column.setCellRenderer(new TableCellRendererBSBuddySystemeExplanationImpl(buddy));
		addColumn(column);
	}
}
