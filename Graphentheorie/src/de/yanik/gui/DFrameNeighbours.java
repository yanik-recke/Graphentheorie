package de.yanik.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import de.yanik.graph.DGraph;
import de.yanik.graph.DNode;


/* 
 * Ein Code Snippet mit folgendem Sinn:
 * Wenn man in die Box A z.B. ein B eintr?gt, dann soll in die Box
 * B auch ein A eingetragen werden.
 * Sehr viel Error und User-Input Handling.
 * 
 * Zur Implementierung in "Anwendung zur Graphentheorie" vorgesehen
 * 
 * 
 * ACHTUNG: Andere Version als im Snippet
 */
public class DFrameNeighbours extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private char maxC;
	private int max;
	private DGraph graph;
	
	private DNode[] arrNodes;
	private JTextField[] textFields;
	private JLabel[] textLabels;
	private JButton finish;
	private JButton close;
	

	public DFrameNeighbours(int max, DGraph graph, DNode[] arrNodes) {
		this.max = max;
		this.graph = graph;
		this.arrNodes = arrNodes;
		
		switch(max) {
		case 1: maxC = 'A';
		break;
		
		case 2: maxC = 'B';
		break;
		
		case 3: maxC = 'C';
		break;
		
		case 4: maxC = 'D';
		break;
		
		case 5: maxC = 'E';
		break;
		
		case 6: maxC = 'F';
		break;
		}
		
		this.setLayout(new FlowLayout());
		this.setTitle("Enter neighbours");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setFocusable(false);
		
		if(max <= 2)
			this.setPreferredSize(new Dimension(max * 120, 140));
		else
			this.setPreferredSize(new Dimension(max * 110, 140));
		
		// TODO change so it does not leave ~60 slots empty
		textFields = new JTextField[maxC + 1];
		
		textLabels = new JLabel[max];
		
		// TODO obergrenze variabel machen
		char ch = 'A';
		for(int i = 0; i < max; i++)
		{
			textLabels[i] = new JLabel("Neighbours of " + ch);
			textLabels[i].setPreferredSize(new Dimension(100, 20));
			textLabels[i].setFocusable(false);
			this.add(textLabels[i]);
			ch++;
		}
		
		// TODO Obergrenze variable machen
		for(char c = 'A'; c <= maxC; c++)
		{
			textFields[c] = textFieldCreator(c);
			this.add(textFields[c]);
		}
		
		finish = new JButton("Done");
		finish.setPreferredSize(new Dimension(100, 35));
		finish.setVisible(true);
		finish.addActionListener(this);
		finish.setFocusable(false);
		this.add(finish);
		
		close = new JButton("Close");
		close.setPreferredSize(new Dimension(100,35));
		close.setVisible(true);
		close.addActionListener(this);
		close.setFocusable(false);
		this.add(close);
		
		this.pack();
		this.setVisible(true);
	}
	
	
	private boolean onEnter(char tbChar)
	{
		if(checkInput(textFields[tbChar].getText(), max, tbChar))
		{
			completeOtherFields(textFields[tbChar].getText(), tbChar);
			return true;
		}
		
		return false;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean inputCorrect = true;
		
		if(max >= 1 && e.getSource() == textFields['A']) 
			if(!onEnter('A'))
				inputCorrect = false;
			
			
		if(max >= 2 && e.getSource() == textFields['B']) 
			if(!onEnter('B'))
				inputCorrect = false;
			
			
		if(max >= 3 && e.getSource() == textFields['C']) 
			if(!onEnter('C'))
				inputCorrect = false;
			
			
		if(max >= 4 && e.getSource() == textFields['D']) 
			if(!onEnter('D'))
				inputCorrect = false;
		
		
		if(max >= 5 && e.getSource() == textFields['E']) 
			if(!onEnter('E'))
				inputCorrect = false;
		
		
		if(max >= 6 && e.getSource() == textFields['F']) 
			if(!onEnter('F'))
				inputCorrect = false;
		
		
		if(e.getSource() == finish) {
			for(char c = 'A'; c <= maxC; c++)
				if(!onEnter(c))
					inputCorrect = false;
			
			if(inputCorrect)
				fillGraph();
			else
				System.out.println("Konnte nicht beenden, Fehler in einer der Textboxen");
		}
			
		if(e.getSource() == close)
			this.dispose();
		
			

		// Am Ende pr?fen, au?erhalb, da sonst Dopplug
		if(!inputCorrect)
		{
			System.out.println("Input bitte ?berpr?fen. M?gliche Fehlerquellen:");
			System.out.println(" - Es gibt gar nicht so viele Ecken/Knoten");
			System.out.println(" - Irgendwo sind Leerzeichen");
			System.out.println(" - Ein Buchstabe gr??er als " + maxC + " wurde eingegeben");
		}
		
	}
	
	
	/*
	 * Das Format des Inputs pr?fen
	 */
	public boolean checkInput(String input, int nodesNum, char tbChar) {
		input = input.replaceAll(",", "");
		
		
		// L?nge, Inhalt und auf whitespaces pr?fen
		 
		if((input.length() >= nodesNum) || (input.contains(Character.toString(tbChar)) || (input.contains(" "))))
			return false;
		
		
		// Falls ein Buchstabe gr??er als 'F' eingegeben wurde
		// TODO verallgemeinern falls mehr als 6 Knoten m?glich gemacht werden sollen
		for(int i = 0; i < input.length(); i++)
			if(input.charAt(i) > maxC)
				return false;
		
		return true;
	}
	
	
	/*
	 * Die anderen Felder ausf?llen, wenn z.B. A als Nachbarn
	 * B hat, dann hat B als Nachbarn auch A und somit muss in
	 * der Textbox von B auch A stehen
	 */
	public void completeOtherFields(String input, char tbNum) {
		input = input.replaceAll(",", "");
		
		// TODO replace F with highest NODE letter -> Obergrenze variabel machen
		for(char c = 'A'; c <= maxC; c++)
		{
			if((c != tbNum) && (input.contains(Character.toString(c))))
				if(!textFields[c].getText().contains(Character.toString(tbNum)))
					if(textFields[c].getText().equals(""))
						textFields[c].setText(tbNum + "");
					else
						textFields[c].setText(textFields[c].getText() +  "," + tbNum);	
				else
					;	// wenn Buchstabe schon vorhanden ist
		}
		
	}
	
	
	public void fillGraph() {
		char c = 'A';
		
		for(int i = 0; i < max; i++) {
			for(int n = 0; n < textFields[c].getText().length(); n++)
			{
				switch(textFields[c].getText().charAt(n)) {
					case 'A': 
						graph.createConnection(arrNodes[i], arrNodes[0]);
						break;
						
					case 'B': 
						graph.createConnection(arrNodes[i], arrNodes[1]);
						break;
						
					case 'C': 
						graph.createConnection(arrNodes[i], arrNodes[2]);
						break;
						
					case 'D': 
						graph.createConnection(arrNodes[i], arrNodes[3]);
						break;
						
					case 'E': 
						graph.createConnection(arrNodes[i], arrNodes[4]);
						break;
						
					case 'F': 
						graph.createConnection(arrNodes[i], arrNodes[5]);
						break;
				}
			}
			c++;
		}
	}
	
	
	/*
	 * Textboxen erstellen
	 */
	public JTextField textFieldCreator(char letter) {
		JTextField tf;
		tf = new JTextField();
		tf.setPreferredSize(new Dimension(100,30));
		tf.addActionListener(this);
		
		return tf;
	}

	
	
}
