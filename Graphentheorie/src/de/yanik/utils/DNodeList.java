package de.yanik.utils;

import java.util.ArrayList;

import de.yanik.graph.DNode;
import de.yanik.graph.DPosition;

public class DNodeList extends ArrayList<DNode>{

	private static final long serialVersionUID = 1L;
	
	
	//TODO maybe write getter instead of setting to public
	public DPosition pos;
	
	public char letter;
	
	public DNodeList(char letter, int pos){
		this.pos = new DPosition(pos);
		this.letter = letter;
	}

	
}
