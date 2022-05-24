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

public class Mario extends HitBox {
    // private int x; //x coord
    // private int y; // y coord
    private int direction;
    private boolean right;
    private Image mario;
    private int MARIOWIDTH;
    private int MARIOHEIGHT;
    private int counter1 = 0;
    private Image image;
    final static int d1 = 21;
    final static int d2 = 28;
    // also add dimensions of mario as a final variable
    public Mario(int x, int y, boolean right, File f) {
        super(x, y, f, d1, d2);
        this.right = right;
            

    //     else {
    //         try { mario = ImageIO.read(new File("images/RightMario.png"));
    //         mario = mario.getScaledInstance(-60, 60, Image.SCALE_DEFAULT);
    //     }
    //     catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }
        // this.x = x;
        // this. y = y;
        }
        public static int getDimension() {
            return d1;
        }
    public Image getImage() {

        return image;
    }

    public void drawRight(Graphics g) {
        try {

            mario = ImageIO.read(new File("images/LeftMario.png"));
            mario = mario.getScaledInstance(d1, d2, Image.SCALE_DEFAULT);
            g.drawImage(mario, this.getX() + mario.getWidth(null), this.getY(), -mario.getWidth(null),
            mario.getHeight(null), null);
            //g.drawImage(mario, this.getX(), this.getY(), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //
        // g.drawImage(imagename, x coord, y coord, null )

    }
    public void drawUpR(Graphics g) {
        try {
            mario = ImageIO.read(new File("images/MarioJump.png"));
            mario = mario.getScaledInstance(28, 37, Image.SCALE_DEFAULT);
            g.drawImage(mario, this.getX(), this.getY(), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void drawUpL(Graphics g) {
        try {
            mario = ImageIO.read(new File("images/MarioJump.png"));
            mario = mario.getScaledInstance(28, 37, Image.SCALE_DEFAULT);
            g.drawImage(mario, this.getX() + mario.getWidth(null), this.getY(), -mario.getWidth(null),
            mario.getHeight(null), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawLeft(Graphics g) {
        try {
            mario = ImageIO.read(new File("images/LeftMario.png"));
            mario = mario.getScaledInstance(d1, d2, Image.SCALE_DEFAULT);
            g.drawImage(mario, this.getX(), this.getY(), null);

            //g.drawImage(mario, this.getX(), this.getY(), null);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean getDir() {
        return right;
    }

    public void setDir(boolean dir) {
        right = dir;
    }
}


