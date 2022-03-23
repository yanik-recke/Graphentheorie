package de.ituvsoft.gui;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class DFrame extends JFrame {
	DCanvas canvas;
	DControlPanel panel;
	
	
	public DFrame(){
		//this.setPreferredSize(new Dimension());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Anwendung zur Graphentheorie");
		this.setLayout(new FlowLayout());
		
		canvas = new DCanvas();
		this.add(canvas);
		
		panel = new DControlPanel();
		this.add(panel);
				
		this.setVisible(true);
		this.pack();
	}
	
	
	public void callRepaint() {
		canvas.repaint();
	}
	
}
