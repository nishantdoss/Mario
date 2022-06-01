import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;

public class Wall extends HitBox {
    // private int x;
    // private int y;
    private Image wall;
    private final static int d1 = 36;
    private Image image;
    // int seconds = 0;
    // private Timer timer = new Timer();
    // TimerTask task = seconds++;
    public Wall(int x, int y, File f) {
        super(x, y, f, d1, d1);
        try {
            wall = ImageIO.read(f);
            image = wall.getScaledInstance(d1, d1, Image.SCALE_DEFAULT);
            //g.drawImage(image, this.getX(), this.getY(), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // this.x = x;
        // this.y = y;
    }

    public void draw(Graphics g) {
        g.drawImage(image, this.getX(), this.getY(), null);
       
    }

}
