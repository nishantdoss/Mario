<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> c6dc6c14b9eeb4b01fa3bef46c27ec9103033f34
=======
>>>>>>> 212c6ec9a0e92448849337258ad5afba070282b7
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

<<<<<<< HEAD
import javax.imageio.ImageIO;

public class HitBox {
    private Rectangle hitBox;
    private int x;
    private int y;

    public HitBox(int x, int y, File f) {
        this.x = x;
        this.y = y;
        try {
            BufferedImage box = ImageIO.read(f);
            this.hitBox = new Rectangle(x, y, box.getWidth(), box.getHeight());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
=======

import javax.imageio.ImageIO;
public class HitBox {
        private Rectangle hitBox;
        private int x;
        private int y;
        private Image object;
        private int objectWidth;
        private int objectHeight;


    
        public HitBox(int x, int y, File f){
            this.x = x;
            this.y = y;
            try {
                this.object = ImageIO.read(f);
                this.objectWidth = object.getWidth(null);
          } catch (IOException e) {
              e.printStackTrace();
          }
          try {
            this.object = ImageIO.read(f);
            this.objectHeight = f.getHeight(null);
          } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
<<<<<<< HEAD
=======
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
        private int x;
        private int y;
    
        public HitBox(int x, int y, File f){
            this.x = x;
            this.y = y;
            BufferedImage box = ImageIO.read(f);
            this.hitBox = new Rectangle(x,y, box.getWidth(), box.getHeight());
        }
    
    }
>>>>>>> f3b2ab6eb7001df6231711e025c85b513112bfc0
>>>>>>> c6dc6c14b9eeb4b01fa3bef46c27ec9103033f34
=======
>>>>>>> 212c6ec9a0e92448849337258ad5afba070282b7
