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

public class Pole extends HitBox {
    private static int d1 = 70;
    private static int d2 = 200;
    private Image pole;
    public Pole(int x, int y, File f) {
        super(x,y,f,d1, d2);
        try {
            pole = ImageIO.read(new File("images/Pole.png"));
            pole = pole.getScaledInstance(d1, d2, Image.SCALE_DEFAULT);
           // g.drawImage(pole, this.getX() + pole.getWidth(null), this.getY(), -pole.getWidth(null),
            //pole.getHeight(null), null);
            //g.drawImage(mario, this.getX(), this.getY(), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics g) {
        g.drawImage(pole, this.getX() + pole.getWidth(null), this.getY(), -pole.getWidth(null),
        pole.getHeight(null), null);
}

}
