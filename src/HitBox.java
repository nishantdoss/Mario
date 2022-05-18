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

public class HitBox {
        private Rectangle hitBox;
        private int xCoor;
        private int yCoor;
        private Image object;
        private int objectWidth;
        private int objectHeight;


    
        public HitBox(int x, int y, File f){
            this.xCoor = x;
            this.yCoor = y;
            try {
                this.object = ImageIO.read(f);
                this.objectWidth = object.getWidth(null);
            } 
            catch (IOException e) {
              e.printStackTrace();
            } 
            try {
                this.object = ImageIO.read(f);
                this.objectHeight = object.getHeight(null);
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
        }

    public void checkCollision(){
        
    }


    
}
