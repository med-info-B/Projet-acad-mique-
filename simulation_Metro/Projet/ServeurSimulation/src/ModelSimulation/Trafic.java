package ModelSimulation;


import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import ModelSimulation.Rail.Sens;
import Vue.Gui;


public class Trafic {

	private List<Station> stations;
	private List<Train> trains;
	public Trafic() {
		stations = new ArrayList<Station>();
		trains = new ArrayList<Train>();
		
	}
	
	
	public void setTrain(Train train) {
		trains.add(train);
	}
	
	
	public Station findStationByName(String name) {
		for(Station s : stations) {
			if(s.getNameStation().contains(name))
				return s;
		}
		return null;
	}
	
	public Trafic creatTrafic() {
		
		Station s1 = new TerminusZone(new Coordinate     (1,2),       "Bercy");
		Station s2 = new StationNormal(new   Coordinate  (3,2),       "Cour-Saint-Emillion");
		Station s3 = new StationNormal(new   Coordinate  (5,2),       "Bib Metherand");	
		Station s4 = new StationNormal(new   Coordinate  (7,2),       "Olympiad");
		Station s5 = new TerminusLine(new   Coordinate   (10,2),       " Gard du Nord");
		
		
		
		
		
		Rail rail1  = new Rail( s1 , s2, Sens.Qui1 );
		Rail rail2  = new Rail( s2 , s3, Sens.Qui1 );
		Rail rail3  = new Rail( s3 , s4, Sens.Qui1 );
		Rail rail4  = new Rail( s4 , s5, Sens.Qui1 );
		
		
		Rail  qui2a = new Rail( s1,  s2, Sens.Qui2 );
		Rail  qui2b = new Rail( s2 , s3, Sens.Qui2 );
		Rail  qui2c = new Rail( s3 , s4, Sens.Qui2 );
		Rail  qui2d = new Rail( s4 , s5, Sens.Qui2 );
		
		// retour 
		s1.setsite(Direction.Est , rail1);
	    s2.setsite(Direction.Est , rail2);
		s3.setsite(Direction.Est , rail3);
		s4.setsite(Direction.Est,  rail4);
		
		// aller au terminus
		s5.setsite(Direction.Ouest,  qui2d);
		s4.setsite(Direction.Ouest,  qui2c);
		s3.setsite(Direction.Ouest , qui2b);
		s2.setsite(Direction.Ouest , qui2a);
		// 
	
	
	
		
		stations.add(s1); 
		stations.add(s2);
		stations.add(s3); 
		stations.add(s4);
		stations.add(s5);
				
		return this;
	}
	
	public void draw_Trafic(Graphics g, int SCALE, int SIZE) {
	//	aiguille.draw_element(g, SCALE, SIZE);
		for(Station s : stations) {
			s.draw_element(g, SCALE , SIZE);
		}
		for(int i = 0; i < stations.size()   ; i++) {
			if(stations.get(i).getMapsite().containsKey(Direction.Est))
				stations.get(i).getSite(Direction.Est).draw_element(g, SCALE, SIZE/2);
			if( stations.get(i).getMapsite().containsKey(Direction.Ouest))
				stations.get(i).getSite(Direction.Ouest).draw_element(g, SCALE, SIZE/2);
		}

				
 	   	
	}
	
	public void step() {
		for(Train train : trains )
			train.move().entrer(train);		
	}
	
	 public Station depart() {
		 int x = stations.get(0).getLocation().getX() * Gui.SCAL;
		 int y = stations.get(0).getLocation().getY();
		 return stations.get(0);
	 }
}