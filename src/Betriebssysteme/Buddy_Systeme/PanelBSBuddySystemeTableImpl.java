/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Betriebssysteme.Buddy_Systeme;

import javax.swing.table.TableColumnModel;

import Base.EnumScrollbarPolicy;
import Base.PanelScrollTableAbstract;
import Base.TableColumnModelExplanationImpl;
import Base.TableModelExplanationAbstract;

public class PanelBSBuddySystemeTableImpl extends PanelScrollTableAbstract {
	
	private static final long serialVersionUID = 1L;
	
	public PanelBSBuddySystemeTableImpl() {
		super(EnumScrollbarPolicy.NEVER, EnumScrollbarPolicy.ALWAYS);
		this.createPanel();
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
	protected TableModelExplanationAbstract getNewTableModel() {
		return new TableModelBSBuddySystemeExplanationImpl();
	}

	@Override
	protected TableColumnModel getNewTableColumnModel() {		
		return new TableColumnModelExplanationImpl(new TableCellRendererBSBuddySystemeExplanationImpl());
	}
}
