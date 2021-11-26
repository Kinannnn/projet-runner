import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Camera {
    public int x=0;
    public int y;
    public double vx;
    public double vy;
    public double ax;
    public double ay;
    public double km=1;
    public double fm=-1.2;


    public void constructor_Camera (int a, int b)
    {
        this.x=a;
        this.y=b;
    }

    public int getX() {
        return x;
    }
    public int getY(){
        return y;
    }

    public String toString()
    {
        return "coordonnees camera x,y" + this.x +","+ this.y;
    }
    public void update(long time,int xhero,int yhero)
    {
        //x++;



        ax=km*(xhero-x)+(fm)*vx;
        vx+=ax*0.016;
        x+=vx*0.016;


    }
}
