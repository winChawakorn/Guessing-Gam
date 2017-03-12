package guessinggame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Game UI for the guessing game.
 * 
 * @author Chawakorn Suphepre
 * @version 2017.03.10
 */
public class GameUI extends JFrame {
	private JPanel center;
	private JLabel hintMessage;
	private JLabel enterMessage;
	private JTextField num;
	private JButton enter;
	private JButton giveup;
	private JLabel ansMessage;
	private Game game;
	private JPanel north;

	/**
	 * initialize the GameUI.
	 * 
	 * @param game
	 *            is the guessing game to open.
	 */
	public GameUI(Game game) {
		super("Guessing A Number");
		this.game = game;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponent();
	}

	/**
	 * Add components to the JFrame and set the ActionListener to each button.
	 * Write some statement to make the game run correctly.
	 */
	private void initComponent() {
		this.setLocation(700, 450);
		hintMessage = new JLabel("I'm thinking a number between 1 to "
				+ game.getUpperbound() + ".  What is your guess?");
		enterMessage = new JLabel("Enter your guess: ");
		num = new JTextField(2);
		north = new JPanel();
		north.setBorder(BorderFactory.createTitledBorder("Hint"));
		north.add(hintMessage);
		enter = new JButton("Enter");
		enter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!num.getText().equals("")) {

					int number = Integer.parseInt(num.getText());
					if (game.guess(number)) {
						if (number == game.getAns()) {
							if (game.getCount() == 1) {
								ansMessage.setText("You used "
										+ game.getCount() + " guess.");
							} else {
								ansMessage.setText("You used "
										+ game.getCount() + " guesses.");
							}
							enter.setEnabled(false);
							giveup.setEnabled(false);
						}
					}
					hintMessage.setText(game.getHint());
					num.setText("");
				}
			}
		});
		giveup = new JButton("Give Up");
		giveup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hintMessage.setText("The answer is " + game.getAns());
				enter.setEnabled(false);
				giveup.setEnabled(false);
			}
		});
		ansMessage = new JLabel(" ");
		center = new JPanel();
		center.add(enterMessage);
		center.add(num);
		center.add(enter);
		center.add(giveup);
		this.add(north, BorderLayout.NORTH);
		this.add(center, BorderLayout.CENTER);
		this.add(ansMessage, BorderLayout.SOUTH);
		this.pack();
	}

	/**
	 * Run the game UI (make the UI visible).
	 */
	public void run() {
		this.setVisible(true);
	}
}