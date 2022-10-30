package spacenav.project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;


public class PantallaMenu implements Screen {

	private SpaceNavigation game;
	private OrthographicCamera camera;
	private Texture backgroundTx;
	private Sprite backgroundSpr;
	private SpriteBatch batch;
	public PantallaMenu(SpaceNavigation game) {
		this.game = game;
        
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1200, 800);
        backgroundTx = new Texture(Gdx.files.internal("menu.png"));
        backgroundSpr =new Sprite(backgroundTx);
        backgroundSpr.setPosition(Gdx.graphics.getHeight()/2,150);
    }
	 public void renderBackground() {
	        backgroundSpr.draw(game.getBatch());
	    }
	@Override
	public void render(float delta) {
		//ScreenUtils.clear(0, 0, 0.2f, 1);
		
		camera.update();
		game.getBatch().setProjectionMatrix(camera.combined);
		game.getBatch().begin();
		backgroundSpr.draw(game.getBatch());
		renderBackground();
		game.getFont().draw(game.getBatch(), "Bienvenido a Earth Defender !", Gdx.graphics.getHeight()/2, 700);
		game.getFont().draw(game.getBatch(), "Presiona ESPACIO para comenzar a defender la Tierra...", 250, 200);
	
		game.getBatch().end();

		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
			Screen ss = new PantallaJuego(game,1,3,0,1,1,10,1);
			ss.resize(1200, 800);
			game.setScreen(ss);
			dispose();
		}
	}
	
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
   
}