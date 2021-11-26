import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StaticThing {
    public double x;
    public double y;
    private ImageView sprite;
    public double vue_x ;
    public double vue_y ;
    public void construct_StaticThing(double x, double y, String filename, double vue_x, double vue_y ) {
        this.x = x;
        this.y = y;
        Image image = new Image(filename);
        ImageView sprite = new ImageView(image);
        sprite.setX(x);
        sprite.setY(y);
        this.sprite = sprite;
        this.vue_x = vue_x;
        this.vue_y = vue_y;
        sprite.setViewport(new Rectangle2D(vue_x,vue_y,600,400));

    }

    public ImageView getImageView() {
        return sprite;
    }

}
