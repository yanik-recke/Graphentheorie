package de.yanik.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import de.yanik.graph.DGraph;
import de.yanik.graph.DNode;
import de.yanik.main.DController;
import de.yanik.utils.DGlobals;


public class DControlPanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	public JButton bChangeMode, bDrawGraph, bLoadNewGraph, bEnterNewGraph;
	private DGraph graph;
	
	public static volatile boolean waiting;
	
	
	DControlPanel(){
		
		this.setPreferredSize(new Dimension(150, 500));
		this.setBackground(Color.gray);
		this.setFocusable(false);
		
		//TODO auslagern
		bChangeMode = new JButton("Change to Point & Click mode");
		bChangeMode.setPreferredSize(new Dimension(125, 50));
		bChangeMode.addActionListener(this);
		bChangeMode.setFocusable(false);
		this.add(bChangeMode);
		
		bEnterNewGraph = new JButton("Enter by hand");
		bEnterNewGraph.setPreferredSize(new Dimension(125,50));
		bEnterNewGraph.addActionListener(this);
		bEnterNewGraph.setFocusable(false);
		this.add(bEnterNewGraph);
		
		bLoadNewGraph = new JButton("Load new");
		bLoadNewGraph.setPreferredSize(new Dimension(125, 50));
		bLoadNewGraph.addActionListener(this);
		bLoadNewGraph.setFocusable(false);
		this.add(bLoadNewGraph);
		
		bDrawGraph = new JButton("Draw");
		bDrawGraph.setPreferredSize(new Dimension(125,50));
		bDrawGraph.addActionListener(this);
		bDrawGraph.setFocusable(false);
		this.add(bDrawGraph);
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bEnterNewGraph) {
			enterGraphManually();
		}
		
		if(e.getSource() == bLoadNewGraph) {
			//System.out.println(KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner());
			
			String path = JOptionPane.showInputDialog("Enter the path to the file (C:/.../.../[name].txt");
			List<String> lines = readLinesToList(path);
			if(checkListFormat(lines)) 
			{
				//TODO go ahead
				System.out.println("Input is valid. Graph created. To draw press 'Draw'.");
			}
			else
				System.out.println("Input is invalid. Please repeat.");
		}
		
		if(e.getSource() == bDrawGraph) {
			DController.callRepaint();
		}
		
		if(e.getSource() == bChangeMode)
			if((graph != null) && bChangeMode.getText().contains("Normal"))
			{
				DController.changeMode(0);
				bChangeMode.setText("Change to Point & Click mode");
			}
			else if(graph != null)
			{
				DController.changeMode(1);
				bChangeMode.setText("Change to Normal mode");
			}
			else
				System.out.println("You have to first enter at least one node");
	}
	
	
	public void enterGraphManually() {
		if(graph != null)
			graph.resetGraph();
		
		try {
			String sNodes = JOptionPane.showInputDialog("How many nodes do you want to add?");
			int nodes = Integer.parseInt(sNodes);
			
			graph = new DGraph(nodes);

			//int nodeCounter = 0;
			DGlobals.arrNodes = new DNode[nodes];		// Node A an 0ter Stelle, Node B an 1ter Stelle, usw.
			
			// Array mit Nodes befüllen
			char c = 'A';
			for(int i = 0; i < nodes; i++)
			{
				DGlobals.arrNodes[i] = new DNode(c, i);
				DGlobals.arrNodes[i].pos.setX(DGlobals.arrAllNodes.get(i).pos.getX());
				DGlobals.arrNodes[i].pos.setY(DGlobals.arrAllNodes.get(i).pos.getY());
				c++;
			}
				
			if(nodes == 1)
				System.out.println("No adjacents for one node");
			else
				new DFrameNeighbours(nodes, graph, DGlobals.arrNodes);

		} 
		catch (Exception ex)
		{
			if(graph != null)
				graph.resetGraph();
			
			ex.printStackTrace();
			System.out.println("Something went wrong. Graph was cleared. Try again.");
		}
	}
	
	// Read all the lines from the text file into a list
	private static List<String> readLinesToList(String path) {
		File file = new File(path);
		Scanner sc;
		List<String> listA = new ArrayList<>();

		try 
		{
		    String temp = "";
			sc = new Scanner(file);

			while (sc.hasNextLine()) 
			{
				temp = sc.nextLine();
				if (temp != "")
					listA.add(temp);
			}
		}

		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("Please repeat, there was probably an error in your file path");
		}

		return listA;
	}
	
	
	/*
	 * Check the format of the List / adjacenc matrix
	 */
	private static boolean checkListFormat(List<String> lines) {
		int n = lines.size() - 1;
		int i = 0;
		String temp = "";
		List<Integer> numbers = new ArrayList<Integer>();

		for (int j = 0; j <= 9; j++)
			numbers.add(j);

		// i für infinity
		numbers.add(18);

		// Länge des ersten Elements zu Vergleichszwecken
		int length = lines.get(i).length();

		// Es muss eine x mal x matrix sein (würfel)
		if (length != lines.size())
			return false;
		
		// Nicht mehr als 6 nodes
		if(length > 6)
			return false;

		while (i <= n) 
		{
			if (lines.get(i).length() == length) 
			{
				temp = lines.get(i);
				for (int j = 1; j < temp.length(); j++) 
				{
					// Prüfung auf nur Zahlen && i && jede Zahl muss zu sich selbst Weg 0 haben
					if ((!(numbers.contains(Character.getNumericValue(temp.charAt(j))))) || ((j == i) && (temp.charAt(j) != '0')))
						return false;
				}
			} else
				return false;

			i++;
		}
		
		i = 0;
				
		return true;
	}
	
	
	private static void createGraphFromList() {
		// TODO create graph from list
	}
}

