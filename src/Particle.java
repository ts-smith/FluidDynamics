

import org.newdawn.slick.geom.Circle;

public class Particle {
	
	//For Springs
	static double plasticity=.3;
	
	static double restDensity=1600;
	static double stiffness=.004;
	static double nearStiffness=.01; 
	
	//For Viscosity
	static float theta = .1f;
	static float beta = 0f;
	
	static int serial=0;
	
	float x;
	float y;
	float xPrev;
	float yPrev;
	float density;
	float nearDensity;
	float pressure;
	float nearPressure;
	float[] velocity =new float[2];
	
	Circle c = null;
	int idNum;
	
	public String toString(){
		return "Particle Id="+idNum;
	}
	Particle(float x, float y){
		this.x=x;
		this.y=y;
		velocity[0]=0;
		velocity[1]=0;
		c=new Circle(x,y,5,9);
		idNum=serial;
		serial++;
	}
	void setVelocity(float newX, float newY){
		velocity[0]=newX;
		velocity[1]=newY;
	}
	void recalculateVelocity(){
		setVelocity(x-xPrev,y-yPrev);
	}
	void setPreviousPosition(float x, float y){
		xPrev=x;
		yPrev=y;
	}
	void setPredictedPostion(float[] velocity){
		this.x+=velocity[0];
		this.y+=velocity[1];
	}
	void compensateForContainerCollisions(){
		if(x>Container.safeRight){
			x=Container.safeRight;
		}
		else if (x<Container.safeLeft){
			x=Container.safeLeft;
		}
		if (y>Container.safeBottom){
			y=Container.safeBottom;
		}
		else if (y<Container.safeTop){
			y=Container.safeTop;
		}
	}
	void updateCircle(){
		c.setCenterX(x);
		c.setCenterY(y);
	}

}
