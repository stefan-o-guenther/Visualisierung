/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import Base.MainAbstract;

public class Seitenersetzungsstrategien extends MainAbstract {

	public Seitenersetzungsstrategien() {
		super();
	}
	
	public static void main(String[] args) {
		ManagementPaging paging = new ManagementPagingImpl();
		initialize();		
    	panelMain = new PanelBSSeitenersetzungsstrategienMainImpl(paging);    	
    	baseMain();	
    }
}