package spacenav.project;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Proyectil {
	private int xSpeed;
	private int ySpeed;
	private boolean destroyed = false;
	private Sprite spr;
	
	public void draw(SpriteBatch batch) {
    	spr.draw(batch);
    }
	
	public void update(){
		updatePosition();//posiciona el objeto
		checkCordinates();//verifica las interacciones del objeto
	};
	
	public void checkCollision(Ball2 b2) {
		calculateCollision(b2);
	}
	
	public int getxSpeed() {
		return xSpeed;
	}

	public void setxSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}

	public int getySpeed() {
		return ySpeed;
	}

	public void setySpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}

	public boolean isDestroyed() {
		return destroyed;
	}

	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}

	public Sprite getSpr() {
		return spr;
	}

	public void setSpr(Sprite spr) {
		this.spr = spr;
	}
	
	public void setxySpeed(int x, int y) {
		this.xSpeed = x;
		this.ySpeed = y;
	}
	public abstract void updatePosition();
	public abstract void checkCordinates();
	public abstract void calculateCollision(Ball2 b2);
}
