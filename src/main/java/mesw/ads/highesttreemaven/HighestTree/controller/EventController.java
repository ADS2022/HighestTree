package mesw.ads.highesttreemaven.HighestTree.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EventController {

    public void changeScene(String SceneName, ActionEvent event) throws IOException {
        Parent MainSceneParent = FXMLLoader.load(getClass().getResource(SceneName));
        Scene MainScene = new Scene(MainSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(MainScene);
        window.show();
    }

    public void btnSceneHomePress(ActionEvent actionEvent) throws IOException {
        System.out.println("Changing to Home scene");
        changeScene("/mesw/ads/highesttreemaven/HomeView.fxml", actionEvent);
    }

    public void btnAddEventPress(ActionEvent actionEvent) throws IOException {
        System.out.println("Adding a new Event record");
    }

    public void btnCancelPress(ActionEvent actionEvent) throws IOException {
        System.out.println("Changing to Events scene");
        changeScene("/fxml/EventsView.fxml", actionEvent);
    }


}
