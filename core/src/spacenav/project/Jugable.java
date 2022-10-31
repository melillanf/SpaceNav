package spacenav.project;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Jugable {
	public void draw(SpriteBatch batch, PantallaJuego juego);
	public boolean checkCollision(Ball2 b);
	public boolean estaDestruido();
	public boolean estaHerido();
}
