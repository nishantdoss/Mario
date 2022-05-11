import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MarioGame {
<<<<<<< HEAD
    private JFrame frame = new JFrame("Mario");
    private JPanel panel;
    private final Dimension DIM = new Dimension(800,700);
    public static final int up = 0;
    public static final int right = 1;
    public static final int left = 2;
    //private BejeweledGrid grid = new BejeweledGrid();
    private Image background;
    private Timer timer = new Timer(50,null);
    public static void main(String[] args) {
      // new MarioGame();
        //GameFrame gf = new GameFrame("Mario");
       // gf.setVisible(true);
       try {
        Image f = ImageIO.read(new File("C:/Images/BackgroundMario.png"));
    } catch (IOException e) {
        String workingDir = System.getProperty("user.dir");
        System.out.println("Current working directory : " + workingDir);
        e.printStackTrace();
=======
>>>>>>> eb4af1eff838d259b99a6ec23dde20aad5a86fe8

    private Mario mario;
    private int score;
    private Image marioFace;
    public MarioGame() {
        score = 0;
        mario = new Mario();

        // try {
        //     marioFace = ImageIO.read(new File("../images/LeftMario.png"));
        // }
        // catch (Exception e) {
        //     e.printStackTrace();
        // }
    }

    public void drawTheGame(Graphics g) {
       mario.draw(g);
    }

<<<<<<< HEAD
    }  
    
    public void ltHit(ActionEvent e) {
		System.out.println("Left!!");
        Mario.move(left);
	}

    public void rtHit(ActionEvent e) {
        System.out.println("Right!");
        Mario.move(right);
	}

    public  void upHit(ActionEvent e) {
		System.out.println("Up!!");
        Mario.move(up);
	}
=======
    public void updateGame() {
    }


    // private JFrame frame = new JFrame("Mario");s
    // private JPanel panel;
    // private final Dimension DIM = new Dimension(800,700);
    // //private BejeweledGrid grid = new BejeweledGrid();
    // private Image background;
    // private Timer timer = new Timer(50,null);
    // public static void main(String[] args) {
    //   new MarioGame();
    //     GameFrame gf = new GameFrame("Mario");
    //    gf.setVisible(true);
    //    try {
    //     Image f = ImageIO.read(new File("C:/Images/BackgroundMario.png"));


    // } catch (IOException e) {
    //     String workingDir = System.getProperty("user.dir");
    //     System.out.println("Current working directory : " + workingDir);
    //     e.printStackTrace();

>>>>>>> eb4af1eff838d259b99a6ec23dde20aad5a86fe8
}
