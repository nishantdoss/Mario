import java.io.File;

public class GameObject extends HitBox {
    private int x;
    private int y;
    public GameObject(int x, int y, File f) {
        super(x, y, f, 0,0);
    }
    
}
