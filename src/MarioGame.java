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
    private JFrame frame = new JFrame("Mario");
    private JPanel panel;
    private final Dimension DIM = new Dimension(800,700);
    public static final int up = 0;
    public static final int right = 1;
    public static final int left = 2;
    //private BejeweledGrid grid = new BejeweledGrid();
    private Image background;
    private Timer timer = new Timer(50,null);
      // new MarioGame();
        //GameFrame gf = new GameFrame("Mario");
       // gf.setVisible(true);
    private Mario mario;
    private Image image;
    private int score;
    private Image marioFace;
    private Wall wall;
    //private BejeweledGrid grid = new BejeweledGrid();
    private Background back;
    public MarioGame() {
        score = 0;
        // try {
        //     File f = new File("Mario/images/BackgroundMario.png");
        //     System.out.println(f.getCanonicalPath());
        //     Image i = ImageIO.read(f);
        // } catch (IOException e) {
        //     String workingDir = System.getProperty("user.dir");
        //     System.out.println("Current working directory : " + workingDir);
        //     e.printStackTrace();
        // }
        // try {
        //     image = ImageIO.read(new File ("Mario/images/RightMario.png"));
        //     g.drawImage(mario, 200, 200, null);
        // }
        // catch(IOException e) {
        //     e.printStackTrace();
        // }       
            
        mario = new Mario(0, 285, true); // y = 285, 140
        back = new Background();
        wall = new Wall(810, 285, new File("images/MarioWall.jpeg"));

        // try {
        //     marioFace = ImageIO.read(new File("../images/LeftMario.png"));
        // }
        // catch (Exception e) {
        //     e.printStackTrace();
        // }
    }

    public void ltHit(ActionEvent e) {
        mario.setDir(false);
        mario.moveLeft(); 
        
    }
    public void rtHit(ActionEvent e) {
        mario.setDir(true);
        mario.moveRight();
    }
    public void drawTheGame(Graphics g) {
        back.draw(g);
        if (mario.getDir() == true) {
            mario.drawRight(g);
        }
        else if (mario.getDir() == false) {
            mario.drawLeft(g);
        }
        wall.draw(g);
       // wall.setX(-10);
    
    // public void ltHit(ActionEvent e) {
	// 	System.out.println("Left!!");
    //     Mario.move(left);
	// }

    // public void rtHit(ActionEvent e) {
    //     System.out.println("Right!");
    //     Mario.move(right);
	// }

    // public  void upHit(ActionEvent e) {
	// 	System.out.println("Up!!");
    //     Mario.move(up);
	// }
}
}
