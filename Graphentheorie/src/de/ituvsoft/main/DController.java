package de.ituvsoft.main;

import de.ituvsoft.gui.DFrame;

public class DController {
	static DFrame frame;
	
	
	public static void main(String[] args) {
		frame = new DFrame();
	}
	
	public static void callRepaint() {
		frame.callRepaint();
	}
}
