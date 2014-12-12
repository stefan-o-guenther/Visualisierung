/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Betriebssysteme.Buddy_Systeme;

import java.awt.Color;
import java.awt.Component;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;

import Base.ManagementFactory;

public class TableCellRendererBSBuddySystemeExplanationImpl implements TableCellRenderer {

	public TableCellRendererBSBuddySystemeExplanationImpl() {
		super();
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		ManagementBuddyMemoryAllocation buddy = ManagementFactory.getManagementBuddyMemoryAllocation();
		JLabel label = new JLabel((String)value);
		label.setOpaque(true);
		Border b = BorderFactory.createEmptyBorder(1, 5, 1, 1);
		label.setBorder(b);
		label.setFont(table.getFont());
		label.setForeground(table.getForeground());
		label.setBackground(table.getBackground());
		if (column == 1) {
			label.setBackground(Color.WHITE);
		} else {
			if (row == 0) {
				label.setBackground(buddy.getColorBuddy());
			} else if (row == 1) {
				label.setBackground(buddy.getColorRest());
			} else {
				int i = row - 2;
				List<ProcessNode> listProcesses = buddy.getListRunningProcesses();
				ProcessNode pn = listProcesses.get(i);
				String name = pn.getName();
				Color color = buddy.getColorProcessNode(name);
				label.setBackground(color);
			}
		}
		return label;
	}
}