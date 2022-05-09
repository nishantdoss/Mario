import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MarioGame {
    private JFrame frame = new JFrame("Mario");
    private JPanel panel;
    private final Dimension DIM = new Dimension(800,700);
    //private BejeweledGrid grid = new BejeweledGrid();
    private Image background;
    private Timer timer = new Timer(50,null);
    public static void main(String[] args) {
       new MarioGame().start();
    }
    private void start() {
        //GameFrame gf = new GameFrame("Mario");
       // gf.setVisible(true);
       try {
        File f = new File("BackgroundMario.png");
        background = ImageIO.read(f);
    } catch (Exception e) {
        e.printStackTrace();

    }
    }
	
	
    
}
