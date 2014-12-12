package Base;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public abstract class TableModelExplanationAbstract extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	public TableModelExplanationAbstract() {
		super();
		this.initializeListContent();		
	}
	
	private List<String> listContent;
		
	protected abstract List<String> getListContent();
		
	private void initializeListContent() {
		this.listContent = this.getListContent();
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
