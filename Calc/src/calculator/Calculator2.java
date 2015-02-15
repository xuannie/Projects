package calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextArea;

import java.awt.Font;

import javax.swing.JTextField;


public class Calculator2 implements KeyListener{

	private JFrame frame;
	private final JPanel panel = new JPanel();
	private JTextArea textField;
	private JPanel panel_1;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_10;
	private JButton button_11;
	private JButton button_12;
	private JButton button_13;
	private JButton btnC;
	private JButton button_14;
	private JButton btnX;
	private JButton button_15;
	private JButton button_16;
	private String tf = "";
	private JButton button_17;
	private JTextField TypeField;
	private Calculations getResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator2 window = new Calculator2();
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
	public Calculator2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Calculator");
		frame.setResizable(false);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		textField = new JTextArea();
		textField.setEditable(false);
		textField.addKeyListener((KeyListener)this);
		
		textField.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		textField.setRows(3);
		textField.setColumns(10);
		JScrollPane scroll = new JScrollPane(textField);
		panel.add(scroll, BorderLayout.NORTH);
		
		TypeField = new JTextField();
		TypeField.setFont(new Font("DejaVu Sans", Font.PLAIN, 16));
		TypeField.setEditable(false);
		panel.add(TypeField, BorderLayout.SOUTH);
		TypeField.setColumns(10);
		
