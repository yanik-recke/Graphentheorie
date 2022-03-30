package de.ituvsoft.utils;

import java.util.ArrayList;

import de.ituvsoft.graph.DNode;
import de.ituvsoft.graph.DPosition;

public class NodeList extends ArrayList<DNode>{

	private static final long serialVersionUID = 1L;
	
	
	//TODO maybe write getter instead of setting to public
	public DPosition pos;
	
	public char letter;
	
	public NodeList(char letter, int pos){
		this.pos = new DPosition(pos);
		this.letter = letter;
	}

	
}
