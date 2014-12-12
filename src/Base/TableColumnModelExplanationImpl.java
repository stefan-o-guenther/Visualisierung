/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Base;

import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class TableColumnModelExplanationImpl extends DefaultTableColumnModel implements TableColumnModel {

	private static final long serialVersionUID = 1L;

	public TableColumnModelExplanationImpl(TableCellRenderer tableCellRenderer) {
		super();
		addColumn("", 0, tableCellRenderer);
		addColumn("Legende", 1, tableCellRenderer);				
	}
	
	private void addColumn(String columnName, int modelIndex, TableCellRenderer tableCellRenderer) {
		TableColumn column= new TableColumn(modelIndex);
		column.setHeaderValue(columnName);
		column.setCellRenderer(tableCellRenderer);
		addColumn(column);
	}
}
