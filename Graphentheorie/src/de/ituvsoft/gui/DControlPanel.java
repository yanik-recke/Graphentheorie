package de.ituvsoft.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import de.ituvsoft.graph.*;
import de.ituvsoft.main.DController;


public class DControlPanel extends JPanel implements ActionListener{
	private JButton bDrawGraph, bLoadNewGraph, bEnterNewGraph;
	private DGraph graph;
	//DNode arrNodes[];
	
	DControlPanel(){
		
		this.setPreferredSize(new Dimension(150, 500));
		this.setBackground(Color.gray);
		
		bEnterNewGraph = new JButton("Enter by hand");
		bEnterNewGraph.setPreferredSize(new Dimension(125,50));
		bEnterNewGraph.addActionListener(this);
		this.add(bEnterNewGraph);
		
		bLoadNewGraph = new JButton("Load new");
		bLoadNewGraph.setPreferredSize(new Dimension(125, 50));
		bLoadNewGraph.addActionListener(this);
		this.add(bLoadNewGraph);
		
		bDrawGraph = new JButton("Draw");
		bDrawGraph.setPreferredSize(new Dimension(125,50));
		bDrawGraph.addActionListener(this);
		this.add(bDrawGraph);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bEnterNewGraph) {
			enterGraphManually();
		}
		
		if(e.getSource() == bDrawGraph) {
			DController.callRepaint();
		}
		
	}
	
	
	public void enterGraphManually() {
		graph = new DGraph();
		
		try {
			boolean done = false;
			String sNodes = JOptionPane.showInputDialog("How many nodes do you want to add?");
			int nodes = Integer.parseInt(sNodes);
			int name = 65;
			//int nodeCounter = 0;
			DNode[] arrNodes = new DNode[nodes];		// Node A an 0ter Stelle, Node B an 1ter Stelle, usw.
		
		
			for(int i = 0; i < nodes; i++)
			{
				arrNodes[i] = new DNode((char) name, i);
				graph.addNode(arrNodes[i]);
				name++;
			}
		
			name = 65;
			for(int i = 0; i < nodes; i++)
			{
				String sNeighboursNum = JOptionPane.showInputDialog("How many neighbours does " + (char) name + " have? Up to " + (nodes - 1) + " is allowed.");
				int neighboursNum= Integer.parseInt(sNeighboursNum);
				for(int n = 0; n < neighboursNum; n++)
			{
				while(!done) 
				{
					String sNeighbour = JOptionPane.showInputDialog("[A, B, C,..] Enter " + (n + 1)  + ". neighbour");
		
					switch(sNeighbour.charAt(0)) {
						case 'A' : 
							if(i != 0)
							{
								done = true;
								graph.createConnection(arrNodes[i], arrNodes[0]);
							}
							break;
					
						case 'B' : 
							if(i != 1)
							{
								done = true;
								graph.createConnection(arrNodes[i], arrNodes[1]);
							}
							break;
						
						case 'C' : 
							if(i != 2)
							{
								done = true;
								graph.createConnection(arrNodes[i], arrNodes[2]);
							}
							break;
						
						case 'D' : 
							if(i != 3)
							{
								done = true;
								graph.createConnection(arrNodes[i], arrNodes[3]);
							}
							break;
						
						case 'E' : 
							if(i != 4)
							{
								done = true;
								graph.createConnection(arrNodes[i], arrNodes[4]);
							}
							break;
						
						case 'F' : 
							if(i != 5)
							{
								done = true;
								graph.createConnection(arrNodes[i], arrNodes[5]);
							}
							break;
						}
					
						if(!done)
							System.out.println("false input. retry.");
					}
					done = false;
				}
				name++;
			}
		} 
		catch (Exception ex)
		{
			graph.resetGraph();
			ex.printStackTrace();
			System.out.println("Something went wrong. Graph was cleared. Try again.");
		}
	}
}

