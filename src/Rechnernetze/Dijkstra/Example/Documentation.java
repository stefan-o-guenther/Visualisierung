package Rechnernetze.Dijkstra.Example;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class Documentation extends JPanel {

	// Documentation on top of the screen

	    DocOptions docopt = new DocOptions(this);

	    DocText doctext = new DocText();



	    Documentation() {

		setLayout(new BorderLayout(10, 10));

		add("West", docopt);

		add("Center", doctext);

	    }

	}