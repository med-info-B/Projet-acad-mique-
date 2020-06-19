package ModelServeur;

import java.util.List;

public class Zone {
	
	private String name; 
	private List<String> stations;
	
	public Zone(String name) {
		this.name = name;
	}
	
	public void addStation(String name) {
		stations.add(name);
	}
	
	public void removeStation(String name) {
		stations.remove(name);
	}
	
	public synchronized boolean existStation(String name) {
		return stations.contains(name);
	}
	
	
	public String getName() {
		return name;
	}
	
}
