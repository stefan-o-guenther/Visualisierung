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

import Base.PanelLayoutAbstract;

public class PanelBSBuddySystemeTableImpl extends PanelLayoutAbstract {
	
	private static final long serialVersionUID = 1L;
	
	public PanelBSBuddySystemeTableImpl() {
		super();
		//this.initializeExtra();
		this.createPanel();
	}
	
	/*
	private void initializeExtra() {
		this.initializeComponents();
		this.initializeLayout();
	}
	*/
	
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
		return 50;
	}

	@Override
	public Integer getPanelWidth() {
		return 150;
	}

	@Override
	protected void createComponents() {
		tableModel = new TableModelBSBuddySystemeExplanationImpl();
		tableColumnModel = new TableColumnModelBSBuddySystemeExplanationImpl();
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
	protected void createLayout() {		
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
