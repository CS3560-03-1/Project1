import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.FileInputStream;

public class UserInterface extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        FileInputStream inputStream = new FileInputStream("C:\\Users\\angel\\Desktop\\CS IDFK Obj Oriented\\Target\\targethomepage.png");
        Image pic = new Image(inputStream);
        ImageView picView = new ImageView(pic);

        Group page = new Group(picView);

        Scene homePage = new Scene(page, 823, 463);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(homePage);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
