package de.ituvsoft.graph;

public class DNode {
	char letter;
	public DPosition pos;
	
	public DNode(char letter, int pos){
		this.letter = letter;
		this.pos = new DPosition(pos);
	}
	
	public char getLetter() {
		return this.letter;
	}
	
}
