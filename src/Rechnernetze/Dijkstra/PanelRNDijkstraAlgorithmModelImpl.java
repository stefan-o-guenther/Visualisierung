/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.CubicCurve2D;
import java.awt.image.BufferedImage;
import java.util.List;

import Base.PanelModelDrawAbstract;
import Base.EnumSurface;
import Base.ImageLoader;

public class PanelRNDijkstraAlgorithmModelImpl extends PanelModelDrawAbstract {

	public PanelRNDijkstraAlgorithmModelImpl(ManagementDijkstraAlgorithm dijkstra, ToolTipManagerDijkstraAlgorithm tooltip) {
		super(dijkstra, tooltip);
		this.dijkstra = dijkstra;
		initComponents();
		putModelToManagement();
		updateModel();
	}
	
	private ManagementDijkstraAlgorithm dijkstra;
	private Graphics2D g2d;
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
	
	private String nameU;
	private String nameV;
	private String nameW;
	private String nameX;
	private String nameY;
	private String nameZ;

	@Override
	protected void initComponents() {
		difPicX = 35;
		difPicY = 26;
		difX = 200;
		difY = 70;		
		x1 = 10;
		x2 = x1 + 850;
		x3 = x1 + difX;
		x4 = x2 - difX;		
		y1 = 110;
		y2 = y1 - difY;
		y3 = y1 + difY;
		
		nameU = "U";
		nameV = "V";
		nameW = "W";
		nameX = "X";
		nameY = "Y";
		nameZ = "Z";
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
		Edge edge = dijkstra.getEdge(nameU, nameV);
		if (edge != null) {
			drawEdgeText(edge, x1+difPicX+(difX/2)-6, y1+difPicY-(difY/2)-6);
			drawEdgeLine(edge, x1+difPicX, y1+difPicY, x3+difPicX, y2+difPicY);			
		}
	}
	
	private void drawEdgeUW() {
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
		Edge edge = dijkstra.getEdge(nameU, nameX);
		if (edge != null) {
			drawEdgeText(edge, x1+difPicX+(difX/2)-6, y1+difPicY+(difY/2)-6);
			drawEdgeLine(edge, x1+difPicX, y1+difPicY, x3+difPicX, y3+difPicY);	
		}
	}
	
	private void drawEdgeVW() {
		Edge edge = dijkstra.getEdge(nameV, nameW);
		if (edge != null) {
			drawEdgeText(edge, x3+difPicX+((x4-x3)/2)-45, y2+difPicY-6);
			drawEdgeLine(edge, x3+difPicX, y2+difPicY, x4+difPicX, y2+difPicY);
		}
	}
	
	private void drawEdgeVX() {
		Edge edge = dijkstra.getEdge(nameV, nameX);
		if (edge != null) {
			drawEdgeText(edge, x3+difPicX+6, y1+difPicY+6);
			drawEdgeLine(edge, x3+difPicX, y2+difPicY, x3+difPicX, y3+difPicY);
		}
	}
	
	private void drawEdgeWX() {
		Edge edge = dijkstra.getEdge(nameW, nameX);
		if (edge != null) {
			drawEdgeText(edge, x3+difPicX+((x4-x3)/2)-45, y1+difPicY+6);
			drawEdgeLine(edge, x3+difPicX, y3+difPicY, x4+difPicX, y2+difPicY);
		}
	}
	
	private void drawEdgeWY() {
		Edge edge = dijkstra.getEdge(nameW, nameY);
		if (edge != null) {
			drawEdgeText(edge, x4+difPicX+6, y1+difPicY+6);
			drawEdgeLine(edge, x4+difPicX, y2+difPicY, x4+difPicX, y3+difPicY);
		}
	}
	
	private void drawEdgeWZ() {
		Edge edge = dijkstra.getEdge(nameW, nameZ);
		if (edge != null) {
			drawEdgeText(edge, x2+difPicX-(difX/2)-6, y1+difPicY-(difY/2)-6);
			drawEdgeLine(edge, x4+difPicX, y2+difPicY, x2+difPicX, y1+difPicY);
		}
	}
	
	private void drawEdgeXY() {
		Edge edge = dijkstra.getEdge(nameX, nameY);
		if (edge != null) {
			drawEdgeText(edge, x3+difPicX+((x4-x3)/2)-45, y3+difPicY-6);
			drawEdgeLine(edge, x3+difPicX, y3+difPicY, x4+difPicX, y3+difPicY);
		}
	}
	
	private void drawEdgeYZ() {
		Edge edge = dijkstra.getEdge(nameY, nameZ);
		if (edge != null) {
			drawEdgeText(edge, x2+difPicX-(difX/2)-6, y1+difPicY+(difY/2)-6);
			drawEdgeLine(edge, x4+difPicX, y3+difPicY, x2+difPicX, y1+difPicY);
		}
	}
	
	private BufferedImage getRouterImage() {
		return ImageLoader.getBufferedImageRouter();
	}
	
