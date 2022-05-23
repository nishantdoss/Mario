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

public class Mario extends HitBox {
    // private int x; //x coord
    // private int y; // y coord
    private int direction;
    private boolean right;
    private Image mario;
    private int MARIOWIDTH;
    private int MARIOHEIGHT;
    private int counter1 = 0;
    private Image image;
    final static int dimension = 60;
    // also add dimensions of mario as a final variable
    public Mario(int x, int y, boolean right, File f) {
        super(x, y, f, 60);
        this.right = right;
            

    //     else {
    //         try { mario = ImageIO.read(new File("images/RightMario.png"));
    //         mario = mario.getScaledInstance(-60, 60, Image.SCALE_DEFAULT);
    //     }
    //     catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }
        // this.x = x;
        // this. y = y;
        }
        public static int getDimension() {
            return dimension;
        }
    public Image getImage() {

        return image;
    }

    public void drawRight(Graphics g) {
        try {

            mario = ImageIO.read(new File("images/RightMario.png"));
            mario = mario.getScaledInstance(60, 60, Image.SCALE_DEFAULT);

            g.drawImage(mario, this.getX(), this.getY(), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //
        // g.drawImage(imagename, x coord, y coord, null )

    }

    public void drawLeft(Graphics g) {
        try {
            mario = ImageIO.read(new File("images/RightMario.png"));
            mario = mario.getScaledInstance(60, 60, Image.SCALE_DEFAULT);
            g.drawImage(mario, this.getX(), this.getY(), null);

            g.drawImage(mario, this.getX() + mario.getWidth(null), this.getY(), -mario.getWidth(null),
                    mario.getHeight(null), null);

        } catch (IOException e) {
            e.printStackTrace();
        }
        //
        // g.drawImage(imagename, x coord, y coord, null )

    }

    public boolean getDir() {
        return right;
    }

    public void setDir(boolean dir) {
        right = dir;
    }

    // public void moveRight(int y) {

    // this.x += y;
    // }
    // public void moveLeft(int y) {

    // this.x = x - y;
    // }
    // public void move(boolean direction) {
    // if(direction = right){
    // this.x += 5;
    // }
    // while(direction == MarioGame.left){
    // this.x -= 5;
    // }
    // }

    // Timer timer;
    // timer = new Timer(10, new ActionListener() {
    // @Override
    // public void actionPerformed(ActionEvent arg0) {
    // moveUp();
    // //System.out.println("1");
    // }
    // });

    // timer.start();

    public void moveUp() {

    }
    // if(direction = MarioGame.up){
    // y += 10;
    // }
}
        // if(direction = MarioGame.up){
        //     y += 10;
        // }


