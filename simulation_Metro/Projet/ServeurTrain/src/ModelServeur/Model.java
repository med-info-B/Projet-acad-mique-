package ModelServeur;

import java.util.ArrayList;
import java.util.List;

public class Model {
		
	private List<Zone>  zone = new ArrayList<Zone>();
	
	
	public Model() {
		zone.add(new Zone("Zone 1"));
		zone.add(new Zone("Zone 2"));
	}
	
	
	public synchronized boolean exitZone(String name ) {
		for(Zone z : zone) {
			if(z.getName().equals(name))
				return true;
		}
		return false;
	}
	
	
	public void addZone(String name) {
		zone.add(new Zone(name));
	}
	

	
	
	
	
	
	
}
