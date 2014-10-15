/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class PanelScrollImpl extends PanelLayoutAbstract {

	private static final long serialVersionUID = 1L;

	public PanelScrollImpl(PanelAbstract panel, EnumScrollbar scrollbarHorizontal, EnumScrollbar scrollbarVertical) {
		super();
		try {
			if ((panel == null) || (scrollbarHorizontal == null) || (scrollbarVertical == null)) {
				throw new NullPointerException();
			}
			this.panel = panel;
			this.createHorizontalScrollBarPolicy(scrollbarHorizontal);
			this.createVerticalScrollBarPolicy(scrollbarVertical);
			this.createPanel();
		} catch (Exception ex) {
			throw ex;
		}		
	}
	
	private JScrollPane scrollPane;
	private PanelAbstract panel;
	
	private int horizontalScrollBarPolicy;
	private int verticalScrollBarPolicy;
	
	private void createHorizontalScrollBarPolicy(EnumScrollbar scrollbarHorizontal) {
		int policy = 0;
		switch (scrollbarHorizontal) {
			case ALWAYS: policy = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS; break;
			case AS_NEEDED: policy = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED; break;
			case NEVER: policy = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER; break;
			default: throw new IllegalArgumentException();
		}
		this.horizontalScrollBarPolicy = policy;
	}
	
	private void createVerticalScrollBarPolicy(EnumScrollbar scrollbarVertical) {
		int policy = 0;
		switch (scrollbarVertical) {
			case ALWAYS: policy = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS; break;
			case AS_NEEDED: policy = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED; break;
			case NEVER: policy = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER; break;
			default: throw new IllegalArgumentException();
		}
		this.verticalScrollBarPolicy = policy;
	}
	
	@Override
	protected void createComponents() {
		//Put the drawing area in a scroll pane.
		scrollPane = new JScrollPane(panel);
		scrollPane.setHorizontalScrollBarPolicy(this.horizontalScrollBarPolicy);
		scrollPane.setVerticalScrollBarPolicy(this.verticalScrollBarPolicy);
		scrollPane.setPreferredSize(new Dimension(200,200));
		scrollPane.setViewportView(panel);
	}	
	
	@Override
	protected void createLayout() {		
		GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );        
        setLayout(groupLayout);
	}
	
	@Override
	public void updatePanel() {
		panel.updatePanel();
		//scrollPane.setHorizontalScrollBarPolicy(this.getHorizontalScrollBarPolicy());
		//scrollPane.setVerticalScrollBarPolicy(this.getVerticalScrollBarPolicy());
		scrollPane.getVerticalScrollBar().setValue(0);			
	}
	@Override
	public Integer getPanelHeight() {
		return panel.getPanelHeight();
	}
	@Override
	public Integer getPanelWidth() {
		return panel.getPanelWidth();
	}
}
