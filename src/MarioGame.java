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
import javax.swing.Timer;

public class MarioGame {
    private JFrame frame = new JFrame("Mario");
    private JPanel panel;
    private final Dimension DIM = new Dimension(800, 700);
    public static final int up = 0;
    public static final int right = 1;
    public static final int left = 2;
    // private BejeweledGrid grid = new BejeweledGrid();
    private Image background;
    // private Timer timer = new Timer(50,null);
    // new MarioGame();
    // GameFrame gf = new GameFrame("Mario");
    // gf.setVisible(true);
    private Mario mario;
    private Image image;
    private int score;
    private Image marioFace;
    private Wall wall;
    private int x = 15;
    private static int seconds;
    private Timer timer;
    private int z;
    private Background back;
    private boolean flip;

    public MarioGame() {
        score = 0;
        mario = new Mario(200, 275, true, new File("images/RightMario.png")); // y = 285, 140
        back = new Background();
        wall = new Wall(550, 290, new File("images/MarioWall.png"));

    }

    public void upHit(ActionEvent e) {
        seconds = 0;
        z = mario.getY() - mario.getHeight();
        flip = false;
        timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (seconds < 10) {
                    mario.moveY(-15);
                    if (mario.getDir() == true) {
                    mario.moveX(2);
                    }
                    else {
                        mario.moveX(-2);
                    }
                    // System.out.println(seconds);
                    seconds++;
                } else if (seconds < 21) {
                    mario.moveY(15);
                    if (mario.getDir() == true) {
                        mario.moveX(2);
                        }
                        else {
                            mario.moveX(-2);
                        }
                    seconds++;
                }

            }
        });
        timer.start();

    }

    public void ltHit(ActionEvent e) {
        x = 20;
        if (mario.checkCollision(wall) && mario.getX() > wall.getX()) {
            x = 0;
        }
        mario.setDir(false);
        mario.moveX(-x);

    }

    public void rtHit(ActionEvent e) {
        x = 15;
        if (mario.checkCollision(wall) && mario.getX() < wall.getX()) {
            x = 0;
        }

        mario.setDir(true);
        mario.moveX(x);
    }

    public void drawTheGame(Graphics g) {
        if (seconds == 20) {
            timer.stop();
        }
        back.draw(g);
        if (mario.getDir() == true) {
            mario.drawRight(g);
        } else if (mario.getDir() == false) {
            mario.drawLeft(g);
        }
        if (mario.checkCollision(wall)) {
            if (mario.getX() < wall.getX()) {
                mario.setX((wall.getX()) - mario.getWidth());
            }
            if (mario.getX() > wall.getX()) {
                mario.setX(wall.getX() + wall.getWidth());

            }
        }
        wall.draw(g);
        wall.moveX(-1);
    }
}
