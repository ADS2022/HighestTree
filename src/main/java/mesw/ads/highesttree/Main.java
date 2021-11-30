package mesw.ads.highesttree;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/register_a_place.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("styles/NewUI.css");

        primaryStage.setTitle("ADS register a place");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}