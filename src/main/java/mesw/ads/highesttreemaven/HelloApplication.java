package mesw.ads.highesttreemaven;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        //WORKING
        //Javafx window title
        stage.setTitle("HighestTree");

        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("HomeView.fxml"));
        Scene scene = new Scene(root.load());
        stage.setScene(scene);
        stage.show();

         /*

        Parent root = FXMLLoader.load(getClass().getResource("HomeView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();      */

    }

    public void goToPersonsMenu(ActionEvent actionEvent) {


    }
}