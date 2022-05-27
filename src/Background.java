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
public class Background {
    private Image back;
    
    public Background() {

    }
    public void draw(Graphics g) {
        try {
            back = ImageIO.read(new File ("images/BackgroundMario.png"));
            g.drawImage(back, 0, 0, null);
        }
        catch(IOException e) {
            e.printStackTrace();
        }       
        //
        // g.drawImage(imagename, x coord, y coord, null )
            
    }
}
