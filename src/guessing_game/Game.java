package guessing_game;

import java.util.Random;

/**
 * Game of guessing a secet number.
 * 
 * @author Chawakorn Suphepre
 */
public class Game {
	private int upperbound;
	private int ans;
	private String hint;
	private int count = 0;

	/**
	 * Initialize a new game.
	 * 
	 * @param upperbound
	 *            is the max value for the secret number.
	 */
	public Game(int upperbound) {
		this.upperbound = upperbound;
		ans = getRandomNumber(upperbound);
	}

	/**
	 * create a random number between 1 and limit.
	 * 
	 * @param limit
	 *            is the upperbound
	 * @return a random number.
	 */
	private int getRandomNumber(int limit) {
		// long seed = System.currentTimeMillis();
		Random rand = new Random();
		return rand.nextInt(limit) + 1;
	}

	/**
	 * Let user guess the number.
	 * 
	 * @param number
	 *            is the number that user guess.
	 * @return Is the user's answer is true?
	 */
	public boolean guess(int number) {
		if (number == ans) {
			setHint(String.format("Right. The secret is %d", ans));
			return true;
		} else if (number > ans) {
			setHint("Sorry, your guess is too large.");
			return false;
		} else {
			setHint("Sorry, your guess is too small.");
			return false;
		}
	}

	/**
	 * Return the upperbound
	 * 
	 * @return value of upperbound.
	 */
	public int getUpperbound() {
		return upperbound;
	}

	/**
	 * set value of upperbound
	 * 
	 * @param upperbound
	 *            is the max value for the secret number.
	 */
	public void setUpperbound(int upperbound) {
		this.upperbound = upperbound;
	}

	/**
	 * Return the ans
	 * 
	 * @return value of ans
	 */
	public int getAns() {
		return ans;
	}

	/**
	 * Set the game answer.
	 * 
	 * @param ans
	 *            is answer of this game.
	 */
	public void setAns(int ans) {
		this.ans = ans;
	}

	/**
	 * Return hint of that round
	 * 
	 * @return hint
	 */
	public String getHint() {
		return hint;
	}

	/**
	 * set hint
	 * 
	 * @param hint
	 *            is the hint for guessing
	 */
	protected void setHint(String hint) {
		this.hint = hint;
	}

	public int getCount() {
		return count;
	}

	public void setCount() {
		count++;
	}
}