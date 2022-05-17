import java.io.File;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;


public class Wall extends HitBox {
    private int x;
    private int y;
    private int z;

    private Timer timer;
    public Wall(int x, int y, File f) {
        super(x,y,f);
    }
    public void move(){
        timer = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
                x += 5;
			}
		});
		timer.start();

    }
    
}
