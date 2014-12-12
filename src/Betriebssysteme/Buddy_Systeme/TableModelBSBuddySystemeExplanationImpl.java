/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Betriebssysteme.Buddy_Systeme;

import java.util.ArrayList;
import java.util.List;

import Base.ManagementFactory;
import Base.TableModelExplanationAbstract;

public class TableModelBSBuddySystemeExplanationImpl extends TableModelExplanationAbstract {

	private static final long serialVersionUID = 1L;

	public TableModelBSBuddySystemeExplanationImpl() {
		super();	
	}
	
	@Override
	protected List<String> getListContent() {
		ManagementBuddyMemoryAllocation buddy = ManagementFactory.getManagementBuddyMemoryAllocation();
		List<String> listContent = new ArrayList<String>();
		listContent.add("Frei");
		listContent.add("Verschnitt");
		List<ProcessNode> listProcesses = buddy.getListRunningProcesses();
		for (ProcessNode pn : listProcesses) {
			BuddyNode parent = pn.getParent();
			RestNode rest = parent.getRestNode();
			Integer restValue = rest.getValue();
			Integer processValue = pn.getValue();
			String name = pn.getName();
			String text = (name + " (" + processValue + " / " + restValue + ")");
			listContent.add(text);
		}		
		return listContent;
	}
}
