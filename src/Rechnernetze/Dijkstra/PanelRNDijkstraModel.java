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
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import Base.BasePanelModelDraw;
import Base.EnumSurface;
import Base.ImageLoader;

public class PanelRNDijkstraModel extends BasePanelModelDraw {

	private EnumSurface surface;
	
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
	
	private Integer linesTable;
	private List<String> listNodeNames;
	private List<String> listMin;
	private List<String> listRoute;
	private List<List<String>> listlistUsedNodes;
	private List<List<INodeOutput>> listlistNodesOutput;
	
	
	private void drawNodeU() {
		INode nodeU = dijkstra.getNode(nameU);
		if (nodeU != null) {
			g2d.drawImage(getRouterImage(), x1, y1, null);	// U
			g2d.setColor(nodeU.getColor(surface));
			g2d.drawString(nameU, x1+difPicX-7, y1+difPicY+15);
		}
	}
	
	private void drawNodeV() {
		INode nodeV = dijkstra.getNode(nameV);
		if (nodeV != null) {
			g2d.drawImage(getRouterImage(), x3, y2, null);	// V
			g2d.setColor(nodeV.getColor(surface));
			g2d.drawString(nameV, x3+difPicX-7, y2+difPicY+15);
		}
	}
	
	private void drawNodeW() {
		INode nodeW = dijkstra.getNode(nameW);
		if (nodeW != null) {
			g2d.drawImage(getRouterImage(), x4, y2, null);	// W
			g2d.setColor(nodeW.getColor(surface));
			g2d.drawString(nameW, x4+difPicX-7, y2+difPicY+15);
		}
	}
	
	private void drawNodeX() {
		INode nodeX = dijkstra.getNode(nameX);
		if (nodeX != null) {
			g2d.drawImage(getRouterImage(), x3, y3, null);	// X
			g2d.setColor(nodeX.getColor(surface));
			g2d.drawString(nameX, x3+difPicX-7, y3+difPicY+15);
		}
	}
	
	private void drawNodeY() {
		INode nodeY = dijkstra.getNode(nameY);
		if (nodeY != null) {
			g2d.drawImage(getRouterImage(), x4, y3, null);	// Y
			g2d.setColor(nodeY.getColor(surface));
			g2d.drawString(nameY, x4+difPicX-7, y3+difPicY+15);
		}
	}
	
	private void drawNodeZ() {
		INode nodeZ = dijkstra.getNode(nameZ);
		if (nodeZ != null) {
			g2d.drawImage(getRouterImage(), x2, y1, null);	// Z	
			g2d.setColor(nodeZ.getColor(surface));
			g2d.drawString(nameZ, x2+difPicX-7, y1+difPicY+15);
		}
	}
	
	private void drawEdgeUV() {
		IEdge edgeUV = dijkstra.getEdge(nameU, nameV);
		if (edgeUV != null) {
			g2d.setColor(edgeUV.getColor(surface));
			g2d.drawLine(x1+difPicX, y1+difPicY, x3+difPicX, y2+difPicY);				// UV
			g2d.setFont(new Font(font.getFontName(), Font.BOLD, 20));
			g2d.drawString(edgeUV.getWeight().toString(), x1+difPicX+(difX/2)-6, y1+difPicY-(difY/2)-6);
		}
	}
	
	private void drawEdgeUW() {
		IEdge edgeUW = dijkstra.getEdge(nameU, nameW);
		if (edgeUW != null) {
			g2d.setColor(edgeUW.getColor(surface));
			g2d.draw(new CubicCurve2D.Double(x1+difPicX, y1+difPicY, x1+difPicX+20, y1+difPicY-170, x3+difPicX, y2+difPicY-80, x4+difPicX, y2+difPicY));	// UW
			g2d.setFont(new Font(font.getFontName(), Font.BOLD, 20));
			g2d.drawString(edgeUW.getWeight().toString(), x1+difPicX+(difX/2)-6, y1+difPicY-98);
		}
	}	
	
	private void drawEdgeUX() {
		IEdge edgeUX = dijkstra.getEdge(nameU, nameX);
		if (edgeUX != null) {
			g2d.setColor(edgeUX.getColor(surface));
			g2d.drawLine(x1+difPicX, y1+difPicY, x3+difPicX, y3+difPicY);				// UX
			g2d.setFont(new Font(font.getFontName(), Font.BOLD, 20));
			g2d.drawString(edgeUX.getWeight().toString(), x1+difPicX+(difX/2)-6, y1+difPicY+(difY/2)-6);
		}
	}
	
