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

public class Goomba extends HitBox {
    private int direction;
    private boolean right;
    private Image goomba;
    private int GOOMBAWIDTH;
    private int GOOMBAHEIGHT;
    private int counter1 = 0;
    private Image image;
    final static int d1 = 21;
    final static int d2 = 28;
    // also add dimensions of mario as a final variable
    public Goomba(int x, int y, boolean right, File f) {
        super(x, y, f, d1, d2);
        this.right = right;
    }
    public static int getDimension() {
        return d1;
    }
public Image getImage() {

    return image;
}

public void draw(Graphics g) {
    try {
        goomba = ImageIO.read(new File("images/Gooomba.png"));
        goomba = goomba.getScaledInstance(d1, d2, Image.SCALE_DEFAULT);
        g.drawImage(goomba, this.getX() + goomba.getWidth(null), this.getY(), -goomba.getWidth(null),
        goomba.getHeight(null), null);
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

