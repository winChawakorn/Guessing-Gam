package guessinggame;

/**
 * 
 * @author Chawakorn Suphepre
 * @version 2017.01.30
 */
public class Main {

	/** create object and start the game */
	public static void main(String[] args) {
		Game game = new Game(20);
		GameConsole ui = new GameConsole();
		ui.play(game);
	}
}
