package mesw.ads.highesttreemaven.HighestTree.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class EventsController {
    @FXML
    private Button btnSceneHome, btnEventNew, btnEventEdit, btnEventDelete;

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

    public void btnEventNewPress(ActionEvent actionEvent) throws IOException {
        System.out.println("Adding new Event record");
        changeScene("/fxml/EventView.fxml", actionEvent);
    }

    public void btnEventEditPress(ActionEvent actionEvent) throws IOException {
        System.out.println("Editing event record");
        changeScene("/fxml/EventView.fxml", actionEvent);
    }

    public void btnEventDeletePress(ActionEvent actionEvent) throws IOException {
        System.out.println("Deleting event record");
        //changeScene("/mesw/ads/highesttreemaven/HomeView.fxml", actionEvent);

    }
}
