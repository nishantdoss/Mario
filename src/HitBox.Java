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
