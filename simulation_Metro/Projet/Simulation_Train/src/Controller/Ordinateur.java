package Controller;

import java.net.Socket;

import ModelSimulation.Station;
import ModelSimulation.Trafic;
import ModelSimulation.Train;
import Vue.Gui;

;

public class Ordinateur {
	
	private Train train;
	private Trafic trafic;	
	private boolean connected = false;
	private Socket socket;
	private final static int PORT = 1234;
	private HandlerTrain handlerconnexion;
	private final static  String name = "Zone 1";
	private String connectAdress = "localhost";
	private Gui gui;
	private boolean test = false;
	 
	public Ordinateur() {
		connect();
	}
	
	public boolean getTest() {
		return test;
	}
	public void setTrain(int numero, String nameStation) {
		Station s = trafic.findStationByName(nameStation);
		if(s != null) {
			train = new Train(this, s ,numero);
			trafic.setTrain(train);
			gui.setTrain(train);
			train.register(gui);
			test = true;
			
		}
	}
	
	
	public void initalisation() {
		trafic = new Trafic();
		trafic = trafic.creatTrafic();
		gui = new Gui(this);
		setTrain(1,"Saint-Lazare");

	
	}
	

	public void connect() {
		if(connected) return;
		try {
			socket = new Socket(connectAdress,PORT);
			connected = true;
			handlerconnexion = new HandlerTrain(socket,this);
			handlerconnexion.start();
			handlerconnexion.sendName(name);
			
		}catch (Exception e) {
		}
	}
	
	public void step() {
		trafic.step();
	}
	
	public Train getTain() {
		return train;
	}
	
	
	public Trafic getTrafic() {
		return trafic;
	}
	
	
	public boolean connected(){
		return this.connected;
	}
	
	

}