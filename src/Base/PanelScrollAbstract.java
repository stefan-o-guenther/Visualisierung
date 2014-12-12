/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import java.awt.Component;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public abstract class PanelScrollAbstract extends PanelLayoutAbstract {

	private static final long serialVersionUID = 1L;

	public PanelScrollAbstract(EnumScrollbarPolicy scrollbarPolicyHorizontal, EnumScrollbarPolicy scrollbarPolicyVertical) {
		super();
		try {
			Checker.checkIfNotNull(scrollbarPolicyHorizontal);
			Checker.checkIfNotNull(scrollbarPolicyVertical);
			this.createHorizontalScrollBarPolicy(scrollbarPolicyHorizontal);
			this.createVerticalScrollBarPolicy(scrollbarPolicyVertical);
			//this.createExtra();
		} catch (Exception ex) {
			throw ex;
		}		
	}
	
	private void createExtra() {
		this.createHorizontalScrollBarPolicy(EnumScrollbarPolicy.ALWAYS);
		this.createVerticalScrollBarPolicy(EnumScrollbarPolicy.ALWAYS);
		this.createComponents();
		this.createLayout();
	}
	
	private JScrollPane scrollPane;
	
	private int horizontalScrollBarPolicy;
	private int verticalScrollBarPolicy;
	
	protected abstract Component getComponent();
	protected abstract void updateComponent();
	
	private void createHorizontalScrollBarPolicy(EnumScrollbarPolicy scrollbarHorizontal) {
		int policy = 0;
		switch (scrollbarHorizontal) {
			case ALWAYS: policy = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS; break;
			case AS_NEEDED: policy = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED; break;
			case NEVER: policy = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER; break;
			default: throw new IllegalArgumentException();
		}
		this.horizontalScrollBarPolicy = policy;
	}
	
	private void createVerticalScrollBarPolicy(EnumScrollbarPolicy scrollbarVertical) {
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
		Component component = this.getComponent();
		scrollPane = new JScrollPane(component);
		scrollPane.setHorizontalScrollBarPolicy(horizontalScrollBarPolicy);
		scrollPane.setVerticalScrollBarPolicy(verticalScrollBarPolicy);
		scrollPane.setBackground(this.getBackground());
		scrollPane.setViewportView(component);
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
		this.updateComponent();
		scrollPane.getVerticalScrollBar().setValue(0);
		scrollPane.getHorizontalScrollBar().setValue(0);
	}
}
