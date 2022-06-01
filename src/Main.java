import javax.swing.*;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GameFrame wnd = new GameFrame("Mario");
                wnd.setVisible(true);
                
            }
        });
    }
}