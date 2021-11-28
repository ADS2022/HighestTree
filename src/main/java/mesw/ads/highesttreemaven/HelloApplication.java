package mesw.ads.highesttreemaven;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        //Javafx window title
        stage.setTitle("HighestTree");

        FXMLLoader window = new FXMLLoader(HelloApplication.class.getResource("HomeView.fxml"));
        Scene HomeView = new Scene(window.load());
        stage.setScene(HomeView);
        stage.show();
    }
}