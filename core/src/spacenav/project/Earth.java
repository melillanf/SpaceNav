package spacenav.project;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Earth {
	
	//private boolean destruida = false;
    //private int vidas;
    private Sprite spr;
    //private Sound sonidoHerido;
    //private boolean herido = false;
    //private int tiempoHeridoMax=50;
    //private int tiempoHerido;
    private int x;
    
    public Earth(Texture tx, int x) {
    	this.x=x;
    	spr = new Sprite(tx);
    	spr.setPosition(x, 0);
    	
    }
    public void draw(SpriteBatch batch) {
    	spr.setPosition(x, 0);
    	spr.draw(batch);
    }
    public Sprite getSprite() {
    	return spr;
    }
    public void moveEarth(int moving) {
    	this.spr.setPosition(moving, moving);
    }
}
