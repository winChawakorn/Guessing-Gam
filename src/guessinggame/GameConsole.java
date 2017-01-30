package guessinggame;

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
	public int play(Game game) {
		System.out.println("Guessing Game");
		System.out.printf("I'm thinking of a number between 1 and %d\n",
				game.getUpperbound());
		while (true) {
			System.out.print("What is your guess? ");
			int num = sc.nextInt();
			game.guess(num);
			System.out.println(game.getHint());
			if (num == game.getAns()) {
				if (game.getCount() == 1) {
					System.out.printf("You used %d guess.", game.getCount());
				} else {
					System.out.printf("You used %d guesses.", game.getCount());
				}
				return game.getAns();
			}
		}
	}

}
