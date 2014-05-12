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

public abstract class PanelModelScrollAbstract extends PanelModelAbstract implements PanelModelScroll {

	public PanelModelScrollAbstract(Management management, ToolTipManager tooltip) {
		super(management, tooltip);
		initComponents();
		initLayout();
	}
	
	protected JScrollPane scrollPane;
	protected PanelModelDrawAbstract panelModelDraw;
	
	protected abstract PanelModelDrawAbstract getNewPanelModelDraw();
	protected abstract EnumScrollbar getScrollbarHorizontal();
	protected abstract EnumScrollbar getScrollbarVertical();
	
	@Override
	public void initComponents() {
		panelModelDraw = this.getNewPanelModelDraw();
		
		//Put the drawing area in a scroll pane.
		scrollPane = new JScrollPane(panelModelDraw);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(200,200));
	}	
	
	public void initLayout() {		
		GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        scrollPane.setViewportView(panelModelDraw);
        setLayout(groupLayout);
	}
	
	@Override
	public void updateModel() {
		panelModelDraw.updateModel();
		scrollPane.getVerticalScrollBar().setValue(0);		
	}
}
