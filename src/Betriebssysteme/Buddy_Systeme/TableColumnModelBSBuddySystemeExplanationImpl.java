/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Betriebssysteme.Buddy_Systeme;

import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class TableColumnModelBSBuddySystemeExplanationImpl extends DefaultTableColumnModel implements TableColumnModel {

	private static final long serialVersionUID = 1L;

	public TableColumnModelBSBuddySystemeExplanationImpl() {
		super();
		addColumn("", 0);
		addColumn("Legende", 1);				
	}
	
	private void addColumn(String columnName, int modelIndex) {
		TableColumn column= new TableColumn(modelIndex);
		column.setHeaderValue(columnName);
		column.setCellRenderer(new TableCellRendererBSBuddySystemeExplanationImpl());
		addColumn(column);
	}
}
