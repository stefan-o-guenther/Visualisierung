package Rechnernetze.Dijkstra_Algorithmus;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

import Base.EnumSurface;
import Base.PanelDrawingAbstract;

public class PanelRNDijkstraAlgorithmTableImpl extends PanelDrawingAbstract {

	private static final long serialVersionUID = 1L;

	public PanelRNDijkstraAlgorithmTableImpl() {
		super();
		this.createPanel();
	}
	
	private Integer tableX = 20;
	private Integer tableY = 20;
	private Integer lengthStep = 80;
	private Integer lengthNodes = 150;
	private Integer lengthNodeOutput = 60;
	private Integer lengthMin = 70;
	private Integer lineHeight = 30;
	
	private ManagementDijkstraAlgorithm dijkstra;
	private Font font;

	@Override
	protected void createDrawing() {
		this.dijkstra = ManagementDijkstraAlgorithmImpl.getInstance();		
	}

	@Override
	protected void doDrawing() {
		font = g2d.getFont();		
		g2d.setColor(Color.BLACK);
		drawTable();
	}
	
	private void drawTable() {				
		drawSteps();
		drawUsedNodes();
		drawNodesOutput();
		drawMin();
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
		List<String> listNodeUsedNames = dijkstra.getListNodeUsedNames();
		for (int i = 0; i < linesTable; i++) {
			String chain = "";			
			if (i < listNodeUsedNames.size()) {
				for (int j = 0; j <= i; j++) {
					String node = listNodeUsedNames.get(j);
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
		List<String> listNodeTargetNames = dijkstra.getListNodeTargetNames();
		int sizeNodeTargetNamesTest = listNodeNames.size() - 1;
		int sizeNodeTargetNamesReal = listNodeTargetNames.size();		 
		int sizeLinesTable = dijkstra.getMaxTableLines();
		for (int i = 0; i < sizeNodeTargetNamesTest; i++) {
			Integer x = tableX + lengthStep + lengthNodes + (lengthNodeOutput * i);
			String name;
			List<NodeOutput> listNodeOutput;
			if (i < sizeNodeTargetNamesReal) {
				name = listNodeTargetNames.get(i);			
			} else {
				name = "";
			}
			listNodeOutput = dijkstra.getListNodeOutput(name);
			drawBox(0, name, x, lengthNodeOutput, Color.BLACK);	
			int sizeLinesList = listNodeOutput.size();
			for (int j = 0; j < sizeLinesTable; j++) {
				if (j < sizeLinesList) {					
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
		Integer sizeNodes = listNodeNames.size() - 1;
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

	@Override
	public Integer getPanelHeight() {
		return 100;
	}

	@Override
	public Integer getPanelWidth() {
		return 100;
	}
}
