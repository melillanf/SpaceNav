package spacenav.project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Bullet extends Proyectil{
	    
	    private Bullet(BulletBuilder builder) {
	    	this.setxySpeed(builder.xSpeed,builder.ySpeed);
	    	this.setSpr(builder.spr);
	    	this.setxSpeed(builder.xSpeed) ;
	    	this.setySpeed(builder.ySpeed);
	    	
	    }
	    
	    public void updatePosition() {//1st step
	    	getSpr().setPosition(getSpr().getX()+getxSpeed(), getSpr().getY()+getySpeed());
	    }
	    
	    public void checkCordinates() {//2nd step
	    	if (getSpr().getX() < 0 || getSpr().getX()+getSpr().getWidth() > Gdx.graphics.getWidth()) {
	            setDestroyed(true);
	        }
	        if (getSpr().getY() < 0 || getSpr().getY()+getSpr().getHeight() > Gdx.graphics.getHeight()) {
	        	setDestroyed(true);
	        }
	    }
	    
	    public void calculateCollision(Ball2 b2) {//3rd step
	    	 if(getSpr().getBoundingRectangle().overlaps(b2.getArea())){
		        	// Se destruyen ambos
		            setDestroyed(true);
		            b2.setDestroyed(true);
		        }
		       
	    }
	    
	    public static class BulletBuilder{
	
	    	int xSpeed = 0;
	    	int ySpeed = 4;
	    	boolean destroyed = false;
	    	Sprite spr;

	    	public BulletBuilder(Sprite sprite, Texture txBala) {
	    		float x = sprite.getX()+sprite.getWidth()/2-5;
	    		float y = sprite.getY()+ sprite.getHeight()-5;
	    		setSpr(new Sprite(txBala));
		    	spr.setPosition(x, y);
		        setxSpeed(xSpeed);
		        setySpeed(ySpeed);
	    	}
	    	public void setxSpeed(int xSpeed) {
	    		this.xSpeed = xSpeed;
	    	}

	    	public void setySpeed(int ySpeed) {
	    		this.ySpeed = ySpeed;
	    	}

	    	public void setDestroyed(boolean destroyed) {
	    		this.destroyed = destroyed;
	    	}
	    	
	    	public void setSpr(Sprite spr) {
	    		this.spr = spr;
	    	}
	    	
	    	public Bullet build() {
	    		return new Bullet(this);
	    	}
	    }
	
}

