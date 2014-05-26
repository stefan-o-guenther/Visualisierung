package Betriebssysteme.Belegungsstrategien;

import Base.MessageBox;
import Base.PanelAutomaticAbstract;

public class PanelBSBelegungsstrategienAutomaticImpl extends PanelAutomaticAbstract {

	public PanelBSBelegungsstrategienAutomaticImpl(ManagementFragmentation management) {	
		super(management);
		this.initPanel();	
	}
	
	@Override
	public void error() {
		MessageBox.showErrorMessage("Keinen passenden freien Speicher gefunden!");		
	}
}