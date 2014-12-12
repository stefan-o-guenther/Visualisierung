/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra_Algorithmus;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.CubicCurve2D;
import java.awt.image.BufferedImage;
import java.util.List;

import Base.EnumSurface;
import Base.ImageLoader;
import Base.ManagementFactory;
import Base.PanelDrawingAbstract;

public class PanelRNDijkstraAlgorithmModelImpl extends PanelDrawingAbstract {

	private static final long serialVersionUID = 1L;
	
	public PanelRNDijkstraAlgorithmModelImpl() {
		super();
		this.createPanel();
	}
	
	private ManagementDijkstraAlgorithm dijkstra;
	private Font font;
	
	private Integer difPicX;
	private Integer difPicY;
	private Integer difX;
	private Integer difY;		
	private Integer x1;
	private Integer x2;
	private Integer x3;
	private Integer x4;		
	private Integer y1;
	private Integer y2;
	private Integer y3;
	
	private List<String> listNodeNames;	
	
	@Override
	protected void createDrawing() {
		this.dijkstra = ManagementFactory.getManagementDijkstraAlgorithm();
		
		difPicX = 35;
		difPicY = 26;
		difX = 200;
		difY = 70;		
		x1 = 10;
		x2 = x1 + 700;
		x3 = x1 + difX;
		x4 = x2 - difX;		
		y1 = 110;
		y2 = y1 - difY;
		y3 = y1 + difY;
		
		listNodeNames = dijkstra.getListNodeNames();
	}	
	
	@Override
	protected void doDrawing() {
		font = g2d.getFont();				
		g2d.setColor(Color.BLACK);			
		drawEdges();	
		drawNodes();		
		//drawRoute();
	}
	
