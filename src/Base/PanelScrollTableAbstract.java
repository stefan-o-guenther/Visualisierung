package Base;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

public abstract class PanelScrollTableAbstract extends PanelScrollAbstract {

	private static final long serialVersionUID = 1L;

	public PanelScrollTableAbstract(EnumScrollbarPolicy scrollbarPolicyHorizontal, EnumScrollbarPolicy scrollbarPolicyVertical) {
		super(scrollbarPolicyHorizontal, scrollbarPolicyVertical);
		this.createTable();
	}
	
	private JTable table;
	private TableModelExplanationAbstract tableModel;
	private TableColumnModel tableColumnModel;
	
	protected abstract TableModelExplanationAbstract getNewTableModel();
	protected abstract TableColumnModel getNewTableColumnModel();
	
	private void createTable() {
		tableModel = this.getNewTableModel();
		tableColumnModel = this.getNewTableColumnModel();	
		table = new JTable(tableModel, tableColumnModel);
		table.setEnabled(false);
		table.setBackground(Color.WHITE);
		table.setFillsViewportHeight(true);
		table.getColumnModel().getColumn(0).setMaxWidth(10);
		table.getColumnModel().getColumn(0).setMinWidth(10);
		table.setTableHeader(null);
		table.setShowGrid(true);
	}
	
	@Override
	protected Component getComponent() {
		return table;
	}

	@Override
	protected void updateComponent() {
		tableModel.updateTableModel();
	}
}
