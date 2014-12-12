/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Pipeline_Protocol;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;

import Base.ManagementFactory;

public class TableCellRendererRNPipelineProtocolExplanationImpl implements TableCellRenderer {

	public TableCellRendererRNPipelineProtocolExplanationImpl() {
		super();		
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		ManagementAutomaticRepeatRequest pipeline = ManagementFactory.getManagementAutomaticRepeatRequest();
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
			switch (row) {
				case 0: label.setBackground(pipeline.getColorData()); break;
				case 1: label.setBackground(pipeline.getColorAck()); break;
				case 2: label.setBackground(pipeline.getColorNak()); break;
				case 3: label.setBackground(pipeline.getColorBroken()); break;
				case 4: label.setBackground(pipeline.getColorSenderOk()); break;
				case 5: label.setBackground(pipeline.getColorReceiverOk()); break;
				case 6: label.setBackground(Color.WHITE);break;
				default: label.setBackground(Color.WHITE);break;
			}
		}
		return label;
	}
}