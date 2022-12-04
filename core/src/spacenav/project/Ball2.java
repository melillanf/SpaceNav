package spacenav.project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

//Meteorito
public class Ball2 extends Proyectil{
	private int x;
    private int y;

    public Ball2(int x, int y, int size, int xSpeed, int ySpeed, Texture tx) {
    	setSpr(new Sprite(tx));
    	this.x = x; 
 	
        //validar que borde de esfera no quede fuera
    	if (x-size < 0) this.x = x+size;
    	if (x+size > Gdx.graphics.getWidth())this.x = x-size;
         
        this.y = y;
        //validar que borde de esfera no quede fuera
    	if (y-size < 0) this.y = y+size;
    	if (y+size > Gdx.graphics.getHeight())this.y = y-size;
    	
        getSpr().setPosition(x, y);
        this.setySpeed(xSpeed);
        this.setySpeed(ySpeed);
    }

    public void updatePosition() {
    	x += getxSpeed();
        y += getySpeed();
    	getSpr().setPosition(x, y);
    }
    
    public void checkCordinates() {
    	if (x+getxSpeed() < 0 || x+getxSpeed()+getSpr().getWidth() > Gdx.graphics.getWidth())
          	setySpeed(getxSpeed() * -1);
        if (y+getySpeed() < 0 || y+getySpeed()+getSpr().getHeight() > Gdx.graphics.getHeight())
          	setySpeed(getySpeed() * -1);
    }
    public Rectangle getArea() {
    	return getSpr().getBoundingRectangle();
    }
    public void draw(SpriteBatch batch) {
    	getSpr().draw(batch);
    }
    
    public void calculateCollision(Ball2 b2) {
    	if(getSpr().getBoundingRectangle().overlaps(b2.getSpr().getBoundingRectangle())){
        	// rebote
            if (getxSpeed() ==0) setySpeed(getxSpeed() + b2.getxSpeed()/2);
            if (b2.getxSpeed() ==0) b2.setySpeed(b2.getxSpeed() + getxSpeed()/2);
        	setySpeed(- getxSpeed());
            b2.setySpeed(-b2.getxSpeed());
            
            if (getySpeed() ==0) setySpeed(getySpeed() + b2.getySpeed()/2);
            if (b2.getySpeed() ==0) b2.setySpeed(b2.getySpeed() + getySpeed()/2);
            setySpeed(- getySpeed());
            b2.setySpeed(- b2.getySpeed()); 
        }
    }
	
    
}
