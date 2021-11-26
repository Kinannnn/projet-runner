import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



import static javafx.application.Application.launch;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Hello world");
        Group root = new Group();
       // Pane pane = new Pane(root);
        Scene theScene = new GameScene(root, 600, 350);
       // Image spriteSheet = new Image("heros.png");
        //ImageView sprite = new ImageView(spriteSheet);
        //sprite.setViewport(new Rectangle2D(20,0,65,100));
        //sprite.setX(200);                                                      //position bonhomme
       // sprite.setY(255);
        primaryStage.setScene(theScene);
        //root.getChildren().add(sprite);
        primaryStage.show();

    }



    public static void main(String[] args) {
        launch(args);
    }


}


