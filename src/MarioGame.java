import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

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
    private Goomba goomba;
    private int goombaMove;
    private ArrayList<HitBox> goombas = new ArrayList<>();
    private int lives;
    private static final Font Font_Large = new Font("Times New Roman", Font.BOLD, 20);
    private Image end;
    
    private Timer timer2;
    int[][] walls = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 1, 1, 0, 0, 0, 0, 2, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
//1200 x 350
    public MarioGame() {
        score = 0;
        seconds2 =0;
        lives = 3;
        mario = new Mario(200, 298, true, new File("images/LeftMario.png")); // y = 285, 140
        back = new Background();
        goomba = new Goomba(300, 305, true, new File("images/Gooomba.png"));
        for (int r = 0; r< walls.length; r++){
            for (int c = 0; c< walls[0].length; c++) {
                if (walls[r][c] == 1) {
                    int x = c*36;
                    int y = r*36+3;
                    objects.add(new Wall(x, y, new File("images/MarioWall.png")));
                }
                else if (walls[r][c] == 2) {
                    int x = c * 36;
                    int y = r*36 +15;
                    goombas.add(new Goomba(x,y, true, new File("images/Gooomba.png")));
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
        seconds = 3;
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
        for (int i =0; i< goombas.size(); i++) {
            if (mario.checkCollision(goombas.get(i)) != 0) {
                lives--;
                mario.setX(400);
                mario.setY(50);
            }
        }
        if (mario.getX() <= 0) {
            lives--;
        }
        back.draw(g);
        g.setFont(Font_Large);
        g.drawString("Lives: " +  lives, 0,20);
        seconds2++;
        if (lives == 0) {
            try {
                end = ImageIO.read(new File ("images/GameOver.jpeg"));
                g.drawImage(end, 0, 0, null);
            }
            catch(IOException e) {
                e.printStackTrace();
            }
            System.exit(0);
        }
        
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
        for (int i =0; i< goombas.size(); i ++) {
            goombas.get(i).draw(g);
            if (seconds2 < 8) {
                goombaMove = 6;
                System.out.println("moving right");
    
                if (goombas.get(i).collidedObj(objects) !=  null) {
                    HitBox wall = goombas.get(i).collidedObj(objects);
                    goombas.get(i).setX(wall.getX() - goombas.get(i).getWidth()-4);
                }
                goombas.get(i).moveX(goombaMove);
            }
            else if (seconds2 < 24) {
                goombaMove = 7;
                System.out.println("moving left");
                if (goombas.get(i).collidedObj(objects) != null) {
                    HitBox wall = goombas.get(i).collidedObj(objects);
                    goombas.get(i).setX(wall.getX() + wall.getWidth() +4);
                }
                goombas.get(i).moveX(-goombaMove);
            }
        }
        
    
        
        if (seconds2 > 20) {
            seconds2 =0;
        }

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
