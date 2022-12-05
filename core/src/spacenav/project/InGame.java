package spacenav.project;
import com.badlogic.gdx.*;
public final class InGame {
	private static InGame instance;
	private Screen mainScreen;//Usa 3 tipos de Screen: PantallaMenu, PantallaJuego y PantallaGameOver
	int round;
	private InGame(SpaceNavigation mainGame) {
		mainScreen = new PantallaMenu(mainGame);
		round = 0;
		//
	}
	
	public static InGame getInstance(SpaceNavigation mainGame) {
		if(instance == null) {
			synchronized(InGame.class) {
				if(instance==null) instance = new InGame(mainGame);
			}
		}
		return instance;
	}
	
	
	public void switchToMenu(SpaceNavigation mainGame) {
		round = 0; 
		mainScreen = new PantallaMenu(mainGame);
		mainGame.setScreen(mainScreen);
	}
	public void switchToJuego(SpaceNavigation mainGame) {
		
		Screen nueva = new PantallaJuego(mainGame,1,3,0,1,1,10,1,15,this);
		nueva.resize(1200, 800);
		mainGame.setScreen(nueva);
		
	}
	public void switchToGameOver(SpaceNavigation mainGame) {
		mainScreen = new PantallaGameOver(mainGame);
		mainGame.setScreen(mainScreen);
	}
	public void nextLevel(PantallaJuego gameplay) {
		int cantMisiles=gameplay.getCantAsteroides()+12;
		Screen siguienteLevel = new PantallaJuego(gameplay.getGame(),gameplay.getRonda()+1, gameplay.getNave().getVidas(), gameplay.getScore(), 
				gameplay.getVelXAsteroides()+3, gameplay.getVelYAsteroides()+3, gameplay.getCantAsteroides()+10,gameplay.getCount(),cantMisiles, this);
		gameplay.getGame().setScreen(siguienteLevel);;
		
	}
	public void setMainScreen(Screen newMain) {
		this.mainScreen = newMain;
	}
	public Screen getMainScreen() {
		return mainScreen;
	}
}
