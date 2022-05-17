<<<<<<< HEAD
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
=======
import java.io.File;
import java.util.Timer;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

>>>>>>> c6dc6c14b9eeb4b01fa3bef46c27ec9103033f34

public class Wall extends HitBox {
    private int x;
    private int y;
<<<<<<< HEAD
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

=======
    private int z;

    private Timer timer;
    public Wall(int x, int y, File f) {
        super(x,y,f);
    }
    public void move(){
        timer = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
                
			}
		});
		timer.start();

    }
    
>>>>>>> c6dc6c14b9eeb4b01fa3bef46c27ec9103033f34
}
