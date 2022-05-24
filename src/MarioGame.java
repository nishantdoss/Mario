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
    private Wall wall1;
    private Wall wall2;
    private Wall wall3;
    private Wall wall4;
    private Wall wall5;
    private Wall wall6;

    private int x = 15;
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
                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
//1200 x 350
    public MarioGame() {
        score = 0;
        mario = new Mario(200, 298, true, new File("images/LeftMario.png")); // y = 285, 140
        back = new Background();
        // wall1 = new Wall(550, 290, new File("images/MarioWall.png"));
        // wall2 = new Wall(586, 290, new File("images/MarioWall.png"));
        // wall3 = new Wall(550, 218, new File("images/MarioWall.png"));

        // wall4 = new Wall(658, 290, new File("images/MarioWall.png"));
        // wall5 = new Wall(586, 182, new File("images/MarioWall.png"));
        // wall5 = new Wall(586, 182, new File("images/MarioWall.png"));
        // //  wall6 = new Wall(690, 398, new File("images/MarioWall.png"));
        // // for (int i = 1; i < 3 i++) {
        // // objects.add("wall"+1);
        // // }
        // objects.add(wall1);
        // objects.add(wall2);
        // objects.add(wall3);
        // objects.add(wall4);
        // objects.add(wall5);
        // objects.add(wall6);
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
        changeY = 5;
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
        // System.out.println("slide");

    }

    public void upHit(ActionEvent e) {
        seconds = 0;
        // jumping = true;
        flip = false;
        timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (seconds < 11) {
                    seconds++;
                    jumping = true;
                    mario.moveY(-5);
                    if (mario.getDir() == true) {
                        mario.moveX(2);
                    } else {
                        mario.moveX(-2);
                    }
                    // System.out.println(seconds);
                } else if (seconds <= 21) {
                    seconds++;
                    if (mario.getY() < 298) {
                        fall();
                    }
                }

            }
        });
        timer.start();
        // jumping = false;
    }

    public void ltHit(ActionEvent e) {
        x = 20;
        if (mario.collidedObj(objects) != null) {
            if (mario.collidedHori(objects) == 1 && mario.getX() > mario.collidedObj(objects).getX()) {
                x = 0;
            }
        }
        mario.setDir(false);
        mario.moveX(-x);

    }

    public void rtHit(ActionEvent e) {
        x = 20;
        if (mario.collidedObj(objects) != null) {
            if (mario.collidedHori(objects) == 1 && mario.getX() > mario.collidedObj(objects).getX()) {
                x = 0;
            }
        }

        mario.setDir(true);
        mario.moveX(x);
    }

    public void drawTheGame(Graphics g) {
        if (jumping == true) {
        }

        if (!(mario.collidedObj(objects) == null)) {
            HitBox wall = mario.collidedObj(objects);
            if (mario.checkCollisionV(wall) == 2) {
                mario.setY(wall.getY() - wall.getHeight() + 4);
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
                    System.out.println("slide");
                    fall();
                }
            }
        }
        // if (mario.getY() < 298 && jumping == false && mario.collidedVert(objects) == 0) {
        //             System.out.println("slide");
        //     fall();
        // }
        if (seconds > 9) {
            jumping = false;
        }
        if (seconds == 21) {
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
            objects.get(i).moveX(-1);
        }
    }
}
