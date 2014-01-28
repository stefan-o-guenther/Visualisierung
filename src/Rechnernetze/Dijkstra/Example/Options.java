package Rechnernetze.Dijkstra.Example;

import java.awt.Button;
import java.awt.Event;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Options extends JPanel {

	// set of options at the right of the screen

	    Button b1 = new Button("clear");

	    Button b2 = new Button("run");

	    Button b3 = new Button("step");

	    Button b4 = new Button("reset");

	    Button b5 = new Button("example");

	    Button b6 = new Button("exit");

	    GraphAlgorithm parent;   

	    boolean Locked=false;

	  

	    Options(GraphAlgorithm myparent) {

		parent = myparent;

		setLayout(new GridLayout(6, 1, 0, 10));

		add(b1);

		add(b2);

		add(b3);

		add(b4);

		add(b5); 

		add(b6);

	    }



	    public boolean action(Event evt, Object arg) {

		if (evt.target instanceof Button) {

		  if (((String)arg).equals("step")) {

		     if (!Locked) {

		        b3.setLabel("next step");

		        parent.graphcanvas.stepalg();

		     }

		     else parent.documentation.doctext.showline("locked");

		  }

		  if (((String)arg).equals("next step")) 

		     parent.graphcanvas.nextstep();

		  if (((String)arg).equals("reset")) { 

		     parent.graphcanvas.reset();

		     b3.setLabel("step");

		     parent.documentation.doctext.showline("all items");

		  }

		  if (((String)arg).equals("clear")) { 

		     parent.graphcanvas.clear();

		     b3.setLabel("step");

		     parent.documentation.doctext.showline("all items");

		  }

		  if (((String)arg).equals("run")) {

		     if (!Locked)  

		        parent.graphcanvas.runalg();

		     else parent.documentation.doctext.showline("locked");

		  }

		  if (((String)arg).equals("example")) {

		     if (!Locked)   

		        parent.graphcanvas.showexample();

		     else parent.documentation.doctext.showline("locked");

		  } 

		  if (((String)arg).equals("exit")) { 

		     System.exit(0);

		  } 

		}                   

		return true; 

	    }

	    

	    public void lock() {

		Locked=true;

	    }



	    public void unlock() {

		Locked=false;

		b3.setLabel("step"); 

	    } 

	}    





