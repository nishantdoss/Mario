import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;

import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gameframe extends JFrame {
	private MarioGame game = new MarioGame();
	

	// starting dimensions of window (pixels)
	public static final int WIDTH = 600, HEIGHT = 380, REFRESH = 50;
	private Image marioFace;
	
	// where the game objects are displayed
	private JPanel panel = new JPanel() {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			game.drawTheGame(g);
			// tried to get rid of some stuttering, changing REFRESH 
			// improved this issue
			panel.getToolkit().sync();
		}
	};
	private Timer timer;//timer that runs the game


	public Gameframe(String string) {
		super(string);
		setUpStuff();
	}

	/**
	 * Sets up the panel, timer, other initial objects in the game.
	 * The Timer goes off every REFRESH milliseconds.  Every time the
	 * Timer goes off, the game is told to update itself and then the 
	 * view is refreshed.  
	 */
	private void setUpStuff() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.add(panel);
		this.pack();
	
		timer = new Timer(REFRESH, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel.repaint();
				
				//System.out.println("1");
			}
		});

		

		timer.start();
		panel.setBackground(Color.GREEN);

		this.setVisible(true);
		panel.requestFocusInWindow();
		addKeys(panel);

	}

	/**
	 * Proper way to acquire keystrokes in an application.  
	 * This method sets up the mapping which associates a Keystroke (you
	 * can Google Java KeyStroke API or examples) with an "action command" String 
	 * 
	 * The second part maps the action command String with an Action.
	 * I have shown you two ways this can be done.  You can write the code
	 * you want executed in the actionPerformed method or you can call the
	 * method from within the actionPerformed method call.
	 */
	private void addKeys(JPanel panel) {
		// this connects keystroke with a command
		panel.getInputMap().put(KeyStroke.getKeyStroke("UP"), "up_key");
		panel.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rt_key");
		panel.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "lt_key");
		panel.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "dn_key");
		panel.getInputMap().put(KeyStroke.getKeyStroke("released LEFT"), "lt_key_r");
		panel.getInputMap().put(KeyStroke.getKeyStroke("released UP"), "up_key_r");
		panel.getInputMap().put(KeyStroke.getKeyStroke("released RIGHT"), "rt_key_r");
		panel.getInputMap().put(KeyStroke.getKeyStroke("released LEFT"), "lt_key_r");
		panel.getInputMap().put(KeyStroke.getKeyStroke("released DOWN"), "dn_key_r");

		// panel.getActionMap().put("up_key", new AbstractAction() {

		// 	@Override
		// 	public void actionPerformed(ActionEvent e) {
		// 		System.out.println("hit up arrow");
		// 		game.upHit(e);
		// 	}
		// });
		panel.getActionMap().put("rt_key",new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("hit the right arrow");
				game.rtHit(e);
			}
		});
		panel.getActionMap().put("lt_key",new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("hit the left arrow");
				game.ltHit(e);
			}
		});


		// panel.getActionMap().put("dn_key", new AbstractAction() {
		// 	@Override
		// 	public void actionPerformed(ActionEvent e) {
		// 		System.out.println("hit the down arrow");
		// 		// game.downHit(e);
		// 	}
		// });
	}

}
