package de.yanik.gui;

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

import de.yanik.graph.DGraph;
import de.yanik.main.DController;
import de.yanik.main.DKonstanten;
import de.yanik.utils.DGlobals;
import de.yanik.utils.DModes;

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
		if(DGlobals.arrAllNodes != null)
		{
			g.setColor(Color.white);
		    for(int i = 0; i < DGlobals.arrAllNodes.size(); i++)
		    {
		    	g.fillOval(DGlobals.arrAllNodes.get(i).pos.getX(), DGlobals.arrAllNodes.get(i).pos.getY(), DKonstanten.NODE_WIDTH, DKonstanten.NODE_HEIGHT);
		    	drawLetters(g, DGlobals.arrAllNodes.get(i).letter);
		    }
		    
		    for(int i = 0; i < DGlobals.arrAllNodes.size(); i++)
		    	for(int n = 0; n < DGlobals.arrAllNodes.get(i).size(); n++)
		    		g.drawLine(DGlobals.arrAllNodes.get(i).pos.getX() + DKonstanten.NODE_WIDTH / 2, DGlobals.arrAllNodes.get(i).pos.getY() + DKonstanten.NODE_HEIGHT / 2, DGlobals.arrAllNodes.get(i).get(n).pos.getX() + DKonstanten.NODE_WIDTH / 2 , DGlobals.arrAllNodes.get(i).get(n).pos.getY() + DKonstanten.NODE_WIDTH / 2);
		}
	}
	
	
	public void drawLetters(Graphics g, char letter) {
		switch(letter){
			case 'A': //-10 =
				g.drawString("A", DGlobals.arrAllNodes.get(0).pos.getX() - 10, DGlobals.arrAllNodes.get(0).pos.getY());
				break;
				
			case 'B': //-10 +15
				g.drawString("B", DGlobals.arrAllNodes.get(1).pos.getX() - 10, DGlobals.arrAllNodes.get(1).pos.getY() + 15);
				break;
				
			case 'C': //+10 -15 
				g.drawString("C", DGlobals.arrAllNodes.get(2).pos.getX() + 13, DGlobals.arrAllNodes.get(2).pos.getY() + 15);
				break;
				
			case 'D': //-10 -2
				g.drawString("D",  DGlobals.arrAllNodes.get(3).pos.getX() - 9, DGlobals.arrAllNodes.get(3).pos.getY() - 2);
				break;
				
			case 'E': //-13 +5
				g.drawString("E", DGlobals.arrAllNodes.get(4).pos.getX() - 13, DGlobals.arrAllNodes.get(4).pos.getY() + 5);
				break;
				
			case 'F': //+10 +5
				g.drawString("F",  DGlobals.arrAllNodes.get(5).pos.getX() - 10, DGlobals.arrAllNodes.get(5).pos.getY() + 5);
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
//			System.out.println("changing coordinates");
			if(currentSelection < DGlobals.arrAllNodes.size() - 1)
			{
				DGlobals.arrAllNodes.get(currentSelection).pos.setX((int) MouseInfo.getPointerInfo().getLocation().getX() - 10);
				DGlobals.arrAllNodes.get(currentSelection).pos.setY((int) MouseInfo.getPointerInfo().getLocation().getY() - 30);
				
				DGlobals.arrNodes[currentSelection].pos.setX((int) MouseInfo.getPointerInfo().getLocation().getX() - 10);
				DGlobals.arrNodes[currentSelection].pos.setY((int) MouseInfo.getPointerInfo().getLocation().getY() - 30);
				currentSelection++;
				repaint();
			}
			else
			{
				DGlobals.arrAllNodes.get(currentSelection).pos.setX((int) MouseInfo.getPointerInfo().getLocation().getX() - 10);
				DGlobals.arrAllNodes.get(currentSelection).pos.setY((int) MouseInfo.getPointerInfo().getLocation().getY() - 30);
				
				DGlobals.arrNodes[currentSelection].pos.setX((int) MouseInfo.getPointerInfo().getLocation().getX() - 10);
				DGlobals.arrNodes[currentSelection].pos.setY((int) MouseInfo.getPointerInfo().getLocation().getY() - 30);
				currentSelection = 0;
				repaint();
			}
		}
		
//		System.out.println(MouseInfo.getPointerInfo().getLocation().getX());
//		System.out.println((int) MouseInfo.getPointerInfo().getLocation().getX());
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
