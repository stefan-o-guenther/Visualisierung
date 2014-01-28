package Rechnernetze.Dijkstra.Example;

import java.awt.Choice;
import java.awt.Event;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.JPanel;

public class DocOptions extends JPanel {

    Choice doc = new Choice();

    Documentation parent;     

    DocOptions(Documentation myparent) {
		setLayout(new GridLayout(2, 1, 5, 0));	
		parent = myparent;	
		add(new Label("DOCUMENTATION:"));	
		doc.addItem("draw nodes");	
		doc.addItem("remove nodes"); 	
		doc.addItem("move nodes");	
		doc.addItem("the startnode");	
		doc.addItem("draw arrows"); 	
		doc.addItem("change weights");	
		doc.addItem("remove arrows");	
		doc.addItem("clear / reset"); 	
		doc.addItem("run algorithm");	
		doc.addItem("step through");	
		doc.addItem("example"); 	
		doc.addItem("exit"); 	
		doc.addItem("all items");	
		add(doc);
    } 

    public boolean action(Event evt, Object arg) {
        if (evt.target instanceof Choice) {
        	String str=new String(doc.getSelectedItem());
        	parent.doctext.showline(str);  

        }             
       	return true;
    }
}