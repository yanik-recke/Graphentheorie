package de.ituvsoft.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * A graph needs to contain at least one node
 */

public class DGraph {
	public static Map<DNode, List<DNode>> nodes;
	public static ArrayList<DNode>[] arrAllNodes;

	
	public DGraph() {
		nodes = new HashMap<>();
	}
	
	
	public void addNode(DNode a) {
		nodes.putIfAbsent(a, new ArrayList<>());
	}
	
	
	// TODO add distance for weighted graph
	public void createConnection(DNode a, DNode b) {
		if(!nodes.get(a).contains(b))
			nodes.get(a).add(b);
		
		if(!nodes.get(b).contains(a))
			nodes.get(b).add(a);
	}
	
	
	public boolean checkIfConnected(DNode a, DNode b) {
		if(nodes.get(a).contains(b) && nodes.get(b).contains(a))
			return true;
		
		return false;
	}
	
	
	public Map<DNode, List<DNode>> getAdjList(){
		return this.nodes;
	}
	
	
	public void resetGraph() {
		nodes.clear();
	}
	
	
}
