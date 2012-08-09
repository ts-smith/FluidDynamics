

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.geom.Rectangle;

public class HashCell {
	int x;
	int y;
	Rectangle rect;
	ArrayList<Particle> contained=new ArrayList<Particle>();
	public HashCell(List<Integer> hashKey, float interactionRadius){
		x=hashKey.get(0);
		y=hashKey.get(1);
		rect = new Rectangle(x*interactionRadius, y*interactionRadius, interactionRadius, interactionRadius);
	}
	public String toString(){
		return "HashCell at "+x+": "+ y;
		
	}
}
