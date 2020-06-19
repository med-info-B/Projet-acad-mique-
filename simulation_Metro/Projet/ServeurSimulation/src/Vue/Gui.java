package Vue;


import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;

import ControllerSimulation.Ordinateur;
import ModelSimulation.Coordinate;
import ModelSimulation.ObserverTrain;
import ModelSimulation.Trafic;
import ModelSimulation.Train;


public class Gui implements ObserverTrain {

	private List<Train> trains;
	private Trafic trafic;
	private Ordinateur ordinateur;
	
	private JFrame frame = new JFrame(" Simulation Train");
	public  static final int  SCAL = 80;
	public  static final int SIZE = 10; 
	
	private JComponent component = new JComponent() {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			trafic.draw_Trafic(g, SCAL, SIZE);
			if(!trains.isEmpty()) {
				for(Train t : trains) {
					t.draw_Train(g, SCAL);
				}
			}
			;
		}
			
		
	};

	

	
	public Gui(Ordinateur ordinateur) {
		
		frame.setContentPane(component);
		frame.setSize(800,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setBackground(Color.WHITE);
		this.ordinateur = ordinateur;
		trafic = ordinateur.getTrafic();
		trains = new ArrayList<Train>();
	}


	@Override
	public void notifyTrainEvent(List<Coordinate> positions) {
	
		this.component.repaint();

	}
	
	
	
	
	
	
	
	
	}