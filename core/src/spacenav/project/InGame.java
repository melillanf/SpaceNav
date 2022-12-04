package spacenav.project;
import com.badlogic.gdx.*;
public class InGame {
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
		mainScreen = new PantallaMenu(mainGame);\
		
	}
	public void switchToJuego(SpaceNavigation mainGame) {
		
	}
	public void switchToGameOver(SpaceNavigation mainGame) {
		
	}
	public void nextLevel(PantallaJuego gameplay) {
		
		
	}
	public void setMainScreen(Screen newMain) {
		this.mainScreen = newMain;
	}
	public Screen getMainScreen() {
		return mainScreen;
	}
}
