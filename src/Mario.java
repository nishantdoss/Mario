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
    private Image marioL;
    private Image marioR;
    private Image marioU;
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
        try {

            marioR = ImageIO.read(new File("images/LeftMario.png"));
            marioR = marioR.getScaledInstance(d1, d2, Image.SCALE_DEFAULT);
           // g.drawImage(mario, this.getX() + mario.getWidth(null), this.getY(), -mario.getWidth(null),
           // mario.getHeight(null), null);
            //g.drawImage(mario, this.getX(), this.getY(), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            marioU = ImageIO.read(new File("images/MarioJump.png"));
            marioU = marioU.getScaledInstance(28, 37, Image.SCALE_DEFAULT);
           // g.drawImage(marioU, this.getX(), this.getY(), null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        }
        public static int getDimension() {
            return d1;
        }
    public Image getImage() {

        return image;
    }

    public void drawRight(Graphics g) {
        g.drawImage(marioR, this.getX() + marioR.getWidth(null), this.getY(), -marioR.getWidth(null),
        marioR.getHeight(null), null);
        //
        // g.drawImage(imagename, x coord, y coord, null )

    }
    public void drawUpR(Graphics g) {
        g.drawImage(marioU, this.getX(), this.getY(), null);
    }
    public void drawUpL(Graphics g) {
        g.drawImage(marioU, this.getX() + marioU.getWidth(null), this.getY(), -marioU.getWidth(null),
            marioU.getHeight(null), null);
    }

    public void drawLeft(Graphics g) {
        g.drawImage(marioR, this.getX(), this.getY(), null);
    }

    public boolean getDir() {
        return right;
    }

    public void setDir(boolean dir) {
        right = dir;
    }
}
