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
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;

public class HitBox {
    private Rectangle hitBox;
    // private int x;
    // private int y;
    private Image image;
    private int objectWidth;
    private int objectHeight;
    private ArrayList<HitBox> objects;
    private Timer timer;

    public HitBox(int x, int y, File f, int x1, int x2) {
        // this.x = x;
        // this.y = y;
        // objectWidth = getImage().getWidth(null);
        // try {
        // this.object = ImageIO.read(f);
        // this.objectWidth = object.getWidth(null);
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        // try {
        // this.object = ImageIO.read(f);
        // this.objectHeight = object.getHeight(null);
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        try {
            image = ImageIO.read(f);
            image = image.getScaledInstance(x1, x2, Image.SCALE_DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        objectWidth = image.getWidth(null);
        objectHeight = image.getHeight(null);
        hitBox = new Rectangle(x, y, objectWidth, objectHeight);

    }

    public int collidedVert(ArrayList<HitBox> objects) {
        for (int i = 0; i < objects.size(); i++) {
            if (this.checkCollision(objects.get(i)) == 2) {
                // System.out.println("hit");
                return 2;
            }
        }
        return 0;
    }
    public int collidedHori(ArrayList<HitBox> objects) {
        for (int i = 0; i < objects.size(); i++) {
            if (this.checkCollision(objects.get(i)) == 1) {
                return 1;  
            }
        }
        return 0;
    }
    public HitBox collidedObj(ArrayList<HitBox> objects) {
        if (objects != null) {
        for (int i =0; i <objects.size(); i++) {
            if (this.checkCollision(objects.get(i)) != 0) {
                return objects.get(i);
            }
        }
    }
        return null;
    }
    public Rectangle getRec() {
        return hitBox;
    }

    public int getX() {
        return hitBox.x;
    }

    public int getY() {
        return hitBox.y;
    }

    public int getWidth() {
        return objectWidth;
    }

    public int getHeight() {
        return objectHeight;
    }

    public int checkCollision(HitBox h) {
        // return 0 if no collision, 1 if x, 2 if y
        if (this.hitBox.intersects(h.getRec())) {
            if (this.getY() <= h.getY()) {
                // System.out.println("vertical");
                return 2; }
             else if (hitBox.x + objectWidth >= h.getX() || hitBox.x <= h.getX() + h.getWidth()) {
                // System.out.println("horizontal"); 
                return 1;
             }
            }
        // System.out.println("no hit");
        return 0;
    }
    public int checkCollisionV(HitBox h) {
        if (this.hitBox.intersects(h.getRec())) {
            if (this.getY() <= h.getY()) {
                // System.out.println("vertical");
                return 2; }}
                return 0;
    }
    public int checkCollisionH(HitBox h) {
        if (this.hitBox.intersects(h.getRec())) {
            if (hitBox.x + objectWidth >= h.getX() || hitBox.x <= h.getX() + h.getWidth()) {
                // System.out.println("vertical");
                return 1; }}
                return 0;
    }
    public boolean checkCollisionU(ArrayList<HitBox> objects) {
        for (int i = 0; i < objects.size(); i++) {
            if (this.getRec().intersects(objects.get(i).getRec())) { 
                if (this.getY() > objects.get(i).getY()+ 6 && this.checkCollisionH(objects.get(i)) == 0) {
                    return true;
                }
            }
            }
            return false;
        }
    public void moveX(int y) {
        hitBox.translate(y, 0);
        // this.x += y;
    }

    public void moveY(int y) {
        hitBox.translate(0, y);
    }
    // public void moveLeft(int y) {

    // hitBox.translate(-y, 0);
    // }

    public void setX(int z) {
        hitBox.setLocation(z, hitBox.y);
    }

    public void setY(int x) {
        // double y = Math.sqrt(x*1.0) + z;
        hitBox.setLocation(hitBox.x, x);
    }

    public void draw(Graphics g) {
    }

}
