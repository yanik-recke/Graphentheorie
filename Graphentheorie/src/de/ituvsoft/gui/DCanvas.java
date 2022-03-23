package de.ituvsoft.gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

import de.ituvsoft.graph.DGraph;
import de.ituvsoft.graph.DNode;
import de.ituvsoft.main.DKonstanten;

public class DCanvas extends Canvas {
	//private Map<DNode, List<DNode>> nodes;
	private List<DNode> tempList;
	
	DCanvas(){
		this.setPreferredSize(new Dimension(500, DKonstanten.CANVAS_WIDTH));
		this.setBackground(Color.gray);
		this.setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		drawGraph(g);
	}
	
	public void drawGraph(Graphics g) {
		if(DGraph.nodes != null)
		{
			int counter = 65;
			
			g.setColor(Color.white);
		    for (DNode key : DGraph.nodes.keySet()){
		        g.fillOval(key.pos.getX(), key.pos.getY(), DKonstanten.NODE_WIDTH, DKonstanten.NODE_HEIGHT);
		        drawLetters(g, key.getLetter());
		    }
		    
		    
		    for(DNode key : DGraph.nodes.keySet()) {
		    	tempList = DGraph.nodes.get(key);
		    	for(int n = 0; n < tempList.size(); n++) {
		    		g.drawLine(key.pos.getX() + DKonstanten.NODE_WIDTH / 2, key.pos.getY() + DKonstanten.NODE_HEIGHT / 2, tempList.get(n).pos.getX() + DKonstanten.NODE_WIDTH / 2, tempList.get(n).pos.getY() + DKonstanten.NODE_HEIGHT / 2);
		    	}
		    }
		}
	}
	
	
	
	public void drawLetters(Graphics g, char letter) {
		switch(letter){
			case 'A':
				g.drawString("A", 40, 250);
				break;
				
			case 'B':
				g.drawString("B", 140, 365);
				break;
				
			case 'C':
				g.drawString("C", 290, 365);
				break;
				
			case 'D':
				g.drawString("D", 410, 248);
				break;
				
			case 'E':
				g.drawString("E", 313, 155);
				break;
				
			case 'F':
				g.drawString("F", 140, 155);
				break;
				
		}
	}

}
