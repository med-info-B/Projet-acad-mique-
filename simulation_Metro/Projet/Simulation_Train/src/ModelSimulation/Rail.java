package ModelSimulation;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import Vue.Gui;


public  class Rail implements MapSite{
	// les deux cotés d'une station
	public static enum Sens { Qui1, Qui2};
	
	private Station station1;
	private Station station2;
	private Color color;
	private Sens sens;
	
	public Rail(Station s1, Station s2, Sens sens) {
		this.station1 = s1;
		this.station2 = s2;
		this.sens = sens;
	}
	
	
	
    @Override
    public void entrer(Train train) {
    	if(train.getcurrentStation().equals(station1)){
    		train.avance();
    		if(train.headTrain().getX() == (station2.getLocation().getX() * Gui.SCAL)) {
    			station2.entrer(train);
    		}
    	} else {
    		train.avance();
    		if(train.headTrain().getX() == (station1.getLocation().getX() * Gui.SCAL)) {
    			station1.entrer(train);

    		}
    	}
    			
    	
    }
	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
	 *  Method pour le dessin des rails sur les deux coté d'une staion
	 */
	@Override
	public void draw_element(Graphics g, int SCAL, int SIZE) {
		
		// Constance des postions
		int x1 = station1.getLocation().getX() ;
		int y1 = station1.getLocation().getY();
	
		int x2 = station2.getLocation().getX();
		int y2 = station2.getLocation().getY();
		int A1 = 0, B1 = 0, A2 = 0,B2 = 0;
		
		
		// le dessin sur le Qui 1
		if(sens.equals(Sens.Qui1)) {
			
			A1 = x1 * SCAL;
			B1 = y1 * SCAL ;
			
			A2 = x2 * SCAL + 20;
			B2 = y2 * SCAL;
			
			final int DEY1 = 20;
			final int DEY2 = 10;
			Graphics2D g3 = (Graphics2D)g;
			g3.setStroke(new BasicStroke(SIZE));
			g3.draw(new Line2D.Double(A1 , B1 -  DEY1, A2 ,  B2 - DEY1 ));
			g3.draw(new Line2D.Double(A1,  B1  - DEY2, A2,   B2 -   DEY2));
		// Le dessin sur le coté Qui 2
		}else {
			
			System.out.println("je suis les rail deux ");
			A1 = x1 * SCAL ;
			B1 = y1 * SCAL ;
			
			A2 = x2 * SCAL  + 20;
			B2 = y2 * SCAL ;
			
			final int DEY1 = 40;
			final int DEY2 = 50;
			Graphics2D g3 = (Graphics2D)g;
			g3.setStroke(new BasicStroke(SIZE));
			g3.draw(new Line2D.Double(A1,   B1 + DEY1, A2,  B2 + DEY1));
			g3.draw(new Line2D.Double(A1 ,  B1 + DEY2, A2 , B2 + DEY2 ));
			
		}
	}
}