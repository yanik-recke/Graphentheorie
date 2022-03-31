package de.ituvsoft.gui;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import de.ituvsoft.utils.DModes;

public class DFrame extends JFrame {
	DCanvas canvas;
	public DControlPanel panel;
	
	
	public DFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setFocusable(true);
		this.requestFocus();
		
		canvas = new DCanvas();
		this.add(canvas);
		
		panel = new DControlPanel();
		this.add(panel);
				
		this.setVisible(true);
		this.pack();
		canvas.requestFocus();
	}
	
	
	public void callRepaint() {
		canvas.repaint();
	}
	
	
}
