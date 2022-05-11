public HitBox{
    private Rectangle hitBox;
    private int x;
    private int y;

    public class HitBox(File f){
        BufferedImage box = ImageIO.read(new File(f));
        this.hitBox = new Rectangle(x,y, box.getWidth(), box.getHeight());
    }

}