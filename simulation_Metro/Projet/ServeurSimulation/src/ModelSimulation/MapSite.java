package ModelSimulation;

import java.awt.Graphics;

public interface MapSite {
	public void draw_element(Graphics g, int SCAL, int SIZE);
	public void entrer(Train train);
}
