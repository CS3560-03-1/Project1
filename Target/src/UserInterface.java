import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.FileInputStream;

public class UserInterface extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {

        Scene homePage = new Scene(new GridPane(), 823, 463);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(homePage);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
