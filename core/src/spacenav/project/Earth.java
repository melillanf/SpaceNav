package spacenav.project;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Earth implements Jugable {
	
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
    public void draw(SpriteBatch batch, PantallaJuego juego) {
    	spr.setPosition(x, 0);
    	spr.draw(batch);
    }
    public Sprite getSprite() {
    	return spr;
    }
	@Override
	public boolean checkCollision(Ball2 b) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean estaDestruido() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean estaHerido() {
		// TODO Auto-generated method stub
		return false;
	}
}