	private void drawEdgeVW() {
		IEdge edgeVW = dijkstra.getEdge(nameV, nameW);
		if (edgeVW != null) {
			g2d.setColor(edgeVW.getColor(surface));
			g2d.drawLine(x3+difPicX, y2+difPicY, x4+difPicX, y2+difPicY);				// VW
			g2d.setFont(new Font(font.getFontName(), Font.BOLD, 20));
			g2d.drawString(edgeVW.getWeight().toString(), x3+difPicX+((x4-x3)/2)-45, y2+difPicY-6);
		}
	}
	
	private void drawEdgeVX() {
		IEdge edgeVX = dijkstra.getEdge(nameV, nameX);
		if (edgeVX != null) {
			g2d.setColor(edgeVX.getColor(surface));
			g2d.drawLine(x3+difPicX, y2+difPicY, x3+difPicX, y3+difPicY);				// VX
			g2d.setFont(new Font(font.getFontName(), Font.BOLD, 20));
			g2d.drawString(edgeVX.getWeight().toString(), x3+difPicX+6, y1+difPicY+6);
		}
	}
	
	private void drawEdgeWX() {
		IEdge edgeWX = dijkstra.getEdge(nameW, nameX);
		if (edgeWX != null) {
			g2d.setColor(edgeWX.getColor(surface));
			g2d.drawLine(x3+difPicX, y3+difPicY, x4+difPicX, y2+difPicY);				// WX
			g2d.setFont(new Font(font.getFontName(), Font.BOLD, 20));
			g2d.drawString(edgeWX.getWeight().toString(), x3+difPicX+((x4-x3)/2)-45, y1+difPicY+6);
		}
	}
	
	private void drawEdgeWY() {
		IEdge edgeWY = dijkstra.getEdge(nameW, nameY);
		if (edgeWY != null) {
			g2d.setColor(edgeWY.getColor(surface));
			g2d.drawLine(x4+difPicX, y2+difPicY, x4+difPicX, y3+difPicY);				// WY
			g2d.setFont(new Font(font.getFontName(), Font.BOLD, 20));
			g2d.drawString(edgeWY.getWeight().toString(), x4+difPicX+6, y1+difPicY+6);
		}
	}
	
	private void drawEdgeWZ() {
		IEdge edgeWZ = dijkstra.getEdge(nameW, nameZ);
		if (edgeWZ != null) {
			g2d.setColor(edgeWZ.getColor(surface));
			g2d.drawLine(x4+difPicX, y2+difPicY, x2+difPicX, y1+difPicY);				// WZ
			g2d.setFont(new Font(font.getFontName(), Font.BOLD, 20));
			g2d.drawString(edgeWZ.getWeight().toString(), x2+difPicX-(difX/2)-6, y1+difPicY-(difY/2)-6);
		}
	}
	
	private void drawEdgeXY() {
		IEdge edgeXY = dijkstra.getEdge(nameX, nameY);
		if (edgeXY != null) {
			g2d.setColor(edgeXY.getColor(surface));
			g2d.drawLine(x3+difPicX, y3+difPicY, x4+difPicX, y3+difPicY);				// XY
			g2d.setFont(new Font(font.getFontName(), Font.BOLD, 20));
			g2d.drawString(edgeXY.getWeight().toString(), x3+difPicX+((x4-x3)/2)-45, y3+difPicY-6);
		}
	}
	
