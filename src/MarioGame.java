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

public class MarioGame {
    private JFrame frame = new JFrame("Mario");
    private JPanel panel;
    private final Dimension DIM = new Dimension(800,700);
    //private BejeweledGrid grid = new BejeweledGrid();
    private Image background;
    private Timer timer = new Timer(50,null);
    public static void main(String[] args) {
      // new MarioGame();
        //GameFrame gf = new GameFrame("Mario");
       // gf.setVisible(true);
       try {
        Image f = ImageIO.read(new File("C:/Images/BackgroundMario.png"));
    } catch (IOException e) {
        String workingDir = System.getProperty("user.dir");
        System.out.println("Current working directory : " + workingDir);
        e.printStackTrace();

    }
    }
    private void start() {

}
}
