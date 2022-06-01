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
public class Heart {
    private int x;
    private int y;
    private Image heart;
    private int d1 = 30;
    private int d2 = 30;
    public Heart(int x, int y) {
        this.x = x;
        this.y = y;
        try {

            heart = ImageIO.read(new File("images/Heart.png"));
            heart = heart.getScaledInstance(d1, d2, Image.SCALE_DEFAULT);
            //g.drawImage(heart, this.getX(), this.getY(), null);
            //g.drawImage(mario, this.getX(), this.getY(), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void draw(Graphics g) {
       
        g.drawImage(heart, this.getX(), this.getY(), null);
    }
}