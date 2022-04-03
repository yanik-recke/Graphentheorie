package de.yanik.graph;

import java.util.ArrayList;

import de.yanik.utils.DGlobals;
import de.yanik.utils.DNodeList;

/*
 * A graph needs to contain at least one node
 */

public class DGraph {

	
	// max -> Anzahl nodes
	public DGraph(int max) {
		
		DGlobals.arrAllNodes = new ArrayList<>();
		
		// so viele Listen hinzufügen 
		char c = 'A';
		for(int i = 0; i < max; i++)
		{
			DGlobals.arrAllNodes.add(new DNodeList(c, i));
			c++;
		}
	}
	
	
	// TODO add distance for weighted graph
	public void createConnection(DNode a, DNode b) {
		if(!DGlobals.arrAllNodes.get(a.getNum()).contains(b))
			DGlobals.arrAllNodes.get(a.getNum()).add(b);
		
		if(!DGlobals.arrAllNodes.get(b.getNum()).contains(a))
			DGlobals.arrAllNodes.get(b.getNum()).add(a);
	}
	
	
	public boolean checkIfConnected(DNode a, DNode b) {
		if(DGlobals.arrAllNodes.get(a.getNum()).contains(b) && DGlobals.arrAllNodes.get(b.getNum()).contains(a))
			return true;
		
		return false;
	}
	
	
	public void resetGraph() {
		DGlobals.arrAllNodes.clear();
	}
}
