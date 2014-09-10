/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Betriebssysteme.Buddy_Systeme;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import Base.PanelInitAbstract;

public class PanelBSBuddySystemeTableImpl extends PanelInitAbstract {
	
	private static final long serialVersionUID = 1L;
	
	public PanelBSBuddySystemeTableImpl(ManagementBuddyMemoryAllocation management) {
		super(management);
	}
	
	private PanelBSBuddySystemeTableImpl() {
		super(new ManagementBuddyMemoryAllocationImpl());
		this.initComponents();
		this.initLayout();
	}	
	
	private ManagementBuddyMemoryAllocation buddy;
	private JTable table;
	private TableModelBSBuddySystemeExplanationImpl tableModel;
	private TableColumnModelBSBuddySystemeExplanationImpl tableColumnModel;
	private JScrollPane scrollPane;
	
	@Override
	public void updatePanel() {
		tableModel.updateTableModel();
		scrollPane.getVerticalScrollBar().setValue(0);
	}

	@Override
	public Integer getPanelHeight() {
		return 0;
	}

	@Override
	public Integer getPanelWidth() {
		return 150;
	}

	@Override
	protected void initComponents() {
		buddy = (ManagementBuddyMemoryAllocation) this.getManagement();
		tableModel = new TableModelBSBuddySystemeExplanationImpl(buddy);
		tableColumnModel = new TableColumnModelBSBuddySystemeExplanationImpl(buddy);
		table = new JTable(tableModel, tableColumnModel);
		table.setEnabled(false);
		table.setBackground(Color.WHITE);
		table.setFillsViewportHeight(true);
		table.getColumnModel().getColumn(0).setMaxWidth(10);
		table.getColumnModel().getColumn(0).setMinWidth(10);
		table.setTableHeader(null);
		table.setShowGrid(true);
		scrollPane = new JScrollPane(table);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBackground(this.getBackground());
		scrollPane.setViewportView(table);
	}

	@Override
	protected void initLayout() {		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
		);
		setLayout(groupLayout);
	}
}