	private void drawEdgeLine(Edge edge, Integer x1, Integer y1, Integer x2, Integer y2) {
		EnumSurface surface = dijkstra.getSurface();
		if ((edge != null) && (x1 != null) && (y1 != null) && (x2 != null) && (y2 != null)) {
			Integer b = 2;
			if (edge.getStatus() == EnumOutputStatus.ROUTE) {
				b = 5;
			}
			BasicStroke bs = new BasicStroke(b, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
			g2d.setStroke(bs);
			g2d.setColor(edge.getColor(surface));
			g2d.drawLine(x1, y1, x2, y2);
		}		
	}
	
	private void drawEdgeText(Edge edge, Integer x, Integer y) {
		EnumSurface surface = dijkstra.getSurface();
		if ((edge != null) && (x != null) && (y != null)) {
			g2d.setFont(new Font(font.getFontName(), Font.BOLD, 20));
			g2d.setColor(edge.getColor(surface));
			g2d.drawString(edge.getWeight().toString(), x, y);
		}
	}
	
	
	private void drawEdgeUV() {
		String nameU = this.listNodeNames.get(0);
		String nameV = this.listNodeNames.get(1);
		Edge edge = dijkstra.getEdge(nameU, nameV);
		if (edge != null) {
			drawEdgeText(edge, x1+difPicX+(difX/2)-6, y1+difPicY-(difY/2)-6);
			drawEdgeLine(edge, x1+difPicX, y1+difPicY, x3+difPicX, y2+difPicY);			
		}
	}
	
	private void drawEdgeUW() {
		String nameU = this.listNodeNames.get(0);
		String nameW = this.listNodeNames.get(2);
		EnumSurface surface = dijkstra.getSurface();
		Edge edge = dijkstra.getEdge(nameU, nameW);
		if (edge != null) {
			drawEdgeText(edge, x1+difPicX+(difX/2)-6, y1+difPicY-98);
			Integer b = 2;
			if (edge.getStatus() == EnumOutputStatus.ROUTE) {
				b = 5;
			}
			BasicStroke bs = new BasicStroke(b, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
			g2d.setStroke(bs);
			g2d.setColor(edge.getColor(surface));
			g2d.draw(new CubicCurve2D.Double(x1+difPicX, y1+difPicY, x1+difPicX+20, y1+difPicY-170, x3+difPicX, y2+difPicY-80, x4+difPicX, y2+difPicY));	// UW
		}
	}	
	
	private void drawEdgeUX() {
		String nameU = this.listNodeNames.get(0);
		String nameX = this.listNodeNames.get(3);
		Edge edge = dijkstra.getEdge(nameU, nameX);
		if (edge != null) {
			drawEdgeText(edge, x1+difPicX+(difX/2)-6, y1+difPicY+(difY/2)-6);
			drawEdgeLine(edge, x1+difPicX, y1+difPicY, x3+difPicX, y3+difPicY);	
		}
	}
	
	private void drawEdgeVW() {
		String nameV = this.listNodeNames.get(1);
		String nameW = this.listNodeNames.get(2);
		Edge edge = dijkstra.getEdge(nameV, nameW);
		if (edge != null) {
			drawEdgeText(edge, x3+difPicX+((x4-x3)/2)-45, y2+difPicY-6);
			drawEdgeLine(edge, x3+difPicX, y2+difPicY, x4+difPicX, y2+difPicY);
		}
	}
	
	private void drawEdgeVX() {
		String nameV = this.listNodeNames.get(1);
		String nameX = this.listNodeNames.get(3);
		Edge edge = dijkstra.getEdge(nameV, nameX);
		if (edge != null) {
			drawEdgeText(edge, x3+difPicX+6, y1+difPicY+6);
			drawEdgeLine(edge, x3+difPicX, y2+difPicY, x3+difPicX, y3+difPicY);
		}
	}
	
	private void drawEdgeWX() {
		String nameW = this.listNodeNames.get(2);
		String nameX = this.listNodeNames.get(3);
		Edge edge = dijkstra.getEdge(nameW, nameX);
		if (edge != null) {
			drawEdgeText(edge, x3+difPicX+((x4-x3)/2)-45, y1+difPicY+6);
			drawEdgeLine(edge, x3+difPicX, y3+difPicY, x4+difPicX, y2+difPicY);
		}
	}
	
	private void drawEdgeWY() {
		String nameW = this.listNodeNames.get(2);
		String nameY = this.listNodeNames.get(4);
		Edge edge = dijkstra.getEdge(nameW, nameY);
		if (edge != null) {
			drawEdgeText(edge, x4+difPicX+6, y1+difPicY+6);
			drawEdgeLine(edge, x4+difPicX, y2+difPicY, x4+difPicX, y3+difPicY);
		}
	}
	
	private void drawEdgeWZ() {
		String nameW = this.listNodeNames.get(2);
		String nameZ = this.listNodeNames.get(5);
		Edge edge = dijkstra.getEdge(nameW, nameZ);
		if (edge != null) {
			drawEdgeText(edge, x2+difPicX-(difX/2)-6, y1+difPicY-(difY/2)-6);
			drawEdgeLine(edge, x4+difPicX, y2+difPicY, x2+difPicX, y1+difPicY);
		}
	}
	
	private void drawEdgeXY() {
		String nameX = this.listNodeNames.get(3);
		String nameY = this.listNodeNames.get(4);
		Edge edge = dijkstra.getEdge(nameX, nameY);
		if (edge != null) {
			drawEdgeText(edge, x3+difPicX+((x4-x3)/2)-45, y3+difPicY-6);
			drawEdgeLine(edge, x3+difPicX, y3+difPicY, x4+difPicX, y3+difPicY);
		}
	}
	
	private void drawEdgeYZ() {		
		String nameY = this.listNodeNames.get(4);
		String nameZ = this.listNodeNames.get(5);
		Edge edge = dijkstra.getEdge(nameY, nameZ);
		if (edge != null) {
			drawEdgeText(edge, x2+difPicX-(difX/2)-6, y1+difPicY+(difY/2)-6);
			drawEdgeLine(edge, x4+difPicX, y3+difPicY, x2+difPicX, y1+difPicY);
		}
	}
	
	private BufferedImage getRouterImage() throws Exception {
		return ImageLoader.getBufferedImageRouter();
	}
	
	private void drawNodes() {		
		this.drawNodeU();
		this.drawNodeV();
		this.drawNodeW();
		this.drawNodeX();
		this.drawNodeY();
		this.drawNodeZ();		
	}
	
	private void drawNodeImage(Integer x, Integer y, Node node) {
		try {
			font = g2d.getFont();
			g2d.setFont(new Font(font.getFontName(), Font.BOLD, 20));
			
			EnumSurface surface = dijkstra.getSurface();
			if ((x == null) || (y == null) || (node == null)) {
				throw new NullPointerException();
			}
			g2d.drawImage(getRouterImage(), x, y, null);
			g2d.setColor(node.getColor(surface));
			g2d.drawString(node.getName(), x+difPicX-7, y+difPicY+15);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void drawNodeU() {
		String name = this.listNodeNames.get(0);
		Node node = dijkstra.getNode(name);
		Integer x = x1;
		Integer y = y1;
		this.drawNodeImage(x, y, node);
		g2d.setColor(Color.BLACK);
		if (node.getType() == EnumNodeType.START) {
			g2d.drawString("Start", x+difPicX-25, y+difPicY+40);
		} else if (node.getType() == EnumNodeType.TARGET) {
			g2d.drawString("Ziel", x+difPicX-15, y+difPicY+40);
		}
	}
	
	private void drawNodeV() {
		String name = this.listNodeNames.get(1);
		Node node = dijkstra.getNode(name);
		Integer x = x3;
		Integer y = y2;
		this.drawNodeImage(x, y, node);
		g2d.setColor(Color.BLACK);
		if (node.getType() == EnumNodeType.START) {
			g2d.drawString("Start", x+difPicX-25, y+difPicY-30);
		} else if (node.getType() == EnumNodeType.TARGET) {
			g2d.drawString("Ziel", x+difPicX-15, y+difPicY-30);
		}
	}

	private void drawNodeW() {
		String name = this.listNodeNames.get(2);
		Node node = dijkstra.getNode(name);
		Integer x = x4;
		Integer y = y2;
		this.drawNodeImage(x, y, node);
		g2d.setColor(Color.BLACK);
		if (node.getType() == EnumNodeType.START) {
			g2d.drawString("Start", x+difPicX-25, y+difPicY-30);
		} else if (node.getType() == EnumNodeType.TARGET) {
			g2d.drawString("Ziel", x+difPicX-15, y+difPicY-30);
		}
	}

	private void drawNodeX() {
		String name = this.listNodeNames.get(3);
		Node node = dijkstra.getNode(name);
		Integer x = x3;
		Integer y = y3;
		this.drawNodeImage(x, y, node);
		g2d.setColor(Color.BLACK);
		if (node.getType() == EnumNodeType.START) {
			g2d.drawString("Start", x+difPicX-25, y+difPicY+40);
		} else if (node.getType() == EnumNodeType.TARGET) {
			g2d.drawString("Ziel", x+difPicX-15, y+difPicY+40);
		}
	}

	private void drawNodeY() {
		String name = this.listNodeNames.get(4);
		Node node = dijkstra.getNode(name);
		Integer x = x4;
		Integer y = y3;
		this.drawNodeImage(x, y, node);
		g2d.setColor(Color.BLACK);
		if (node.getType() == EnumNodeType.START) {
			g2d.drawString("Start", x+difPicX-25, y+difPicY+40);
		} else if (node.getType() == EnumNodeType.TARGET) {
			g2d.drawString("Ziel", x+difPicX-15, y+difPicY+40);
		}
	}

	private void drawNodeZ() {
		String name = this.listNodeNames.get(5);
		Node node = dijkstra.getNode(name);
		Integer x = x2;
		Integer y = y1;
		this.drawNodeImage(x, y, node);
		g2d.setColor(Color.BLACK);
		if (node.getType() == EnumNodeType.START) {
			g2d.drawString("Start", x+difPicX-25, y+difPicY+40);
		} else if (node.getType() == EnumNodeType.TARGET) {
			g2d.drawString("Ziel", x+difPicX-15, y+difPicY+40);
		}
	}
	
	private void drawEdges() {
		drawEdgeUV();
		drawEdgeUW();
		drawEdgeUX();
		drawEdgeVW();
		drawEdgeVX();
		drawEdgeWX();
		drawEdgeWY();
		drawEdgeWZ();
		drawEdgeXY();
		drawEdgeYZ();
	}

	@Override
	public Integer getPanelHeight() {
		return 250;
	}

	@Override
	public Integer getPanelWidth() {
		return 100;
	}		
	
	/*
	private void drawRoute() {
		BasicStroke bs = new BasicStroke(5, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
        g2d.setStroke(bs);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font(font.getFontName(), Font.BOLD, 24));
		List<String> listRoute = dijkstra.getListRoute();
		Integer size = listRoute.size();
		String text = "";
		for (int i = 0; i < size; i++) {
			if (i == 0) {
				text = listRoute.get(i);
			} else {
				text = text + " " + Character.toString('\u2190') + " "+ listRoute.get(i);
			}
		}
		g2d.drawString(text, 20, 500);
	}
	*/		
}
