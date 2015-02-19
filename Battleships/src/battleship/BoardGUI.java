package battleship;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class BoardGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoardGUI window = new BoardGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BoardGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Battleships");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//TODO if game not finished, confirm if want to end game.
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel menu = new JPanel();
		frame.getContentPane().add(menu, BorderLayout.NORTH);
		
		JPanel playerPanel = new JPanel();
		frame.getContentPane().add(playerPanel, BorderLayout.WEST);
		playerPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel opponentPanel = new JPanel();
		frame.getContentPane().add(opponentPanel, BorderLayout.EAST);
		opponentPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel buttons = new JPanel();
		frame.getContentPane().add(buttons, BorderLayout.SOUTH);
		buttons.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton Done = new JButton("Done");
		Done.setHorizontalAlignment(SwingConstants.RIGHT);
		buttons.add(Done);
		
		JPanel status = new JPanel();
		frame.getContentPane().add(status, BorderLayout.CENTER);
		
		JLabel remain = new JLabel("Enemy Ships Remaining: ");
		status.add(remain);
	}

}
