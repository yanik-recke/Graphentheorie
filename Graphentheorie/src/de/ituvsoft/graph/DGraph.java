package de.ituvsoft.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.ituvsoft.utils.NodeList;

/*
 * A graph needs to contain at least one node
 */

public class DGraph {
	// TODO maybe make unstatic
	public static ArrayList<NodeList> arrAllNodes;

	
	// max -> Anzahl nodes
	public DGraph(int max) {
		
		arrAllNodes = new ArrayList<>();
		
		// so viele Listen hinzufügen 
		char c = 'A';
		for(int i = 0; i < max; i++)
		{
			arrAllNodes.add(new NodeList(c, i));
			c++;
		}
	}
	
	
	// TODO add distance for weighted graph
	public void createConnection(DNode a, DNode b) {
		if(!arrAllNodes.get(a.getNum()).contains(b))
			arrAllNodes.get(a.getNum()).add(b);
		
		if(!arrAllNodes.get(b.getNum()).contains(a))
			arrAllNodes.get(b.getNum()).add(a);
	}
	
	
	public boolean checkIfConnected(DNode a, DNode b) {
		if(arrAllNodes.get(a.getNum()).contains(b) && arrAllNodes.get(b.getNum()).contains(a))
			return true;
		
		return false;
	}
	
	
	public void resetGraph() {
		arrAllNodes.clear();
	}
}
