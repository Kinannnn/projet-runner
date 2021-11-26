import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.Random;

public class GameScene extends Scene {

    Camera camera1;
    StaticThing backgroundright;
    StaticThing backgroundleft;
    Hero hero = new Hero("heros.png",200,210,0);

    //StaticThing rightImage;
    public void update(long time)
    {
        backgroundright.getImageView().setViewport(new Rectangle2D(camera1.x%800,camera1.y+50,600,400));
        backgroundleft.getImageView().setViewport(new Rectangle2D((camera1.x%800)-800,camera1.y+50,600,400));
    }
    public GameScene(Group root, int v, int v1) {
        super(root, v, v1);
        ArrayList<Foe> Obstacles= new ArrayList<>();
       double x_obstacles=0;
        for (int i=0;i<10;i++)
        {
            x_obstacles=600+Math.random()*600+i*100;
            Obstacles.add(new Foe(x_obstacles,210,"heros.png"));
        }
        camera1 = new Camera();
        camera1.x=400;                                                                                    //position de la camera sur le background
        camera1.y=0;
        backgroundright = new StaticThing();
        backgroundleft = new StaticThing();
        AnimationTimer timer = new AnimationTimer(){

         public void handle(long time) {

                 hero.update(time);
                 camera1.update(time,hero.xhero,hero.yhero);
                 update(time);
                 for(int j=0;j<Obstacles.size();j++)
                 {
                     Obstacles.get(j).update(time);
                 }

         }
        };

        timer.start();
        backgroundright.construct_StaticThing(0,0,"desert.png",camera1.x, camera1.y+50);             //position de l'image ds la fenetre, le point d'origine du rectangle
        backgroundleft.construct_StaticThing(0,0,"desert.png", camera1.x-800, camera1.y+50);
        //leftImage = new StaticThing(0,0,"left");
       // rightImage = new StaticThing(400,0,"right");
        root.getChildren().add(backgroundright.getImageView());
        root.getChildren().add(backgroundleft.getImageView());
        root.getChildren().add(hero.getSprite());
        this.setOnKeyPressed ((KeyEvent e)->{

            if((e.getCode()== KeyCode.SPACE)&&(hero.autorise_jump==1))
            {
                System.out.println("Jump");
                hero.jump();
            }
        });

    }

}
