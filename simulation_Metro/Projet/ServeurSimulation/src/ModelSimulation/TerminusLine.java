package ModelSimulation;

import java.awt.Font;
import java.awt.Graphics;

import ModelSimulation.Rail.Sens;



public class TerminusLine extends StationTerminus {

	public TerminusLine(Coordinate location, String name) {
		super(location, name);
	}

	@Override
	public void entrer(Train train) {
		train.changeStation(this);
		
		if(train.getDirection().equals(Direction.Est)){
			train.changeDirection(Direction.Ouest);
			if(train.getSens().equals(Sens.Qui1))
			train.changeQui(Sens.Qui2);
			else
			train.changeQui(Sens.Qui1);
		}
//		else {
//			train.changeDirection(Direction.Ouest);
//			train.changeQui(Sens.Qui2);
//		}
		
	}

	@Override
	public void draw_element(Graphics g, int SCAL, int SIZE) {

		// Constance de positon
		int X1 = location.getX() *  SCAL;
		int Y1 =  location.getY() * SCAL;
		// Constance de la taille
		int W = dimension.width *  SIZE;
		int H = dimension.height * SIZE;
		
		// Constance de décalage
		final int  DECAX = 55;
		final int DECAY = 33;
		
		// Dessin d'une Station
		g.setColor(colorStation);
		g.fill3DRect(X1  - DECAX, Y1  - DECAY, W , H ,true);
		
		// constance de decalage;
		final int DX = (-33);
		final int DY = 38;
		
		// le label d'une station
		g.setColor(colorLabel);
		Font fonte = new Font("TimesRoman ",Font.BOLD,10);
		g.setFont(fonte);
		g.drawString(name, X1 + DX , Y1  + DY - 22);
		
		// Constance de position
		final int DXX = 50;
		
		// Le label de terminus
		g.setColor(colorLabel);
		Font font = new Font("TimesRoman ",Font.BOLD,10);
		g.setFont(font);
		g.drawString("Terminus",X1 - DXX , Y1 + DY);
	}

}