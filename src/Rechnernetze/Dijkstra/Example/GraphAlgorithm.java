package Rechnernetze.Dijkstra.Example;
import java.awt.*;import javax.swing.JPanel;



public class GraphAlgorithm extends java.applet.Applet {

    GraphCanvas graphcanvas = new GraphCanvas(this);
    Options options = new Options(this);   
    Documentation documentation = new Documentation();

    public void init() {
	setLayout(new BorderLayout(10, 10));
	add("Center", graphcanvas);
	add("North", documentation);
	add("East", options);
    }

    public Insets insets() {
	return new Insets(10, 10, 10, 10);
    }

    public void lock() {
	graphcanvas.lock();
	options.lock();
    } 

    public void unlock() {
	graphcanvas.unlock();
	options.unlock();
    } 
}


