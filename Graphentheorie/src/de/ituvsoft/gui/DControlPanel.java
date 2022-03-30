package de.ituvsoft.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import de.ituvsoft.graph.DGraph;
import de.ituvsoft.graph.DNode;
import de.ituvsoft.main.DController;


public class DControlPanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private JButton bDrawGraph, bLoadNewGraph, bEnterNewGraph;
	private DGraph graph;
	private DNode[] arrNodes;
	
	public static volatile boolean waiting;
	
	
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
		
		if(e.getSource() == bLoadNewGraph) {
			//TODO load file
			System.out.println(graph.checkIfConnected(arrNodes[2], arrNodes[0]));
			System.out.println(graph.checkIfConnected(arrNodes[0], arrNodes[2]));
		}
		
		if(e.getSource() == bDrawGraph) {
			DController.callRepaint();
		}
		
	}
	
	
	public void enterGraphManually() {
		if(graph != null)
			graph.resetGraph();
		
		try {
			String sNodes = JOptionPane.showInputDialog("How many nodes do you want to add?");
			int nodes = Integer.parseInt(sNodes);
			
			graph = new DGraph(nodes);

			//int nodeCounter = 0;
			arrNodes = new DNode[nodes];		// Node A an 0ter Stelle, Node B an 1ter Stelle, usw.
			
			// Array mit Nodes befüllen
			char c = 'A';
			for(int i = 0; i < nodes; i++)
			{
				arrNodes[i] = new DNode(c, i);
				c++;
			}
				
			if(nodes == 1)
				System.out.println("No adjacents for one node");
			else
				new DFrameNeighbours(nodes, graph, arrNodes);

		} 
		catch (Exception ex)
		{
			graph.resetGraph();
			ex.printStackTrace();
			System.out.println("Something went wrong. Graph was cleared. Try again.");
		}
	}
}