	private void drawNodes() {
		font = g2d.getFont();
		g2d.setFont(new Font(font.getFontName(), Font.BOLD, 20));
		
		EnumSurface surface = dijkstra.getSurface();
		
		List<Node> listNodes = dijkstra.getListNodes();
		for (Node node : listNodes) {
			String name = node.getName();
			Integer x = node.getX();
			Integer y = node.getY();			
			g2d.drawImage(getRouterImage(), x, y, null);
			g2d.setColor(node.getColor(surface));
			g2d.drawString(name, x+difPicX-7, y+difPicY+15);		
		}
		
		Node nodeStart = listNodes.get(0);
		Node nodeTarget = listNodes.get(listNodes.size()-1);
		
		g2d.setColor(Color.BLACK);
		g2d.drawString("Start", nodeStart.getX()+difPicX-25, nodeStart.getY()+difPicY+40);
		
		g2d.setColor(Color.BLACK);
		g2d.drawString("Ziel", nodeTarget.getX()+difPicX-15, nodeTarget.getY()+difPicY+40);
		
		
		
		/*
		drawNodeU();
		drawNodeV();
		drawNodeW();
		drawNodeX();
		drawNodeY();
		drawNodeZ();
		*/
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
	
	private Integer tableX = 180;
	private Integer tableY = 240;
	private Integer lineHeight = 30;
	
	private Integer lengthStep = 80;
	private Integer lengthNodes = 150;
	private Integer lengthNodeOutput = 60;
	private Integer lengthMin = 70;
	
	private void drawBox(Integer line, String text, Integer x, Integer length, Color color) {
		if ((text != null) && (x != null) && (length != null) && (line != null) && (color != null)) {
			Integer x1 = x;
			Integer x2 = x1 + length;
			Integer y1 = tableY+(lineHeight*line);
			Integer y2 = y1+lineHeight;
			
			BasicStroke bs = new BasicStroke(2, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
	        g2d.setStroke(bs);	        
			
			g2d.setColor(Color.BLACK);
			g2d.drawLine(x1, y1, x2, y1);
			g2d.drawLine(x1, y2, x2, y2);
			g2d.drawLine(x1, y1, x1, y2);
			g2d.drawLine(x2, y1, x2, y2);
			
			g2d.setColor(color);
			g2d.setFont(new Font(font.getFontName(), Font.BOLD, 20));
			g2d.drawString(text, x1+10, y2-7);
		}
	}
	
	private void drawSteps() {
		Integer x = tableX;	
		Integer lines = dijkstra.getMaxTableLines();
		drawBox(0, "STEP", x, lengthStep, Color.BLACK);
		for (Integer i = 0; i < lines; i++) {
			drawBox(i+1, i.toString(), x, lengthStep, Color.BLACK);
		}
	}
	
	private void drawUsedNodes() {
		Integer x = tableX + lengthStep;
		drawBox(0, "    NODES", x, lengthNodes, Color.BLACK);
		Integer linesTable = dijkstra.getMaxTableLines();
		for (Integer i = 0; i < linesTable; i++) {
			String chain = "";
			List<List<String>> listlistUsedNodes = dijkstra.getListUsedNodes();
			if (i < listlistUsedNodes.size()) {
				List<String> listUsedNodes = listlistUsedNodes.get(i);
				for (Integer j = 0; j < listUsedNodes.size(); j++) {
					String node = listUsedNodes.get(j);
					if (j > 0) {
						chain = chain + " " + node;
					} else {
						chain = node;
					}
				}
			}
			drawBox(i+1, chain, x, lengthNodes, Color.BLACK);
		}
	}	
	
	private void drawNodesOutput() {
		EnumSurface surface = dijkstra.getSurface();
		List<String> listNodeNames = dijkstra.getListNodeNames();
		List<List<NodeOutput>> listlistNodeOutput = dijkstra.getListNodesOutput();
		Integer sizeNodeNames = listNodeNames.size();
		for (int i = 0; i < sizeNodeNames; i++) {
			Integer x = tableX + lengthStep + lengthNodes + (lengthNodeOutput * i);
			String name = listNodeNames.get(i);
			drawBox(0, name, x, lengthNodeOutput, Color.BLACK);			
			List<NodeOutput> listNodeOutput = listlistNodeOutput.get(i);
			Integer sizeList = listNodeOutput.size();
			Integer linesTable = dijkstra.getMaxTableLines();
			for (int j = 0; j < linesTable; j++) {				
				if (j < sizeList) {					
					NodeOutput nodeOutput = listNodeOutput.get(j);
					String output = nodeOutput.toString();
					drawBox(j+1, output, x, lengthNodeOutput, nodeOutput.getColor(surface));
				} else {
					drawBox(j+1, "", x, lengthNodeOutput, Color.BLACK);
				}					
			}		
		}				
	}
	
	private void drawMin() {
		EnumSurface surface = dijkstra.getSurface();
		List<MinOutput> listMin = dijkstra.getListMin();
		List<String> listNodeNames = dijkstra.getListNodeNames();		
		Integer linesList = listMin.size();
		Integer sizeNodes = listNodeNames.size();
		Integer x = tableX + lengthStep + lengthNodes + (lengthNodeOutput * sizeNodes);
		drawBox(0, "MIN", x, lengthMin, Color.BLACK);
		Integer linesTable = dijkstra.getMaxTableLines();
		for (int i = 0; i < linesTable; i++) {
			String minText = "";
			Color color = Color.BLACK;
			if (i < linesList) {
				MinOutput minOutput = listMin.get(i);
				minText = minOutput.toString();
				color = minOutput.getColor(surface);
			}
			drawBox(i+1, minText, x, lengthMin, color);
		}
	}
	
	private void drawTable() {				
		drawSteps();
		drawUsedNodes();
		drawNodesOutput();
		drawMin();
	}	
	
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
	
	@Override
	public void doDrawing(Graphics g) {
		g2d = (Graphics2D) g;
		font = g2d.getFont();		
				
		g2d.setColor(Color.BLACK);
			
		drawEdges();	
		drawNodes();
		drawTable();
		//drawRoute();
	}
}
