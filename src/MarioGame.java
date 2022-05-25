import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MarioGame {
    private JFrame frame = new JFrame("Mario");
    private JPanel panel;
    private final Dimension DIM = new Dimension(1200, 1700);
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
    private static int movingX;
    //private int x = 15;
    private static int seconds;
    private Timer timer;
    private int z;
    private Background back;
    private boolean flip;
    private static int seconds2;
    private boolean jumping;
    public ArrayList<HitBox> objects = new ArrayList<>();
    private static int changeX = 2;
    private static int changeY = 10;

    
    private Timer timer2;
    int[][] walls = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
//1200 x 350
    public MarioGame() {
        score = 0;
        mario = new Mario(200, 298, true, new File("images/LeftMario.png")); // y = 285, 140
        back = new Background();
        for (int r = 0; r< walls.length; r++){
            for (int c = 0; c< walls[0].length; c++) {
                if (walls[r][c] == 1) {
                    int x = c*36;
                    int y = r*36+3;
                    objects.add(new Wall(x, y, new File("images/MarioWall.png")));
                }
            }
        }
            }

    public void fall() {
        changeX = 0;
        changeY = 10;
        if (mario.collidedVert(objects) ==2 || mario.getY() >= 298) {
            changeX = 0;
            changeY = 0;
        }
        if (mario.getDir() == true) {
            mario.moveX(changeX);

        } else {
            mario.moveX(-changeX);
        }
        mario.moveY(changeY);

    }

    public void upHit(ActionEvent e) {
        seconds = 0;
        // jumping = true;
        flip = false;
        int marioHeight = mario.getY();
        timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (seconds <= 4 && mario.checkCollisionU(objects) == false) {
                    seconds++;
                    jumping = true;
                    mario.moveY(-10);
                    if (mario.getDir() == true) {
                        mario.moveX(2);
                    } else {
                        mario.moveX(-2);
                    }
                } 

            }
        });
        timer.start();
        // jumping = false;
    }

    public void ltHit(ActionEvent e) {
        movingX = -12;
        if (mario.collidedObj(objects) != null) {
            if (mario.collidedHori(objects) == 1 && mario.getX() > mario.collidedObj(objects).getX()) {
                movingX = 0;
            }
        }
        mario.setDir(false);

    }

    public void rtHit(ActionEvent e) {
        movingX = 12;
        if (mario.collidedObj(objects) != null) {
            if (mario.collidedHori(objects) == 1 && mario.getX() < mario.collidedObj(objects).getX()) {
                movingX = 0;
            }
        }

        mario.setDir(true);
    }

    public void drawTheGame(Graphics g) {
        mario.moveX(movingX);
        movingX = 0;
        if (!(mario.collidedObj(objects) == null)) {
            HitBox wall = mario.collidedObj(objects);
            if (mario.checkCollisionV(wall) == 2) {
                mario.setY(wall.getY() - wall.getHeight());
            }  
            if (mario.checkCollisionH(wall) == 1) {
                if (mario.getX() < wall.getX()) {
                    mario.setX((wall.getX()) - mario.getWidth());
                }
                if (mario.getX() > wall.getX()) {
                    mario.setX(wall.getX() + wall.getWidth());
                }
            }
           
        }
        if (jumping == false) {
            if (mario.getY() < 298) {
                if (mario.collidedObj(objects) == null) 
                {
                    fall();
                }
            }
        }
        if (seconds > 4) {
            jumping = false;
            timer.stop();
        }
        back.draw(g);
        if (mario.getDir() == true && jumping == true) {
            mario.drawUpR(g);
        } else if (mario.getDir() == true) {
            mario.drawRight(g);
        } else if (mario.getDir() == false && jumping == true) {
            mario.drawUpL(g);
        } else if (mario.getDir() == false) {
            mario.drawLeft(g);
        }
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).draw(g);
            objects.get(i).moveX(-3);
        }
    }
}
