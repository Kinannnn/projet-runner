import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {

    public double x;
    public double y;
    public int attitude;
    public ImageView sprite;
    public int index;
    public int duration;
    public int maximum_index;
    public int size_x;
    public int size_y;
    public int offset;
    public int x_view;
    public int y_view;
    public int frame_period;

    public AnimatedThing (String a,double x, double y,int size_x, int size_y,int x_view,int y_view,int frame_period)
    {
        Image spritesheet = new Image(a);
        sprite = new ImageView(spritesheet);
        sprite.setViewport(new Rectangle2D(x_view,y_view,size_x,size_y));
        sprite.setY(y);
        sprite.setX(x);
    }
    public abstract void update(long time);


    public ImageView getSprite() {
        return sprite;
    }
}
