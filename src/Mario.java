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
    public Mario(int x, int y, boolean right, File f) {
        super(x,y,f);
        this.right = right;
        }
    

    public void drawRight(Graphics g) {
        try {
           mario = ImageIO.read(new File("images/RightMario.png"));
           Image image = mario.getScaledInstance(60, 60, Image.SCALE_DEFAULT);
            g.drawImage(image, x, y, null);
        }
        catch(IOException e) {
            e.printStackTrace();
        }       
        //
        // g.drawImage(imagename, x coord, y coord, null )
            
    }
    public void drawLeft(Graphics g) {
        try {
            mario = ImageIO.read(new File("images/RightMario.png"));
            Image image = mario.getScaledInstance(60, 60, Image.SCALE_DEFAULT);
            g.drawImage(mario, x + image.getWidth(null), y, -image.getWidth(null), image.getHeight(null),null);

            
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

    public void moveRight() {
        this.x += 8;
    }
    public  void moveLeft() {
       this.x = x -8;
    }
    // public  void move(boolean direction) {
    //     if(direction = right){
    //         this.x += 5;
    //     }
    //     while(direction == MarioGame.left){
    //         this.x -= 5;
    //     }
    // }
    public void moveUp() {

    }
        // if(direction = MarioGame.up){
        //     y += 10;
        // }

}

