package TestApp;

import Controller.Ordinateur;

public class App1 {
	public static void main(String[] args) {
		
		  Ordinateur ordinateur = new Ordinateur();	 
		  while (ordinateur.getTest()) {
				ordinateur.step();
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		
		}
}
