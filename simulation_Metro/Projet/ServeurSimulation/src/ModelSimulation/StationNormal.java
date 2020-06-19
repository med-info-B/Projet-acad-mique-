package ModelSimulation;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;


public class StationNormal extends Station {
	private static final int TIMEOUT = 50;
	private int timer;
	public StationNormal(Coordinate location, String name) {
		super(location, name);
		this.colorLabel = Color.BLACK;
		this.colorStation = Color.BLUE;
		this.dimension = new Dimension(1,1);
	}
	
	
	
	
	
	
	

	@Override
	public void entrer(Train train) {		  
     		train.changeStation(this); 
			train.stop(true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 *   Le dessin d'une station normal 
	 */
	@Override
	public void draw_element(Graphics g, int SCAL, int  SIZE) {
	    // Constance de postion
		final int X  = location.getX() * SCAL;
		final int Y  = location.getY() * SCAL;
		
		final int W = dimension.width  *  SIZE + 10;
		final int H = dimension.height * SIZE + 30;
	
		// Dessin d'une station
		g.setColor(colorStation);
		final int DECY = 5;
		g.fill3DRect(X , Y - DECY, W, H,true);
		
		// Le label d'une station
		g.setColor(colorLabel);
		Font fonte = new Font("TimesRoman ",Font.BOLD,10);
		g.setFont(fonte);
		final int DEC =  -30;
		g.drawString(name, X  , Y + DEC);
	}






















	
	  

}