package mesw.ads.highesttree.HighestTree;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

//TODO: change database files from .txt to JSON
public class Main extends Application {

    public static boolean isReadOnly = false;

    @Override
    public void start(Stage stage) throws IOException {

        //Javafx window title
        stage.setTitle("HighestTree");
        FXMLLoader root = new FXMLLoader(Main.class.getResource("HomeView.fxml"));
        Scene scene = new Scene(root.load());
        stage.setScene(scene);
        stage.show();

    }


    public static void main(String[] args) {

        launch();
    }
}