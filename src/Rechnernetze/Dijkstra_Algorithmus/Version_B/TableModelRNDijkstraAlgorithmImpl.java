/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Dijkstra_Algorithmus.Version_B;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Base.ManagementFactory;
import Rechnernetze.Dijkstra_Algorithmus.ManagementDijkstraAlgorithm;
import Rechnernetze.Dijkstra_Algorithmus.MinOutput;
import Rechnernetze.Dijkstra_Algorithmus.NodeOutput;

public class TableModelRNDijkstraAlgorithmImpl extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	public TableModelRNDijkstraAlgorithmImpl() {
		super();
		this.initializeListContent();		
	}
	
	private ManagementDijkstraAlgorithm dijkstra;
	
	private List<String> listUsedNodes;
	private List<List<String>> listlistOutput;
	private List<String> listMin;
	
	private void initListUsedNodes() {
		listUsedNodes = new ArrayList<String>();
		List<String> listNodeUsedNames = dijkstra.getListNodeUsedNames();
		for (int i = 0; i < listNodeUsedNames.size(); i++) {
			String chain = "";			
			for (int j = 0; j <= i; j++) {
				String node = listNodeUsedNames.get(j);
				if (j > 0) {
					chain = chain + " " + node;
				} else {
					chain = node;
				}
			}
			listUsedNodes.add(chain);
		}		
	}
	
	private void initListListNodeOutput() {
		listlistOutput = new ArrayList<List<String>>();
		List<String> listTargetNames = dijkstra.getListNodeTargetNames();
		for (String name : listTargetNames) {
			List<String> listOutput = new ArrayList<String>();
			List<NodeOutput> listNodeOutput = dijkstra.getListNodeOutput(name);
			for (NodeOutput nodeOutput : listNodeOutput) {
				listOutput.add(nodeOutput.toString());
			}			
			listlistOutput.add(listOutput);
		}
	}
	
	private void initListMin() {
		listMin = new ArrayList<String>();
		List<MinOutput> listMinOutput = dijkstra.getListMin();
		for (MinOutput minOutput : listMinOutput) {
			listMin.add(minOutput.toString());
		}		
	}
	
	private void initializeListContent() {
		dijkstra = ManagementFactory.getManagementDijkstraAlgorithm();
		this.initListUsedNodes();
		this.initListListNodeOutput();
		this.initListMin();
	}	
	
	public void updateTableModel() {
		this.initializeListContent();
		this.fireTableDataChanged();
	}
	
	@Override
	public int getColumnCount() {
		return (this.listlistOutput.size() + 3);
		//return 8;
	}	

	@Override
	public int getRowCount() {
		return dijkstra.getMaxTableLines();
	}
	
	@Override
	public Object getValueAt(int row, int column) {
		if (column == 0) {
			return row;
		} else if (column == 1) {
			if (row < listUsedNodes.size()) {
				return listUsedNodes.get(row);
			} else {
				return "";
			}
		} else if ((column > 1) && (column < (listlistOutput.size() + 2))) {
			if ((column-2) < listlistOutput.size()) {
				List<String> listOutput = listlistOutput.get(column-2);
				if (row < listOutput.size()) {
					return listOutput.get(row);
				} else {
					return "";
				}
			} else {
				return "";
			}
		} else if (column == (listlistOutput.size() + 2)) {
			if (row < listMin.size()) {
				return listMin.get(row);
			} else {
				return "";
			}			
		} else {
			return "";
		}
	}
}
