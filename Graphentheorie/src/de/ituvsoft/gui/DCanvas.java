package de.ituvsoft.gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import de.ituvsoft.graph.DGraph;
import de.ituvsoft.graph.DNode;
import de.ituvsoft.main.DKonstanten;
import de.ituvsoft.utils.DModes;

public class DCanvas extends Canvas implements MouseListener{
	private static final long serialVersionUID = 1L;

	private int currentSelection;
	
	DCanvas(){
		this.setPreferredSize(new Dimension(500, DKonstanten.CANVAS_WIDTH));
		this.setBackground(Color.gray);
		this.setVisible(true);
		
		this.currentSelection = 0;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		drawGraph(g);
	}
	
	
	public void drawGraph(Graphics g) {
		if(DGraph.arrAllNodes != null)
		{
			g.setColor(Color.white);
		    for(int i = 0; i < DGraph.arrAllNodes.size(); i++)
		    {
		    	g.fillOval(DGraph.arrAllNodes.get(i).pos.getX(), DGraph.arrAllNodes.get(i).pos.getY(), DKonstanten.NODE_WIDTH, DKonstanten.NODE_HEIGHT);
		    	drawLetters(g, DGraph.arrAllNodes.get(i).letter);
		    }
		    
		    for(int i = 0; i < DGraph.arrAllNodes.size(); i++)
		    	for(int n = 0; n < DGraph.arrAllNodes.get(i).size(); n++)
		    		g.drawLine(DGraph.arrAllNodes.get(i).pos.getX() + DKonstanten.NODE_WIDTH / 2, DGraph.arrAllNodes.get(i).pos.getY() + DKonstanten.NODE_HEIGHT / 2, DGraph.arrAllNodes.get(i).get(n).pos.getX() + DKonstanten.NODE_WIDTH / 2 , DGraph.arrAllNodes.get(i).get(n).pos.getY() + DKonstanten.NODE_WIDTH / 2);
		}
	}
	
	
	// TODO verallgemeinern
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

	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void mousePressed(MouseEvent e) {
		if(DFrame.mode == DModes.coordinate_selection)
		{
			if(currentSelection <= DGraph.arrAllNodes.size())
			{
				//TODO koordinaten setzen
				
			}
			else
			{
				currentSelection = 0;
			}
		}
		
	}

	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
