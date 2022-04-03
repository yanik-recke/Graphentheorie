package de.yanik.graph;


/*
 * Jede Position hat feste Koordinaten auf dem Canvas.
 * Jede Node hat eine Position.
 */
public class DPosition {
	int x, y;
	
	public DPosition(int n) {
		switch(n) {
		case 0: 
			this.x = 50;
			this.y = 250;
			break;
		
		case 1:
			this.x = 150;
			this.y = 350;
			break;
			
		case 2:
			this.x = 300;
			this.y = 350;
			break;
			
		case 3:
			this.x = 400;
			this.y = 250;
			break;
			
		case 4: 
			this.x = 300;
			this.y = 150;
			break;
			
		case 5:
			this.x = 150;
			this.y = 150;
			break;
		}
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
}