		//panel_1 is button panel
		panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);

		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		btnC = new JButton("C");
		btnC.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tf.length()>0){
					tf = "";
				}					
				textField.setText(tf);
			}
		});
		GridBagConstraints gbc_btnC = new GridBagConstraints();
		gbc_btnC.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnC.insets = new Insets(0, 0, 5, 5);
		gbc_btnC.gridx = 0;
		gbc_btnC.gridy = 0;
		panel_1.add(btnC, gbc_btnC);
		
		button_15 = new JButton("/");
		button_15.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf = tf + " / ";
				textField.setText(tf);
			}
		});
		GridBagConstraints gbc_button_15 = new GridBagConstraints();
		gbc_button_15.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_15.insets = new Insets(0, 0, 5, 5);
		gbc_button_15.gridx = 1;
		gbc_button_15.gridy = 0;
		panel_1.add(button_15, gbc_button_15);
		
		btnX = new JButton("x");
		btnX.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf = tf + " x ";
				textField.setText(tf);
			}
		});
		GridBagConstraints gbc_btnX = new GridBagConstraints();
		gbc_btnX.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnX.insets = new Insets(0, 0, 5, 5);
		gbc_btnX.gridx = 2;
		gbc_btnX.gridy = 0;
		panel_1.add(btnX, gbc_btnX);
		
		button_16 = new JButton("\u2190");
		button_16.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf.length()>0){
					if (tf.substring(tf.length()-1).equals(" "))
						tf = tf.substring(0,tf.length()-3);
					else
						tf = tf.substring(0, tf.length()-1);
				}					
				textField.setText(tf);
			}
		});
		GridBagConstraints gbc_button_16 = new GridBagConstraints();
		gbc_button_16.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_16.insets = new Insets(0, 0, 5, 0);
		gbc_button_16.gridx = 3;
		gbc_button_16.gridy = 0;
		panel_1.add(button_16, gbc_button_16);
		
		button = new JButton("7");
		button.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf = tf + "7";
				textField.setText(tf);
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.HORIZONTAL;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 0;
		gbc_button.gridy = 1;
		panel_1.add(button, gbc_button);
		
		button_1 = new JButton("8");
		button_1.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf = tf + "8";
				textField.setText(tf);
			}
		});
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 1;
		gbc_button_1.gridy = 1;
		panel_1.add(button_1, gbc_button_1);
		
		button_2 = new JButton("9");
		button_2.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf = tf + "9";
				textField.setText(tf);
			}
		});
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_2.insets = new Insets(0, 0, 5, 5);
		gbc_button_2.gridx = 2;
		gbc_button_2.gridy = 1;
		panel_1.add(button_2, gbc_button_2);
		
		button_14 = new JButton("\u2212");
		button_14.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf = tf + " - ";
				textField.setText(tf);
			}
		});
		GridBagConstraints gbc_button_14 = new GridBagConstraints();
		gbc_button_14.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_14.insets = new Insets(0, 0, 5, 0);
		gbc_button_14.gridx = 3;
		gbc_button_14.gridy = 1;
		panel_1.add(button_14, gbc_button_14);
		
		button_3 = new JButton("4");
		button_3.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf = tf + "4";
				textField.setText(tf);
			}
		});
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_3.insets = new Insets(0, 0, 5, 5);
		gbc_button_3.gridx = 0;
		gbc_button_3.gridy = 2;
		panel_1.add(button_3, gbc_button_3);
		
		button_4 = new JButton("5");
		button_4.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf = tf + "5";
				textField.setText(tf);
			}
		});
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_4.insets = new Insets(0, 0, 5, 5);
		gbc_button_4.gridx = 1;
		gbc_button_4.gridy = 2;
		panel_1.add(button_4, gbc_button_4);
		
		button_5 = new JButton("6");
		button_5.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf = tf + "6";
				textField.setText(tf);
			}
		});
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_5.insets = new Insets(0, 0, 5, 5);
		gbc_button_5.gridx = 2;
		gbc_button_5.gridy = 2;
		panel_1.add(button_5, gbc_button_5);
		
		button_13 = new JButton("+");
		button_13.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf = tf + " + ";
				textField.setText(tf);
			}
		});
		GridBagConstraints gbc_button_13 = new GridBagConstraints();
		gbc_button_13.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_13.insets = new Insets(0, 0, 5, 0);
		gbc_button_13.gridx = 3;
		gbc_button_13.gridy = 2;
		panel_1.add(button_13, gbc_button_13);
		
		button_6 = new JButton("1");
		button_6.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf = tf + "1";
				textField.setText(tf);
			}
		});
		GridBagConstraints gbc_button_6 = new GridBagConstraints();
		gbc_button_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_6.insets = new Insets(0, 0, 5, 5);
		gbc_button_6.gridx = 0;
		gbc_button_6.gridy = 3;
		panel_1.add(button_6, gbc_button_6);
		
		button_7 = new JButton("2");
		button_7.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf = tf + "2";
				textField.setText(tf);
			}
		});
		GridBagConstraints gbc_button_7 = new GridBagConstraints();
		gbc_button_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_7.insets = new Insets(0, 0, 5, 5);
		gbc_button_7.gridx = 1;
		gbc_button_7.gridy = 3;
		panel_1.add(button_7, gbc_button_7);
		
		button_8 = new JButton("3");
		button_8.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf = tf + "3";
				textField.setText(tf);
			}
		});
		GridBagConstraints gbc_button_8 = new GridBagConstraints();
		gbc_button_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_8.insets = new Insets(0, 0, 5, 5);
		gbc_button_8.gridx = 2;
		gbc_button_8.gridy = 3;
		panel_1.add(button_8, gbc_button_8);
		
		button_12 = new JButton("(");
		button_12.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf = tf + "(";
				textField.setText(tf);
			}
		});
		GridBagConstraints gbc_button_12 = new GridBagConstraints();
		gbc_button_12.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_12.insets = new Insets(0, 0, 5, 0);
		gbc_button_12.gridx = 3;
		gbc_button_12.gridy = 3;
		panel_1.add(button_12, gbc_button_12);
		
		button_9 = new JButton("0");
		button_9.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf = tf + "0";
				textField.setText(tf);
			}
		});
		GridBagConstraints gbc_button_9 = new GridBagConstraints();
		gbc_button_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_9.insets = new Insets(0, 0, 0, 5);
		gbc_button_9.gridx = 0;
		gbc_button_9.gridy = 4;
		panel_1.add(button_9, gbc_button_9);
		
		button_10 = new JButton(".");
		button_10.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf = tf + ".";
				textField.setText(tf);
			}
		});
		GridBagConstraints gbc_button_10 = new GridBagConstraints();
		gbc_button_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_10.insets = new Insets(0, 0, 0, 5);
		gbc_button_10.gridx = 1;
		gbc_button_10.gridy = 4;
		panel_1.add(button_10, gbc_button_10);
		
		button_11 = new JButton("=");
		button_11.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO write method to conduct calculation from String and print answer in next line.
				getResult = new Calculations(tf);
				tf = tf + " = " + getResult; 
				textField.setText(tf);
			}
		});
		GridBagConstraints gbc_button_11 = new GridBagConstraints();
		gbc_button_11.insets = new Insets(0, 0, 0, 5);
		gbc_button_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_11.gridx = 2;
		gbc_button_11.gridy = 4;
		panel_1.add(button_11, gbc_button_11);
		
		button_17 = new JButton(")");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf = tf + ")";
				textField.setText(tf);
			}
		});
		button_17.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		GridBagConstraints gbc_button_17 = new GridBagConstraints();
		gbc_button_17.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_17.gridx = 3;
		gbc_button_17.gridy = 4;
		panel_1.add(button_17, gbc_button_17);
		
		frame.pack();
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
		if(e.getKeyChar()==KeyEvent.VK_ESCAPE){
			if(tf.length()>0){
				tf = "";
			}		
			textField.setText(tf);
		}
		
		if(e.getKeyChar()=='*'){
			tf = tf + " x ";
			textField.setText(tf);
		}
		
		if(e.getKeyChar()==KeyEvent.VK_SLASH){
			tf = tf + " / ";
			textField.setText(tf);
		}
		
		if(e.getKeyChar()==KeyEvent.VK_BACK_SPACE){
			if(tf.length()>0){
				if (tf.substring(tf.length() -1).equals(" "))
					tf = tf.substring(0,tf.length()-3);
				else
					tf = tf.substring(0, tf.length()-1);
			}					
			textField.setText(tf);
		}
		
		if(e.getKeyChar()=='+'){
			tf = tf + " + ";				
			textField.setText(tf);
		}
		
		if(e.getKeyChar()=='-'){
			tf = tf + " - ";				
			textField.setText(tf);
		}
		
		if(e.getKeyChar()==KeyEvent.VK_PERIOD){
			tf = tf + ".";
			textField.setText(tf);
		}
		
		if(e.getKeyChar()==KeyEvent.VK_0){
			tf = tf + "0";
			textField.setText(tf);
		}
		
		if(e.getKeyChar()==KeyEvent.VK_1){
			tf = tf + "1";
			textField.setText(tf);
		}
		
		if(e.getKeyChar()==KeyEvent.VK_2){
			tf = tf + "2";
			textField.setText(tf);
		}
		
		if(e.getKeyChar()==KeyEvent.VK_3){
			tf = tf + "3";
			textField.setText(tf);
		}
		
		if(e.getKeyChar()==KeyEvent.VK_4){
			tf = tf + "4";
			textField.setText(tf);
		}
		
		if(e.getKeyChar()==KeyEvent.VK_5){
			tf = tf + "5";
			textField.setText(tf);
		}
		
		if(e.getKeyChar()==KeyEvent.VK_6){
			tf = tf + "6";
			textField.setText(tf);
		}
		
		if(e.getKeyChar()==KeyEvent.VK_7){
			tf = tf + "7";
			textField.setText(tf);
		}
		
		if(e.getKeyChar()==KeyEvent.VK_8){
			tf = tf + "8";
			textField.setText(tf);
		}
		
		if(e.getKeyChar()==KeyEvent.VK_9){
			tf = tf + "9";
			textField.setText(tf);
		}
		
		if(e.getKeyChar()=='='){
			tf = tf + " = ";		
			//TODO write getResult method.
			textField.setText(tf);
		}
		

		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
