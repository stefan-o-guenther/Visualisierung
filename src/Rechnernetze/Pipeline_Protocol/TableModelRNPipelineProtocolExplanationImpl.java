/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Pipeline_Protocol;

import java.util.ArrayList;
import java.util.List;

import Base.TableModelExplanationAbstract;

public class TableModelRNPipelineProtocolExplanationImpl extends TableModelExplanationAbstract {

	private static final long serialVersionUID = 1L;

	public TableModelRNPipelineProtocolExplanationImpl() {
		super();	
	}
	
	@Override
	protected List<String> getListContent() {
		List<String> listContent = new ArrayList<String>();
		listContent.add("Paket");
		listContent.add("ACK");
		listContent.add("NAK");
		listContent.add("Paket/ACK verfälscht");
		listContent.add("ACK empfangen");
		listContent.add("Paket empfangen");
		listContent.add("nichts empfangen");
		return listContent;
	}
}
