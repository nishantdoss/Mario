import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MarioGame {
    public static void main(String[] args) {
        GameFrame gf = new GameFrame("Mario");
        gf.setVisible(true);

    }

    public void updateGame() {
		System.out.println("Moving Objects!!");
		moveObjects();
		checkCollisions();
    snake.collided();
	}
    /**
	 * Right now I am checking for collisions between GameObjects
	 */
	public void checkCollisions() {
		for (int i = 0; i < objects.size(); i++) {
      if (snake.getHead().collidedWith(objects.get(i))) {
        snake.addSegment();
        objects.remove(i);
        i--;
        makeApple();
      }
    }
	}

	/**
	 * get it...
	 */
	public void moveObjects() {
		snake.move();
	}


	/**
	 * Draws all the stuff in the game without changing them
	 * No reason to change this unless you wanted a background
	 * or something.
	 * @param g
	 */
    public void drawTheGame(Graphics g) {
		snake.draw(g);
		for(GameObject go:this.objects) {
			go.draw(g);
		}

	}
		
	
	/** called when the left arrow is pressed.  Probably move something
	 *  to the left, or turn left or... */
	public void ltHit(ActionEvent e) {
		System.out.println("Left!!");
    snake.turn(left);
	}

	/** called when the right arrow is pressed.  Probably move something
	 *  to the right, or turn right or... */
	public void rtHit(ActionEvent e) {
        
		System.out.println("Right!");
    snake.turn(right);
	}
	
	/** called when the up arrow is pressed.  You don't have to do anything
	 * here, but you can if your game uses this event*/
    public  void upHit(ActionEvent e) {
		System.out.println("Up!!");
    snake.turn(up);
	}
	
  public void downHit(ActionEvent e) {
    System.out.println("Down!");
    snake.turn(down);
  }

	

    

}
}
