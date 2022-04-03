package de.yanik.main;

import java.awt.KeyboardFocusManager;

import de.yanik.gui.DFrame;
import de.yanik.utils.DModes;

public class DController {
	static DFrame frame;
	public static DModes mode;
	
	
	public static void main(String[] args) {
		frame = new DFrame();
		changeMode(0);
	}
	
	
	public static void callRepaint() {
		frame.callRepaint();
	}
	
	
	public static void changeMode(int modeNum) {
		if(modeNum == 0)
		{
			frame.setTitle("Anwendung zur Graphentheorie - MODUS: Normal");
			//frame.panel.setVisible(true);
			DController.mode = DModes.normal;
		}
		
		if(modeNum == 1)
		{
			frame.setTitle("Anwendung zur Graphentheorie - MODUS: Point & Click to set coordinates");
			//frame.panel.setVisible(false);
			DController.mode = DModes.coordinate_selection;
		}
			
	}
}
