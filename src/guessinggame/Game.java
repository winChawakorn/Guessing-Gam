package guessinggame;

import java.util.Random;

/**
 * Game of guessing a secret number.
 * 
 * @author Chawakorn Suphepre
 * @version 2017.01.30
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
		count++;
		if (number == ans) {
			setHint(String.format("Right. The secret is %d.", ans));
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
	protected void setAns(int ans) {
		this.ans = ans;
	}

	/**
	 * Return hint of that round
	 * 
	 * @return value of hint
	 */
	public String getHint() {
		return hint;
	}

	/**
	 * Use to set value of hint.
	 * 
	 * @param hint
	 *            is the hint for guessing
	 */
	protected void setHint(String hint) {
		this.hint = hint;
	}

	/**
	 * Return value of count in that time
	 * 
	 * @return value of count
	 */
	public int getCount() {
		return count;
	}

}