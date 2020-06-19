package ModelSimulation;

import java.awt.Color;
import java.awt.Dimension;


public abstract class StationTerminus extends Station {

	public StationTerminus(Coordinate location, String name) {
		super(location, name);
		this.colorLabel = Color.DARK_GRAY;
		this.colorStation = Color.ORANGE;
		this.dimension = new Dimension(5,10);
	}

	
	 
	
	
	


}