package de.ituvsoft.gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.KeyboardFocusManager;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Timer;

import de.ituvsoft.graph.DGraph;
import de.ituvsoft.main.DController;
import de.ituvsoft.main.DKonstanten;
import de.ituvsoft.utils.DModes;

public class DCanvas extends Canvas implements MouseListener{
	private static final long serialVersionUID = 1L;

	private int currentSelection;
	
	DCanvas(){
		this.setPreferredSize(new Dimension(500, DKonstanten.CANVAS_WIDTH));
		this.setBackground(Color.gray);
		this.setVisible(true);
		this.setFocusable(true);
		this.requestFocus();
		this.addMouseListener(this);
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
			case 'A': //-10 =
				g.drawString("A", DGraph.arrAllNodes.get(0).pos.getX() - 10, DGraph.arrAllNodes.get(0).pos.getY());
				break;
				
			case 'B': //-10 +15
				g.drawString("B", DGraph.arrAllNodes.get(1).pos.getX() - 10, DGraph.arrAllNodes.get(1).pos.getY() + 15);
				break;
				
			case 'C': //+10 -15 
				g.drawString("C", DGraph.arrAllNodes.get(2).pos.getX() + 13, DGraph.arrAllNodes.get(2).pos.getY() + 15);
				break;
				
			case 'D': //-10 -2
				g.drawString("D",  DGraph.arrAllNodes.get(3).pos.getX() - 9, DGraph.arrAllNodes.get(3).pos.getY() - 2);
				break;
				
			case 'E': //-13 +5
				g.drawString("E", DGraph.arrAllNodes.get(4).pos.getX() - 13, DGraph.arrAllNodes.get(4).pos.getY() + 5);
				break;
				
			case 'F': //+10 +5
				g.drawString("F",  DGraph.arrAllNodes.get(5).pos.getX() - 10, DGraph.arrAllNodes.get(5).pos.getY() + 5);
				break;
				
		}
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	
	@Override
	public void mousePressed(MouseEvent e) {
		if(DController.mode == DModes.coordinate_selection)
		{
			System.out.println("changing coordinates");
			if(currentSelection < DGraph.arrAllNodes.size() - 1)
			{
				DGraph.arrAllNodes.get(currentSelection).pos.setX((int) MouseInfo.getPointerInfo().getLocation().getX() - 10);
				DGraph.arrAllNodes.get(currentSelection).pos.setY((int) MouseInfo.getPointerInfo().getLocation().getY() - 30);
				
				DControlPanel.arrNodes[currentSelection].pos.setX((int) MouseInfo.getPointerInfo().getLocation().getX() - 10);
				DControlPanel.arrNodes[currentSelection].pos.setY((int) MouseInfo.getPointerInfo().getLocation().getY() - 30);
				currentSelection++;
				repaint();
			}
			else
			{
				DGraph.arrAllNodes.get(currentSelection).pos.setX((int) MouseInfo.getPointerInfo().getLocation().getX() - 10);
				DGraph.arrAllNodes.get(currentSelection).pos.setY((int) MouseInfo.getPointerInfo().getLocation().getY() - 30);
				
				DControlPanel.arrNodes[currentSelection].pos.setX((int) MouseInfo.getPointerInfo().getLocation().getX() - 10);
				DControlPanel.arrNodes[currentSelection].pos.setY((int) MouseInfo.getPointerInfo().getLocation().getY() - 30);
				currentSelection = 0;
				repaint();
			}
		}
		
		System.out.println(MouseInfo.getPointerInfo().getLocation().getX());
		System.out.println((int) MouseInfo.getPointerInfo().getLocation().getX());
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
