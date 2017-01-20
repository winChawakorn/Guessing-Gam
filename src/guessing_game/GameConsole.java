package guessing_game;

import java.util.Scanner;

/**
 * Game console for guessing_game
 * 
 * @author Chawakorn Suphepre
 *
 */
public class GameConsole {
	private Scanner sc = new Scanner(System.in);

	/**
	 * The play method plays a game using input from user.
	 * 
	 * @param game
	 *            is the Game object that we start by this class.
	 */
	public void play(Game game) {
		System.out.printf("I'm thinking of a number between 1 and %d\n",
				game.getUpperbound());
		while (true) {
			System.out.print("What is your guess? ");
			int num = sc.nextInt();
			game.setCount();
			game.guess(num);
			System.out.println(game.getHint());
			if (num == game.getAns()) {
				System.out.printf("Correct. You used %d guesses.",
						game.getCount());
				return;
			}
		}
	}

}
