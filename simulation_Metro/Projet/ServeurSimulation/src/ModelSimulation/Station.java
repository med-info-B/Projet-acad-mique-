package ModelSimulation;

import java.awt.Color;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;



public abstract class Station implements MapSite {
	
	protected String name;
	protected Coordinate location;
	protected Map<Direction, MapSite> mapSite;
	protected  Color colorLabel;
	protected Color colorStation;
	protected boolean Visited = false;
	protected Dimension dimension;

	
	public Station(Coordinate location, String name) {
		this.location = location;
		this.name = name;
		mapSite =  new HashMap<>();
		
	}
	
	
	public Coordinate getLocation() {
		
		return this.location;
	}
	
	public Map<Direction, MapSite> getMapsite() {
		return this.mapSite;
	}
	
	
	public void setsite(Direction dir, MapSite station){

		mapSite.put(dir,station);
	}
	
	public int  getSizeSite() {
		return this.mapSite.size();
	}
    
	public MapSite getSite(Direction dir) {
		return this.mapSite.get(dir);
	}
	
	public String getNameStation() {
		return name;
	}
}
