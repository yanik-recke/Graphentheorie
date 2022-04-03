package de.yanik.graph;

public class DNode {
	char letter;
	
	//TODO maybe write getter instead of setting to public
	public DPosition pos;
	int num;
	
	public DNode(char letter, int num){
		this.letter = letter;
		this.pos = new DPosition(num);
		this.num = num;
	}
	
	
	public char getLetter() {
		return this.letter;
	}
	
	
	public int getNum() {
		return this.num;
	}
	
}
