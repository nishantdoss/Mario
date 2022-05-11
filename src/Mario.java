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

public class Mario extends GameObject{
    private int x; //x coord
    private int y; // y coord
    private int direction;
    private boolean right;
    private Image mario;
    //also add dimensions of mario as a final variable
    public Mario(int x, int y, boolean right) {
        this.x = x;
        this.y = y;
        this.right = right;

    }
<<<<<<< HEAD
    public Mario() {

    }
    public static void Move() {
        
    }
=======
>>>>>>> 9fb5af92651288db195097723c2d597f3fc38947

    public void draw(Graphics g) {
        try {
            mario = ImageIO.read(new File ("RightMario.png"));
            g.drawImage(mario, 200, 200, null);
        }
        catch(IOException e) {
            e.printStackTrace();
        }       
        //
        // g.drawImage(imagename, x coord, y coord, null )
            
    }
    public static void move(int newDirection) {
        Rectangle hitBox = new 
    }
}
