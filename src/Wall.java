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
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;

public class Wall extends HitBox {
    private int x;
    private int y;
    private Image wall;
    public Wall(int x, int y, File f) {
        super(x,y,f);
    }
    public void draw(Graphics g) {
        try {
            wall = ImageIO.read(new File("images/MarioWall.png"));
            Image image = wall.getScaledInstance(40, 40, Image.SCALE_DEFAULT);
            g.drawImage(image, x, y, null);
        }
        catch(IOException e) {
            e.printStackTrace();
        }       
        //
        // g.drawImage(imagename, x coord, y coord, null )
            
    }
    public void setX(int z) {
        x +=z;
    }
    public void setY(int z) {
        y += z;
    }

}
