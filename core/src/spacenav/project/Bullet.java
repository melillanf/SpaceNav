package spacenav.project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Bullet extends Proyectil{
	    
	    public Bullet(float x, float y, int xSpeed, int ySpeed, Texture tx) {
	    	setSpr(new Sprite(tx));
	    	getSpr().setPosition(x, y);
	        this.setxSpeed(xSpeed);
	        this.setySpeed(ySpeed);
	    }
	    public void update() {
	        getSpr().setPosition(getSpr().getX()+getxSpeed(), getSpr().getY()+getySpeed());
	        if (getSpr().getX() < 0 || getSpr().getX()+getSpr().getWidth() > Gdx.graphics.getWidth()) {
	            setDestroyed(true);
	        }
	        if (getSpr().getY() < 0 || getSpr().getY()+getSpr().getHeight() > Gdx.graphics.getHeight()) {
	        	setDestroyed(true);
	        }
	        
	    }
	    
	    public boolean checkCollision(Ball2 b2) {
	        if(getSpr().getBoundingRectangle().overlaps(b2.getArea())){
	        	// Se destruyen ambos
	            setDestroyed(true);
	            return true;
	
	        }
	        return false;
	    }	
}
