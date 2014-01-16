package Base;

import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public abstract class BasePanelModelScroll extends BasePanelModel {

	protected BasePanelModelDraw panelModelDraw;
	protected JScrollPane scrollPane;
	
	protected BasePanelModelScroll(BasePanelModelDraw modeldraw) {
		if (modeldraw != null) {
			panelModelDraw = modeldraw;
		}
	}
	
	protected void initComponents() {                
        //Put the drawing area in a scroll pane.
		scrollPane = new JScrollPane(panelModelDraw);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(200,200));
		
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
}
