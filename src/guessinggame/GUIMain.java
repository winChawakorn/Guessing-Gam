package guessinggame;

public class GUIMain {
	public static void main(String[] args) {
		GameUI gui = new GameUI(new Game(10));
		gui.run();
	}
}
