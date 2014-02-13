/**
 * @author:	Stefan Otto Günther
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

import Base.BasePanelModelDraw;
import Base.EnumSurface;
import Base.ImageLoader;

public class PanelRNDijkstraModel extends BasePanelModelDraw {

	public PanelRNDijkstraModel(IDijkstraAlgorithm idijkstra) {
		super();
		if (idijkstra == null) {
			idijkstra = new DijkstraAlgorithm();
		}
		dijkstra = idijkstra;
		dijkstra.setPanelModel(this);
		updateModel();
	}

	private IDijkstraAlgorithm dijkstra;
	private Graphics2D g2d;
	private Font font;
	
	private Integer difPicX = 35;
	private Integer difPicY = 26;
	private Integer difX = 200;
	private Integer difY = 70;		
	private Integer x1 = 30;
	private Integer x2 = x1 + 850;
	private Integer x3 = x1 + difX;
	private Integer x4 = x2 - difX;		
	private Integer y1 = 110;
	private Integer y2 = y1 - difY;
	private Integer y3 = y1 + difY;
	
	private final String nameU = "U";
	private final String nameV = "V";
	private final String nameW = "W";
	private final String nameX = "X";
	private final String nameY = "Y";
	private final String nameZ = "Z";		
	
	private void drawNodeU() {
		EnumSurface surface = dijkstra.getSurface();
		INode nodeU = dijkstra.getNode(nameU);
		if (nodeU != null) {
			g2d.drawImage(getRouterImage(), x1, y1, null);	// U
			g2d.setColor(nodeU.getColor(surface));
			g2d.drawString(nameU, x1+difPicX-7, y1+difPicY+15);
		}
	}
	
	private void drawNodeV() {
		EnumSurface surface = dijkstra.getSurface();
		INode nodeV = dijkstra.getNode(nameV);
		if (nodeV != null) {
			g2d.drawImage(getRouterImage(), x3, y2, null);	// V
			g2d.setColor(nodeV.getColor(surface));
			g2d.drawString(nameV, x3+difPicX-7, y2+difPicY+15);
		}
	}
	
	private void drawNodeW() {
		EnumSurface surface = dijkstra.getSurface();
		INode nodeW = dijkstra.getNode(nameW);
		if (nodeW != null) {
			g2d.drawImage(getRouterImage(), x4, y2, null);	// W
			g2d.setColor(nodeW.getColor(surface));
			g2d.drawString(nameW, x4+difPicX-7, y2+difPicY+15);
		}
	}
	
	private void drawNodeX() {
		EnumSurface surface = dijkstra.getSurface();
		INode nodeX = dijkstra.getNode(nameX);
		if (nodeX != null) {
			g2d.drawImage(getRouterImage(), x3, y3, null);	// X
			g2d.setColor(nodeX.getColor(surface));
			g2d.drawString(nameX, x3+difPicX-7, y3+difPicY+15);
		}
	}
	
	private void drawNodeY() {
		EnumSurface surface = dijkstra.getSurface();
		INode nodeY = dijkstra.getNode(nameY);
		if (nodeY != null) {
			g2d.drawImage(getRouterImage(), x4, y3, null);	// Y
			g2d.setColor(nodeY.getColor(surface));
			g2d.drawString(nameY, x4+difPicX-7, y3+difPicY+15);
		}
	}
	
	private void drawNodeZ() {
		EnumSurface surface = dijkstra.getSurface();
		INode nodeZ = dijkstra.getNode(nameZ);
		if (nodeZ != null) {
			g2d.drawImage(getRouterImage(), x2, y1, null);	// Z	
			g2d.setColor(nodeZ.getColor(surface));
			g2d.drawString(nameZ, x2+difPicX-7, y1+difPicY+15);
		}
	}
	
	private void drawEdgeLine(IEdge edge, Integer x1, Integer y1, Integer x2, Integer y2) {
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
	
	private void drawEdgeText(IEdge edge, Integer x, Integer y) {
		EnumSurface surface = dijkstra.getSurface();
		if ((edge != null) && (x != null) && (y != null)) {
			g2d.setFont(new Font(font.getFontName(), Font.BOLD, 20));
			g2d.setColor(edge.getColor(surface));
			g2d.drawString(edge.getWeight().toString(), x, y);
		}
	}
	
	
	private void drawEdgeUV() {
		IEdge edge = dijkstra.getEdge(nameU, nameV);
		if (edge != null) {
			drawEdgeText(edge, x1+difPicX+(difX/2)-6, y1+difPicY-(difY/2)-6);
			drawEdgeLine(edge, x1+difPicX, y1+difPicY, x3+difPicX, y2+difPicY);			
		}
	}
	
	private void drawEdgeUW() {
		EnumSurface surface = dijkstra.getSurface();
		IEdge edge = dijkstra.getEdge(nameU, nameW);
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
		IEdge edge = dijkstra.getEdge(nameU, nameX);
		if (edge != null) {
			drawEdgeText(edge, x1+difPicX+(difX/2)-6, y1+difPicY+(difY/2)-6);
			drawEdgeLine(edge, x1+difPicX, y1+difPicY, x3+difPicX, y3+difPicY);	
		}
	}
	
	private void drawEdgeVW() {
		IEdge edge = dijkstra.getEdge(nameV, nameW);
		if (edge != null) {
			drawEdgeText(edge, x3+difPicX+((x4-x3)/2)-45, y2+difPicY-6);
			drawEdgeLine(edge, x3+difPicX, y2+difPicY, x4+difPicX, y2+difPicY);
		}
	}
	
	private void drawEdgeVX() {
		IEdge edge = dijkstra.getEdge(nameV, nameX);
		if (edge != null) {
			drawEdgeText(edge, x3+difPicX+6, y1+difPicY+6);
			drawEdgeLine(edge, x3+difPicX, y2+difPicY, x3+difPicX, y3+difPicY);
		}
	}
	
	private void drawEdgeWX() {
		IEdge edge = dijkstra.getEdge(nameW, nameX);
		if (edge != null) {
			drawEdgeText(edge, x3+difPicX+((x4-x3)/2)-45, y1+difPicY+6);
			drawEdgeLine(edge, x3+difPicX, y3+difPicY, x4+difPicX, y2+difPicY);
		}
	}
	
	private void drawEdgeWY() {
		IEdge edge = dijkstra.getEdge(nameW, nameY);
		if (edge != null) {
			drawEdgeText(edge, x4+difPicX+6, y1+difPicY+6);
			drawEdgeLine(edge, x4+difPicX, y2+difPicY, x4+difPicX, y3+difPicY);
		}
	}
	
	private void drawEdgeWZ() {
		IEdge edge = dijkstra.getEdge(nameW, nameZ);
		if (edge != null) {
			drawEdgeText(edge, x2+difPicX-(difX/2)-6, y1+difPicY-(difY/2)-6);
			drawEdgeLine(edge, x4+difPicX, y2+difPicY, x2+difPicX, y1+difPicY);
		}
	}
	
	private void drawEdgeXY() {
		IEdge edge = dijkstra.getEdge(nameX, nameY);
		if (edge != null) {
			drawEdgeText(edge, x3+difPicX+((x4-x3)/2)-45, y3+difPicY-6);
			drawEdgeLine(edge, x3+difPicX, y3+difPicY, x4+difPicX, y3+difPicY);
		}
	}
	
	private void drawEdgeYZ() {
		IEdge edge = dijkstra.getEdge(nameY, nameZ);
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
		drawNodeU();
		drawNodeV();
		drawNodeW();
		drawNodeX();
		drawNodeY();
		drawNodeZ();
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
	
	private Integer tableX = 20;
	private Integer tableY = 250;
	private Integer lineHeight = 30;
	
	private Integer lengthStep = 70;
	private Integer lengthNodes = 135;
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
		List<List<INodeOutput>> listlistNodeOutput = dijkstra.getListNodesOutput();
		Integer sizeNodeNames = listNodeNames.size();
		for (int i = 0; i < sizeNodeNames; i++) {
			Integer x = tableX + lengthStep + lengthNodes + (lengthNodeOutput * i);
			String name = listNodeNames.get(i);
			drawBox(0, name, x, lengthNodeOutput, Color.BLACK);			
			List<INodeOutput> listNodeOutput = listlistNodeOutput.get(i);
			Integer sizeList = listNodeOutput.size();
			Integer linesTable = dijkstra.getMaxTableLines();
			for (int j = 0; j < linesTable; j++) {				
				if (j < sizeList) {					
					INodeOutput nodeOutput = listNodeOutput.get(j);
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
		List<IMinOutput> listMin = dijkstra.getListMin();
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
				IMinOutput minOutput = listMin.get(i);
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
	protected void doDrawing(Graphics g) {
		g2d = (Graphics2D) g;
		font = g2d.getFont();		
				
		g2d.setColor(Color.BLACK);
			
		drawEdges();	
		drawNodes();
		drawTable();
		//drawRoute();
	}

	@Override
	public void updateModel() {
		repaint();		
	}
}
