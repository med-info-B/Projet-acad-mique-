package ModelSimulation;



import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import Controller.Ordinateur;
import ModelSimulation.Rail.Sens;
import Vue.Gui;





public class Train {
	private int numero;
	private final int INITSIZE = 3;
	private List<Coordinate> train;
	private Station currentStation;
	private Color colorTrain;
	private List<ObserverTrain> observers;
	private Direction direction;
	private ModelSimulation.Rail.Sens quai;
	private boolean stop = false;
	private int timer = 300;  // 3 min  dans chaque station 
	private int V = 1;
	private Ordinateur ordinateur;
	
	public Train(Ordinateur ordinateur,Station start, int numero) {		
		this.currentStation = start;
		colorTrain = Color.GREEN;
		this.direction = Direction.Est;
		Coordinate star = new Coordinate(start.getLocation().getX() * Gui.SCAL, start.getLocation().getY()); 
		observers = new ArrayList<ObserverTrain>();
		train = new ArrayList<Coordinate>();
		for(int i = 0; i < INITSIZE; i++) {
			train.add(new Coordinate(star.getX() + i, star.getY()));
		
		}
		this.currentStation = start;
		quai = Sens.Qui2;
		this.numero = numero;
		this.ordinateur = ordinateur;

	}

	public void register(ObserverTrain o){	
		observers.add(o);
	}
	
	public void changeVitesse() {
		this.V = 2;
	}
	
	public void resetVitesse() {
		this.V = 1;
	}
	
	public void changeDirection(Direction direction) {
		this.direction = direction;
	}

	protected void notifyObserver(List<Coordinate> events) {
		for(ObserverTrain o : observers)
			o.notifyTrainEvent(events);	
	}
    
	public void stop(boolean stop) {
		System.out.println("stop ");
		this.stop = stop;
		timer++;
	}
	
	public void changeQui(Sens quai) {
		this.quai = quai;
	}
	

	public void avance() {
		if(!stop) {	
			Coordinate head = train.get(train.size() - 1);
			Coordinate next = new Coordinate(head.getX() + direction.getX() * V ,
							head.getY() + direction.getY());
			changePosition(next);
		}		
        if(timer >= 0) {
        	stop = false;
        	timer --;
        }
        else {
        	stop = false;
        	timer = 300;
        }
	}
	
	public Station getcurrentStation() {
		return currentStation;
	}
	public void changePosition(Coordinate position) {
		train.add(position);
		List<Coordinate> events  = new ArrayList<Coordinate>();
		events.add(position);
		notifyObserver(events);
		train.remove(0);		
	}
	public void changeStation(Station s) {
	  this.currentStation = s;
	}
	
	public Coordinate headTrain() {
		Coordinate head  = train.get(train.size() - 1);
		return head;
	} 
	
	public MapSite move(){
			return currentStation.getSite(direction);
	}
	
	public void draw_Train(Graphics g , int Scale) {
		int x = train.get(0).getX();
		int y = train.get(0).getY();
		int w=0,h=0;
		if(direction.equals(Direction.Est)  || direction.equals(Direction.Ouest)) {
			w = 44;
			h = 15;
		}
		else if ( direction.equals(Direction.Nord) || direction.equals(Direction.Sud)){
			w = 15;
			h = 44;
		}
		
		g.setColor(this.colorTrain);
		
		   if(this.quai.equals(Sens.Qui1)) {
			   g.drawString("N° :"+numero,x,y * Scale + 7);
			   for(Coordinate p : train) {
				   g.fillOval(p.getX() ,p.getY() * Scale + 35, w, h);
			   }
		   } else {
			   for(Coordinate p : train) { 
				   g.drawString("N° :"+numero,x,y * Scale + 6);
				   g.fillOval(p.getX()  ,p.getY() * Scale - 25, w, h);
			   }
		   }
	}
	
	public void  arrivedStationTerminusZone() {

	}
	
	public Sens getSens() {
		return this.quai;
	}
    public Direction getDirection() {
    	return this.direction;
    }
	
}