	private void drawEdgeYZ() {
		IEdge edgeYZ = dijkstra.getEdge(nameY, nameZ);
		if (edgeYZ != null) {
			g2d.setColor(edgeYZ.getColor(surface));
			g2d.drawLine(x4+difPicX, y3+difPicY, x2+difPicX, y1+difPicY);				// YZ
			g2d.setFont(new Font(font.getFontName(), Font.BOLD, 20));
			g2d.drawString(edgeYZ.getWeight().toString(), x2+difPicX-(difX/2)-6, y1+difPicY+(difY/2)-6);
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
		BasicStroke bs = new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
		g2d.setStroke(bs);
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
	
	private void drawBox(Integer line, String text, Integer x, Integer length) {
		if ((text != null) && (x != null) && (length != null) && (line != null)) {
			Integer x1 = x;
			Integer x2 = x1 + length;
			Integer y1 = tableY+(lineHeight*line);
			Integer y2 = y1+lineHeight;			
			g2d.drawLine(x1, y1, x2, y1);
			g2d.drawLine(x1, y2, x2, y2);
			g2d.drawLine(x1, y1, x1, y2);
			g2d.drawLine(x2, y1, x2, y2);			
			g2d.drawString(text, x1+10, y2-7);
		}
	}
	
	private void drawSteps() {
		Integer x = tableX;	
		Integer lines = dijkstra.getMaxTableLines();
		drawBox(0, "STEP", x, lengthStep);
		for (Integer i = 0; i < lines; i++) {
			drawBox(i+1, i.toString(), x, lengthStep);
		}
	}
	
	private void drawUsedNodes() {
		Integer x = tableX + lengthStep;
		drawBox(0, "    NODES", x, lengthNodes);
		for (Integer i = 0; i < linesTable; i++) {
			String chain = "";
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
			drawBox(i+1, chain, x, lengthNodes);
		}
	}	
	
	private void drawNodesOutput() {		
		Integer linesList = listlistNodesOutput.size();
		Integer sizeNames = listNodeNames.size();
		for (int i = 0; i < linesTable; i++) {
			List<INodeOutput> listNodesOutput;
			if (i < linesList) {
				listNodesOutput = listlistNodesOutput.get(i);
			} else {
				listNodesOutput = new ArrayList<INodeOutput>();
			}
			Integer sizeList = listNodesOutput.size();
			for (int j = 0; j < sizeNames; j++) {
				Integer x = tableX + lengthStep + lengthNodes + (lengthNodeOutput * j);
				if (i == 0) {
					String name = listNodeNames.get(j);
					drawBox(0, name, x, lengthNodeOutput);
				}
				String output = "";
				if (j < sizeList) {
					INodeOutput nodeOutput = listNodesOutput.get(j);
					EnumPreviousType type = nodeOutput.getPreviousNodeType();
					switch (type) {
						case NORMAL: {
							output = nodeOutput.getWeightToAccess() + ", " + nodeOutput.getPreviousNodeName();
							break;
						}
						case INFINITY: {
							output = Character.toString('\u221E');
							break;
						}
						case MINUS: {
							output = "-";
							break;
						}
						default: {
							break;
						}
					}
				}
				drawBox(i+1, output, x, lengthNodeOutput);
			}
		}				
	}
	
	private void drawMin() {
		Integer linesList = listMin.size();
		Integer sizeNodes = listNodeNames.size();
		Integer x = tableX + lengthStep + lengthNodes + (lengthNodeOutput * sizeNodes);
		drawBox(0, "MIN", x, lengthMin);
		for (int i = 0; i < linesTable; i++) {
			String min = "";
			if (i < linesList) {
				min = listMin.get(i);
			}
			drawBox(i+1, min, x, lengthMin);
		}
	}
	
	private void drawTable() {				
		BasicStroke bs3 = new BasicStroke(5, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
        g2d.setStroke(bs3);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font(font.getFontName(), Font.BOLD, 20));		
		drawSteps();
		drawUsedNodes();
		drawNodesOutput();
		drawMin();
	}
	
	private void drawRoute() {
		BasicStroke bs3 = new BasicStroke(5, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
        g2d.setStroke(bs3);
		g2d.setColor(Color.BLACK);
		Integer size = listRoute.size();
		String text = "";
		for (int i = 0; i < size; i++) {
			if (i == 0) {
				text = listRoute.get(i);
			} else {
				text = text + " <= " + listRoute.get(i);
			}
		}
		g2d.drawString(text, 20, 500);
	}
	
	
	/**
	 * Create the panel.
	 */
	public PanelRNDijkstraModel(IDijkstraAlgorithm idijkstra) {
		super();
		if (idijkstra == null) {
			idijkstra = new DijkstraAlgorithm();
		}
		dijkstra = idijkstra;
		updateModel();
	}

	@Override
	protected void doDrawing(Graphics g) {
		g2d = (Graphics2D) g;
		font = g2d.getFont();		
				
		g2d.setColor(Color.BLACK);
			
		drawEdges();	
		drawNodes();
		drawTable();
		drawRoute();
	}

	@Override
	public void updateData() {
		surface = dijkstra.getSurface();
		linesTable = dijkstra.getMaxTableLines();
		listlistNodesOutput = dijkstra.getListNodesOutput();
		listlistUsedNodes = dijkstra.getListUsedNodes();		
		listNodeNames = dijkstra.getListNodeNames();		
		listMin = dijkstra.getListMin();
		listRoute = dijkstra.getListRoute();
	}

	@Override
	public void updateModel() {
		updateData();
		repaint();		
	}
}
