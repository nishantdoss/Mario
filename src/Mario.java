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

public class Mario extends HitBox{
    private int x; //x coord
    private int y; // y coord
    private int direction;
    private boolean right;
    private Image mario;
    private int MARIOWIDTH;
    private int MARIOHEIGHT;


    

    
    //also add dimensions of mario as a final variable
    public Mario(int x, int y, boolean right) {
        this.x = x;
        this.y = y;
        this.right = right;
        try {
            mario = ImageIO.read(new File("images/RightMario.png"));
            MARIOWIDTH = mario.getWidth(null);
      } catch (IOException e) {
          e.printStackTrace();
      }
      try {
        mario = ImageIO.read(new File("images/RightMario.png"));
        MARIOHEIGHT = mario.getHeight(null);
      } catch (IOException e) {
        e.printStackTrace();
        }
    }

    public void drawRight(Graphics g) {
        try {
<<<<<<< HEAD
            mario = ImageIO.read(new File("RightMario.png"));
            g.drawImage(mario, 200, 200, null);
=======
            mario = ImageIO.read(new File("images/RightMario.png"));
            g.drawImage(mario, x, y, null);
>>>>>>> 5984b63a1b60f31f590200f2cdc7d9bc27a1438b
        }
        catch(IOException e) {
            e.printStackTrace();
        }       
        //
        // g.drawImage(imagename, x coord, y coord, null )
            
    }
    public void drawLeft(Graphics g) {
        try {
            mario = ImageIO.read(new File("images/LeftMario.png"));
            g.drawImage(mario, x, y, null);
        }
        catch(IOException e) {
            e.printStackTrace();
        }       
        //
        // g.drawImage(imagename, x coord, y coord, null )
            
    }
    public boolean getDir() {
        return right;
    }
    public void setDir(boolean dir) {
        right = dir;
    }
<<<<<<< HEAD
    public void moveRight() {
        this.x += 2;
    }
    public  void moveLeft() {
       this.x = x - 2;
====}
    public  void move(boolean direction) {
        if(direction = right){
            this.x += 5;
        }
<<<<<<< HEAD
        while(direction == MarioGame.left){
=======
        else if(direction = false){
>>>>>>> 5984b63a1b60f31f590200f2cdc7d9bc27a1438b
            this.x -= 5;
>>>>>>> ba3606a0e654c1b86e38faec17a24248fd142a26
        }
    public void moveUp() {
        
    }
        // if(direction = MarioGame.up){
        //     y += 10;
        // }
    }

