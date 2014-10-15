/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Dijkstra_Algorithmus.Version_B;

import java.util.List;

import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import Rechnernetze.Dijkstra_Algorithmus.ManagementDijkstraAlgorithm;
import Rechnernetze.Dijkstra_Algorithmus.ManagementDijkstraAlgorithmImpl;

public class TableColumnModelRNDijkstraAlgorithmImpl extends DefaultTableColumnModel implements TableColumnModel {

	private static final long serialVersionUID = 1L;

	public TableColumnModelRNDijkstraAlgorithmImpl() {
		super();
		ManagementDijkstraAlgorithm dijkstra = ManagementDijkstraAlgorithmImpl.getInstance();
		List<String> listNames = dijkstra.getListNodeTargetNames();
		int x = 0;
		addColumn("STEP", x);
		x += 1;
		addColumn("NODES", x);
		/*
		for (int i = 0; i < 5; i++) {
			x += 1;
			addColumn("A", x);
		}
		*/
		for (String name : listNames) {
			x += 1;
			addColumn(name, x);
		}
		
		x += 1;
		addColumn("MIN", x);
	}
	
	private void addColumn(String columnName, int modelIndex) {
		TableColumn column= new TableColumn(modelIndex);
		column.setHeaderValue(columnName);
		column.setCellRenderer(new TableCellRendererRNDijkstraAlgorithmImpl());
		addColumn(column);
	}
}
